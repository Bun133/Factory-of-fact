package file;

import assets.exception.*;

import java.awt.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Filemaster {
	public File[] files;
	public String[] strpath;
	public Path[] path;
	public FileReader[] Filereader;
	public int[] usedarrayindex;
	public Image[] images;
	public String[] name;
	public ByteBuffer[] bbs;



	/**
	 * @apinote maxnumで使用するファイル数を指定してください。極端な数はなるべく避けてください。
	 * @param maxnum
	 */
	public Filemaster(int maxnum) {
		files=new File[maxnum];
		strpath=new String[maxnum];
		path=new Path[maxnum];
		Filereader=new FileReader[maxnum];
		usedarrayindex=new int[maxnum];
		images=new Image[maxnum];
		name=new String[maxnum];
	}
	public void newFilelistener(String path,int index) throws FileNotFoundException, Indexalreadyused {
		loadFile(path,index);
	}
	/**
	 * @apinote indexを指定しなくてもよい、重要性の低いファイルに対して使えます。
	 * @apinote また、intでindexを返します。これをもとに、頑張ってください。
	 * @apinote ﾒﾝﾄﾞｸｻｲとか言わない
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 * @throws Indexalreadyused
	 */
	public int newFilelistener(String path) throws FileNotFoundException, Indexalreadyused {
		int index = 0;
		while(usedarrayindex[index]!=0) {
			index++;
		}
		newFilelistener(path,index);
		return index;
	}


	/*public int getIndex(String filename) {
		int index=0;
		while(index!=name.length) {
			if (filename==getname(name[index])) {
				return index;
			}else {
				index++;
			}
		}
		throw new Indexnotsetup(filename);
	}*/
	private void loadFile(String path,int index) throws FileNotFoundException,Indexalreadyused {
		if (usedarrayindex[index]==1)throw new Indexalreadyused(index);
		if (usedarrayindex[index]==0) usedarrayindex[index]=1;

		File onetimefile=new File(path);
		if (onetimefile.exists()==false) {
			throw new FileNotFoundException(path);
		}
		strpath[index]=path;
		setPath(path,index);
		setFiler(onetimefile,index);
		if (getextension(index)=="bmp" || getextension(index)=="png") setImage(index);
		//if (getextension(index)=="") setbytebuffer(index);
		//name[index]=getname(onetimefile);
	}
/*
	private String getname(String s) {
		if (s.lastIndexOf("//")!=-1) {
			return s.substring(s.lastIndexOf("//")+1);
		}
		if (s.lastIndexOf("\\")!=-1) {
			return s.substring(s.lastIndexOf("//")+1);
		}
		return null;
	}
	private String getname(File file) {
		return  getname(file.toString());
	}
*/

/**
 * @apiNote extension(拡張子)をインデックスから返します。(多分基本的に使わん)
 * @return
 */
	public String getextension(int index) throws Indexnotsetup {
		if (usedarrayindex[index]==0) throw new Indexnotsetup(index);
		String extension=null;
		if (strpath[index].indexOf(".")!=-1) {
			extension=strpath[index].substring(strpath[index].indexOf(".")+1);
		}
		return extension;
	}

	/**
	 * @apinote ファイルをインデックスを頼りにStringListに変換します。
	 * @param index
	 * @return List<String>
	 * @throws IOException
	 */
	public List<String> toStringlist(int index) throws IOException,Indexnotsetup {
		List <String> response = Files.readAllLines(getpath(index));
		return response;
	}

	/**
	 * @apinote インデックスからtoStringlist()を経由し、String[]でファイルの中身を取り出します
	 * @param index
	 * @return String[]
	 * @throws IOException
	 */
	public String[] toStringarray(int index) throws IOException {
		List <String> onetimelist=toStringlist(index);
		String [] response;
		response=onetimelist.toArray (new String[onetimelist.size()]);
		return response;
	}


	public byte[] toBytearray(int index) throws IOException{
		byte[] response;
		response=Files.readAllBytes(path[index]);
		return response;
	}

	public int bytetoint(byte b) {
		int response = 0;
		response=(b & 0xff);
		return response;
	}

	/**
	 * @apinote byte[]toint[]
	 * @param b
	 * @return
	 */
	public int[] bytearraytointarray(byte[] b) {
			int [] response = new int[b.length];
			for (int c=0;c!=b.length;c++){
					response[c]=bytetoint(b[c]);
			}
			return response;
	}

/**
 * @apiNote byte[]をlong[]に変換します。理論上、byte[]の配列数は8の倍数となります。
 * @param b
 * @return long[]
 * @throws CantCastToLong
 */
	public long[] bytearraytolongarray(byte[] b) throws CantCastToLong {
		if (b.length%8!=0) throw new CantCastToLong(b.length);
		int onetime = b.length/4;
		if (b.length%8!=0) {
			onetime++;
		}
		long[] onetimelong=new long[onetime/8];
		ByteBuffer bb=ByteBuffer.allocate(8);
		for (int c=0;c!=onetime/8;c++) {
			bb.put(b[c*4+1]);
			bb.put(b[c*4+2]);
			bb.put(b[c*4+3]);
			bb.put(b[c*4+4]);
			bb.put(b[c*4+5]);
			bb.put(b[c*4+6]);
			bb.put(b[c*4+7]);
			bb.put(b[c*4+8]);
			bb.flip();
			onetimelong[c]=bb.getLong();
			bb.clear();
		}
		return onetimelong;
	}


	/**
	 *@apiNote Fileをいつか取得するとき用
	 * @param index
	 * @return File
	 * @throws Indexnotsetup
	 */
	public File getFiler(int index) throws Indexnotsetup{
		if (usedarrayindex[index]!=1)throw new Indexnotsetup(index);
		return files[index];
	}
	/**
	 * @param index(int)
	 * @return Path path
	 */
	public Path getpath(int index){
		return path[index];
	}

	public FileReader getFileReader(int index) throws IOException{
		if (usedarrayindex[index]!=1)throw new Indexnotsetup(index);

		return Filereader[index];
	}

	private void setPath(String s,int index) {
		path[index]=Path.of(s);
	}
	/**
	 *
	 * @param file
	 * @param index
	 */
	private void setFiler(File file,int index) {
		files[index]=file;
	}

	/**
	 * @apiNote なんかすげえ配列の表示めんどくさかったので作った
	 * @param String[] s
	 */
	public void printlnarray(String[] s) {
		for(int c=0;c!=s.length;c++) {
			System.out.println(s[c]);
		}
	}

	/**
	 * @apiNote なんかすげえ配列の表示めんどくさかったので作った
	 * @param int[] i
	 */
	public void printlnarray(int[] i) {
		for(int c=0;c!=i.length;c++) {
			System.out.println(i[c]);
		}
	}

	public void printlnarray(byte[] b) {
		for (int c=0;c!=b.length;c++) {
			System.out.println(b[c]);
		}
	}

	public void printlnarray(long[] l) {
		for(int c=0;c!=l.length;c++) {
			System.out.println(l[c]);
		}
	}



	/**
	 * @apiNote インデックスからImageを設定します
	 * @param index
	 */
	public void setImage(int index) {
		images[index]=Toolkit.getDefaultToolkit().getImage(strpath[index]);
	}


	/**
	 * @apinote インデックスからImageを取得します
	 * @param index
	 * @return
	 */
	public Image getImage(int index){
		if (images[index]==null) setImage(index);
		return images[index];
	}


	/**
	 * @apinote pathからbyte[]読み込み
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public byte[] getbyte(Path path) throws IOException {
		return Files.readAllBytes(path);
	}

	public byte[] getbyte(int index) throws IOException {
		return getbyte(getpath(index));

	}
	/**
	 * @apinote leftのカウントは左から1から始まります
	 * @apiNote 一番左の欲しいビットまでカウントしてください
	 * @param i
	 * @param left
	 * @return
	 */
	public long getbytenum_l(long i,int left) {
		return (i << (left-1)) >>> (left-1);
	}
	/**
	 * @apinote
	 * @apiNote rightのカウントは右から1から始まります
	 * @apinote 一番右の欲しいビットまでカウントしてください
	 * @param right
	 * @return
	 */
	public long getbytenum_r(long i,int right) {
		return (i >>> (right-1)) << (right-1);
	}

	/**
	 * @apinote 成功するかは知らん
	 * @param i
	 * @param left
	 * @param right
	 * @return
	 */
	public long getbytenum(long i,int left,int right) {
		return getbytenum_r(getbytenum_l(i,left),right+1);

	}



	public int getintnum(int data,int left,int right) {
		String onetime;
		onetime=String.valueOf(data);

		return Integer.valueOf(onetime.substring(left, right)).intValue();
	}




	/**
	 * @deprecated
	 * @apinote indexから最初の行を読みます。
	 * @apinote 主にbitで読む用
	 * @param index
	 * @return
	 * @throws IOException
	 */
	public String readline(int index) throws IOException {
		BufferedReader BR=new BufferedReader(getFileReader(index));
		return BR.readLine();
	}
	/**
	 * @deprecated
	 * @param index
	 * @return
	 * @throws IOException
	 */
	public byte[] getbytearray(int index) throws IOException {

		return readline(index).getBytes();
	}

	public int[] getintarray(byte[] b) throws IOException {
		int[] onetime=new int[b.length];
		int cnt=0;
		do {
			onetime[cnt]=ByteBuffer.wrap(b).getInt();
			cnt++;
		}
		while(onetime[cnt]!=0);


		return onetime;

	}

	public byte[] getbyte(String str) {
		return str.getBytes();
	}

	public long makelong(byte[] data) throws CantCastToLong{
		if (data.length!=8) throw new CantCastToLong(data.length);
		ByteBuffer BB=ByteBuffer.allocate(64);
		for (int cnt=0;cnt!=8;cnt++) {
			BB.put(data[cnt]);
		}
		BB.flip();
		return BB.getLong();
	}

	public long makelong(byte[] data,int left) {
		byte[] onetime=new byte[8];
		for (int cnt=0;cnt!=8;cnt++) {
			onetime[cnt]=data[cnt+left];
		}
		return makelong(onetime);
	}

	public int makeint(byte[] data) {
		if (data.length!=4) throw new CantCastToInt(data.length);
		ByteBuffer BB=ByteBuffer.allocate(32);
		for (int cnt=0;cnt!=4;cnt++) {
			BB.put(data[cnt]);
		}
		BB.flip();
		return BB.getInt();
	}

	public int makeint(byte[] data,int left) {
		byte[] onetime=new byte[4];
		for (int cnt=0;cnt!=4;cnt++) {
			onetime[cnt]=data[cnt+left];
		}
		return makeint(onetime);
	}

	public short makeshort(byte[] data) {
		if (data.length!=2) throw new CantCastToShort(data.length);
		ByteBuffer BB=ByteBuffer.allocate(16);
		BB.put(data[0]);
		BB.put(data[1]);
		BB.flip();
		return BB.getShort();
	}

	public short makeshort(byte[] data,int left) {
		byte[] onetime=new byte[2];
		onetime[0]=data[left];
		onetime[1]=data[left+1];
		return makeshort(onetime);
	}
}
