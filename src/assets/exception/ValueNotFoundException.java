/***
 * Register用に作成した例外です。
 * 指定したキーの値を発見できなかった場合に出されます。
 *
 * @version 1.0
 * @author nyuto
 */

package assets.exception;

public class ValueNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValueNotFoundException(String msg){
		super(msg);
	}
}
