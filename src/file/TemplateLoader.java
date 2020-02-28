package file;

import assets.exception.Indexalreadyused;
import assets.exception.NotMatch;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

/**
 * @author Bun133
 * @version 1.0
 */
public class TemplateLoader {
	private Filemaster Fm = new Filemaster(100);

	//loadセクション
	public void loadmap(Path path, String name) throws IOException {
		//TODO Pathの変換やらが必要
		String path_s = new String();
		path_s = path.toString();
		loaddata(path_s + "level.data");    //dataファイル
		loadpdata(Path.of(path_s + "\\playerdata\\" + name + "\\data.pdata")); //pdataファイル
		loadimeta(Path.of(path_s + "\\playerdata\\" + name + "\\inventory.imeta"));//imetaファイル
		loadcdata(Path.of(path_s + "\\playerdata\\" + name + "\\adddata.cdata"));//Cdataファイル
		loadbdata(Path.of(path_s + "\\world\\chunkID\\base.bmeta"));//bmetaファイル
	}

	//dataファイル
	private Properties D_properties = new Properties();

	private void loaddata(String path) {

	}
	private void loaddata(Path path) throws IOException {
		InputStream instream = new FileInputStream(path.toString());
		D_properties.load(instream);
	}

	//pdataファイル
	private long P_FormatUUID;
	private long PlayerUUID;
	private int HP_NOW;
	private int HP_MAX;
	private int MP_NOW;
	private int MP_MAX;
	private long XP;
	private long Level;
	private int P_STR;
	private int P_DEX;
	private int P_VIT;
	private int P_AGI;
	private int P_INT;
	private int P_MND;
	private int P_LUK;
	private int P_CRI;
	private int Chunk_X;
	private int Pos_X;
	private int Chunk_Y;
	private int Pos_Y;


	private void loadpdata(Path path) throws Indexalreadyused, IOException {
		Fm.newFilelistener(path.toString(), 10);
		if (Fm.getbyte(10).length != 96) throw new NotMatch(path);
		P_FormatUUID = Fm.makelong(Fm.getbyte(10), 0);
		PlayerUUID = Fm.makelong(Fm.getbyte(10), 8);
		HP_NOW = Fm.makeint(Fm.getbyte(10), 16);
		HP_MAX = Fm.makeint(Fm.getbyte(10), 20);
		MP_NOW = Fm.makeint(Fm.getbyte(10), 24);
		MP_MAX = Fm.makeint(Fm.getbyte(10), 28);
		XP = Fm.makelong(Fm.getbyte(10), 32);
		Level = Fm.makelong(Fm.getbyte(10), 40);
		P_STR = Fm.makeint(Fm.getbyte(10), 48);
		P_DEX = Fm.makeint(Fm.getbyte(10), 52);
		P_VIT = Fm.makeint(Fm.getbyte(10), 56);
		P_AGI = Fm.makeint(Fm.getbyte(10), 60);
		P_INT = Fm.makeint(Fm.getbyte(10), 64);
		P_MND = Fm.makeint(Fm.getbyte(10), 68);
		P_LUK = Fm.makeint(Fm.getbyte(10), 72);
		P_CRI = Fm.makeint(Fm.getbyte(10), 76);
		Chunk_X = Fm.makeint(Fm.getbyte(10), 80);
		Pos_X = Fm.makeint(Fm.getbyte(10), 84);
		Chunk_Y = Fm.makeint(Fm.getbyte(10), 88);
		Pos_Y = Fm.makeint(Fm.getbyte(10), 92);

	}

	//imetaファイル
	private boolean ItemFlug;
	private int Inventory;
	private int Damage;
	private boolean stack;
	private int ItemID;
	private int mass;
	//IF ItemFlug = true
	private int Stacks;
	//IF ItemFlug = false
	private int I_STR;
	private int I_DEX;
	private int I_VIT;
	private int I_AGI;
	private int I_INT;
	private int I_MND;
	private int I_LUK;
	private int I_CRI;


