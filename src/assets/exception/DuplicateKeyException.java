/***
 * Register用に作成した例外です。
 * キーが重複した場合に出されます。
 *
 * @version 1.0
 * @author nyuto
 */

package assets.exception;

public class DuplicateKeyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateKeyException(String msg){
		super(msg);
	}

}
