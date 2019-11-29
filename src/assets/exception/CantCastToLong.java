package assets.exception;

public class CantCastToLong extends RuntimeException {
	public CantCastToLong(int length) {
		super("byteからlongへの変換は、byte配列数が8で割り切れなければいけませんが、実際は"+length+"個でした。");
	}
}
