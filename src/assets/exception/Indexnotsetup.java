package assets.exception;

public class Indexnotsetup extends RuntimeException{

	public Indexnotsetup(int index) {
		super("Index not setup. Index num:"+index);
	}

	public Indexnotsetup(String s) {
		super("Index not setup. Name is:"+s);
	}


}
