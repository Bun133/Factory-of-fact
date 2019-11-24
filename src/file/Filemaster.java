package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import assets.exception.CantCastToLong;
import assets.exception.Indexalreadyused;
import assets.exception.Indexnotsetup;

public class Filemaster {
	public File[] files;
	public String[] strpath;
	public Path[] path;
	public FileReader[] Filereader;
	public int[] usedarrayindex;


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
	}
	public void newFilelistener(String path,int index) throws FileNotFoundException, Indexalreadyused {
		loadFile(path,index);
	}

	private void loadFile(String path,int index) throws FileNotFoundException,Indexalreadyused {
		if (usedarrayindex[index]==0) usedarrayindex[index]=0;
		if (usedarrayindex[index]==1)throw new Indexalreadyused(index);
		File onetimefile=new File(path);
		if (onetimefile.exists()==false) {
			throw new FileNotFoundException(path);
		}
		strpath[index]=path;
		setPath(path,index);
		setFiler(onetimefile,index);
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

	public int[] bytearraytointarray(byte[] b) {
			int [] response = new int[b.length];
			for (int c=0;c!=b.length;c++){
					response[c]=bytetoint(b[c]);
			}
			return response;
	}


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
}
