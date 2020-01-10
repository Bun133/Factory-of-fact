package graphics;

import java.awt.Image;
import java.io.FileNotFoundException;

import assets.exception.Indexalreadyused;
import file.Filemaster;

public class TextureManager {
	private Filemaster Fm;
	private String[] Textureids;
	private int Max_ids=0;
	public TextureManager(int maxnum) {
		Fm=new Filemaster(maxnum);
		Textureids=new String[maxnum];
	}

	public void addtexture(String path,int num) throws FileNotFoundException, Indexalreadyused {
		Fm.newFilelistener(path, num);
	}

	public Image gettexture(int num) {
		return Fm.getImage(num);
	}

	public void addtextureid(int num,String id) {
		Textureids[num]=id;
		if (num>Max_ids) Max_ids=num;
	}

	public void addtexture(String path,int num,String id) throws FileNotFoundException, Indexalreadyused {
		addtexture(path,num);
		addtextureid(num,id);
	}

	private int getnum_from_id(String id) {
		for(int cnt=0;cnt!=Max_ids+1;cnt++) {
			if (Textureids[cnt]==id) return cnt;
		}
		return -1;
	}

	public Image gettexture(String id) {
		return gettexture(getnum_from_id(id));
	}
}
