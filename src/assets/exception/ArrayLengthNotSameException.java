/**
 * ConfigTransformer用に作成した例外です
 * 配列の長さが違う場合に使用されます
 *
 * @version 1.0
 * @author nyuto
 */

package assets.exception;

public class ArrayLengthNotSameException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ArrayLengthNotSameException(String msg) {
		super(msg);
	}
}
