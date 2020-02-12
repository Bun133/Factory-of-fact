package assets.exception;

public class CantCastToShort extends RuntimeException{
	public CantCastToShort(int length) {
		System.out.println("byte[]からshortに変換するにはlengthは2である必要がありますが、実際は:"+length+"でした");
	}

}