	private void loadimeta(Path path) throws Indexalreadyused, IOException {
		Fm.newFilelistener(path.toString(), 11);
		// (bit)00000000 = (INT)0
		// (bit)10000000 = (INT)-128

		if (Fm.makeint(Fm.getbyte(11), 0) == 0) {
			ItemFlug = false;
		}

		if (Fm.makeint(Fm.getbyte(11), 0) == -128) {
			ItemFlug = true;
		}

		Inventory = Fm.makeint(Fm.getbyte(11), 4);
		Damage = Fm.makeint(Fm.getbyte(10), 8);

		if (Fm.makeint(Fm.getbyte(11), 12) == 0) {
			stack = false;
		}

		if (Fm.makeint(Fm.getbyte(11), 12) == -128) {
			stack = true;
		}

		mass = Fm.makeint(Fm.getbyte(11), 16);

		if (ItemFlug) {
			Stacks = Fm.makeint(Fm.getbyte(11), 20);
		} else {
			I_STR = Fm.makeint(Fm.getbyte(11), 24);
			I_DEX = Fm.makeint(Fm.getbyte(11), 28);
			I_VIT=Fm.makeint(Fm.getbyte(11),32);
			I_AGI=Fm.makeint(Fm.getbyte(11),36);
			I_INT=Fm.makeint(Fm.getbyte(11),40);
			I_MND=Fm.makeint(Fm.getbyte(11),44);
			I_LUK=Fm.makeint(Fm.getbyte(11),48);
			I_CRI=Fm.makeint(Fm.getbyte(11),52);
		}
	}

	//Cdataファイル
	private Properties C_properties=new Properties();

	private void loadcdata(Path path) throws Indexalreadyused, IOException {
		InputStream instream=new FileInputStream(path.toString());
		C_properties.load(instream);
	}


	//Bdataファイル

	private long B_FormatUUID;
	private byte[] Base;
	private int[] Ore_ID;		//TODO 上位24bitのみがIDとなる。
	private int[] Ore_quantity;

	private void loadbdata(Path path) throws Indexalreadyused, IOException {
		Fm.newFilelistener(path.toString(),11);
		int length=Fm.getbyte(11).length;
		if (length%8!=0) throw new NotMatch(path);
		if (length==8 || length==0) throw new NotMatch(path);
		B_FormatUUID=Fm.makelong(Fm.getbyte(11),0);
		for (int cnt=0;cnt!=length/8;cnt++) {
			Base[cnt]=Fm.getbyte(11)[cnt*8+1];
			Ore_ID[cnt]=Fm.makeint(Fm.getbyte(11),cnt*8+2) >>> 8;
			Ore_quantity[cnt]=Fm.makeint(Fm.getbyte(11),cnt*8+4);
		}
	}

	//mmetaファイル
	private long M_FormatUUID;
	private int[] M_MachineID;
	private short[] M_AnimachionID;
	private boolean[] M_Item;
	private int[] M_Pos_X;
	private int[] M_Pos_Y;



	private void loadmdata(Path path) throws IOException {
		Fm.newFilelistener(path.toString(), 12);
		if ((Fm.getbyte(12).length-8)%16!=0) throw new NotMatch();
		M_FormatUUID=Fm.makelong(Fm.getbyte(12),0);
		for (int cnt=0;cnt!=(Fm.getbyte(12).length-8)/16;cnt++) {
			M_MachineID[cnt]=Fm.makeint(Fm.getbyte(12),cnt*16+8) >>> 8;
			M_AnimachionID[cnt]=Fm.makeshort(Fm.getbyte(12),cnt*16+3+8);
			if (Fm.getbyte(12)[cnt*16+5+8]==0x00) {
				M_Item[cnt]=false;
			}

			if (Fm.getbyte(12)[cnt*16+5+8]==0x989680) {
				M_Item[cnt]=true;
			}
			M_Pos_X[cnt]=Fm.makeint(Fm.getbyte(12),cnt*16+8+8);
			M_Pos_Y[cnt]=Fm.makeint(Fm.getbyte(12),cnt*16+12+8);
		}

	}

}


