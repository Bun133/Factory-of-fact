package assets.exception;

public class Indexalreadyused extends RuntimeException{
	public Indexalreadyused(int index) {
		super("Alredy used index "+index);
	}
}
