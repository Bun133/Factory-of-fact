package assets.exception;

public class Indexnotsetup extends RuntimeException{

	public Indexnotsetup(int index) {
		super("Index not setup. Index num:"+index);
	}


}
