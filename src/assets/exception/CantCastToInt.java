package assets.exception;

public class CantCastToInt extends RuntimeException{
	public CantCastToInt(int length) {
		System.out.println("Intへ変換するにはbyteのlengthは4である必要があります。");
		System.out.println("実際は:"+length);
	}
}
