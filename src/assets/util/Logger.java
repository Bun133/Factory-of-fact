/**
 * デバッグ用メソッドです
 * 時間、開始からの経過時間(ms)呼び出したクラスも追加で表示します
 *
 * @version 1.4
 * @author nyuto
 */

package assets.util;


import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Logger extends PrintStream{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 3L;

	private Long upTime = System.currentTimeMillis();

	private boolean hideAll = false;

	private boolean hideInfo = false;

	private boolean hideWarn = false;

	private boolean hideError = false;

	private boolean hideException = false;

	private boolean hideDate = false;

	private boolean hideUpTime = false;

	private boolean hideLevel = false;

	private boolean hideCallClass = false;

	private boolean hideMessage = false;

	private boolean oneceFlag = false;

	private Color textColor = new Color(0,0,0);

	private Color oneceColor;

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

	private NumberFormat nf = NumberFormat.getNumberInstance();

	private String sep = System.lineSeparator();

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param out
	 */
	public Logger(OutputStream out) {
		super(out);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param out
	 * @param autoFlush
	 */
	public Logger(OutputStream out,boolean autoFlush) {
		super(out,autoFlush);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param out
	 * @param autoFlush
	 * @param encoding
	 * @throws UnsupportedEncodingException
	 */
	public Logger(OutputStream out,boolean autoFlush,String encoding) throws UnsupportedEncodingException{
		super(out,autoFlush,encoding);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param out
	 * @param autoFlush
	 * @param charset
	 */
	public Logger(OutputStream out,boolean autoFlush,Charset charset) {
		super(out,autoFlush,charset);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public Logger(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param fileName
	 * @param csn
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public Logger(String fileName,String csn) throws FileNotFoundException,UnsupportedEncodingException{
		super(fileName,csn);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param fileName
	 * @param charset
	 * @throws IOException
	 */
	public Logger(String fileName,Charset charset) throws IOException {
		super(fileName,charset);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param file
	 * @throws FileNotFoundException
	 */
	public Logger(File file) throws FileNotFoundException {
		super(file);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param file
	 * @param csn
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public Logger(File file,String csn) throws FileNotFoundException,UnsupportedEncodingException{
		super(file,csn);
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param file
	 * @param charset
	 * @throws IOException
	 */
	public Logger(File file,Charset charset) throws IOException{
		super(file,charset);
	}

	/**
	 * 全てのメッセージを表示するかを指定します
	 * @param flag
	 */
	public void hideAll(boolean flag) {
		hideAll = flag;
	}

	/**
	 * 通常メッセージ(INFO)を表示するかを指定します
	 * @param flag
	 */
	public void hideInfo(boolean flag) {
		hideInfo = flag;
	}

	/**
	 * 警告を(WARN)を表示するかを指定します
	 * @param flag
	 */
	public void hideWarn(boolean flag) {
		hideWarn = flag;
	}

	/**
	 * エラー(ERROR)を表示するかを指定します
	 * @param flag
	 */
	public void hideError(boolean flag) {
		hideError = flag;
	}

	/**
	 * 例外(EXVEPTION)を表示するかを指定します
	 * @param flag
	 */
	public void hideException(boolean flag) {
		hideException = flag;
	}

	/**
	 * 日付を表示するかを指定します
	 * @param flag
	 */
	public void hideDate(boolean flag) {
		hideDate = flag;
	}

	/**
	 * プログラムを起動してからの時間を表示するかを指定します
	 * @param flag
	 */
	public void hideUpTime(boolean flag) {
		hideUpTime = flag;
	}

	/**
	 * レベル(INFO、WARN、ERROR、EXCEPTION)を表示するかを指定します
	 * @param flag
	 */
	public void hideLevel(boolean flag) {
		hideLevel = flag;
	}

	/**
	 * 呼び出し元のクラスを表示するかを指定します
	 * @param flag
	 */
	public void hideCallClass(boolean flag) {
		hideCallClass = flag;
	}

	/**
	 * メッセージを表示するかを指定します
	 * @param flag
	 */
	public void hideMessage(boolean flag) {
		hideMessage = flag;
	}

	/**
	 * デフォルトの文字色に戻します
	 */
	public void setDefaultTextColor() {
		textColor = new Color(0,0,0);
	}

	/**
	 * 指定した文字色に設定します
	 * @param color Colorを渡してください。もし、nullが渡された場合はデフォルトの文字色に戻されます。
	 */
	public void setTextColor(Color color) {
		if(color == null) {
			setDefaultTextColor();
			return;
		}
		textColor = color;
	}

	/**
	 * 指定した文字色に設定します
	 * 作成に失敗した場合はデフォルトカラーに戻されます
	 * @param r 赤色の値を指定してください
	 * @param g 緑色の値を指定してください
	 * @param b 青色の値を指定してください
	 * @throws IllegalArgumentException
	 */
	public void setTextColor(int r,int g,int b) {
		textColor = new Color(r,g,b);
	}

	/**
	 * 指定した文字色を1度だけ適用します
	 * @param color
	 */
	public void setTextColorOnece(Color color) {
		if(color == null)return;
		oneceColor = color;
		oneceFlag = true;
	}

	/**
	 * 指定した文字色を一度だけ適用します
	 * 作成に失敗した場合は適用されません
	 * @param r 赤色の値を指定してください
	 * @param g 緑色の値を指定してください
	 * @param b 青色の値を指定してください
	 * @throws IllegalArgumentException
	 */
	public void setTextColorOnece(int r,int g,int b) {
		try {
			oneceColor = new Color(r,g,b);
			oneceFlag = true;
		}catch(IllegalArgumentException e) {
			oneceFlag = false;
			throw e;
		}
	}

	public void print(boolean b) {
		if(hideAll)return;
		if(hideInfo)return;
		pr("INFO",String.valueOf(b));
	}

	public void print(char c) {
		if(hideAll)return;
		if(hideInfo)return;
		pr("INFO",String.valueOf(c));
	}

	public void print(int i) {
		if(hideAll)return;
		if(hideInfo)return;
		pr("INFO",String.valueOf(i));
	}

	public void print(long l) {
		if(hideAll)return;
		if(hideInfo)return;
		pr("INFO",String.valueOf(l));
	}

	public void print(float f) {
		if(hideAll)return;
		if(hideInfo)return;
		pr("INFO",String.valueOf(f));
	}

	public void print(double d) {
		if(hideAll)return;
		if(hideInfo)return;
		pr("INFO",String.valueOf(d));
	}

	/**
	 * char配列のprintです
	 * ※自分の技量では実装できませんでした。
	 */
	public void print(char s[]) {
		if(hideAll)return;
		if(hideInfo)return;
		this.print(s);
	}

	public void print(String s) {
		if(s.equals(sep))sep();
		if(hideAll)return;
		if(hideInfo)return;
		pr("INFO",String.valueOf(s));
	}

	public void print(Object obj) {
		if(hideAll)return;
		if(hideInfo)return;
		pr("INFO",String.valueOf(obj));
	}

	public void println() {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO","");
	}

	public void println(boolean b) {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO",String.valueOf(b));
	}

	public void println(char c) {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO",String.valueOf(c));
	}

	public void println(int i) {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO",String.valueOf(i));
	}

	public void println(long l) {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO",String.valueOf(l));
	}

	public void println(float f) {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO",String.valueOf(f));
	}

	public void println(double d) {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO",String.valueOf(d));
	}

	/**
	 * char配列のprintlnです
	 * ※自分の技量では実装できませんでした。
	 */
	public void println(char s[]) {
		if(hideAll)return;
		if(hideInfo)return;
		this.println(s);
	}

	public void println(String s) {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO",String.valueOf(s));
	}

	public void println(Object obj) {
		if(hideAll)return;
		if(hideInfo)return;
		pl("INFO",String.valueOf(obj));
	}

	public void printNoAdd(String str) {
		if(hideAll)return;
		if(hideInfo)return;
		napr(str);
	}

	public void printlnNoAdd(String str) {
		if(hideAll)return;
		if(hideInfo)return;
		napl(str);
	}

	public void printWarn(String str) {
		if(hideAll)return;
		if(hideWarn)return;
		setTextColorOnece(new Color(170,85,0));
		pl("WARN",str);
	}

	public void printError(String str) {
		if(hideAll)return;
		if(hideError)return;
		setTextColorOnece(new Color(252,127,0));
		pl("ERROR",str);
	}

	public void printException(String str) {
		if(hideAll)return;
		if(hideException)return;
		setTextColorOnece(Color.RED);
		pl("EXCEPTION",str);
	}

	public void printException(Exception e) {
		if(hideAll)return;
		if(hideException)return;
		pl("EXCEPTION", e.toString());
		e.printStackTrace(this);
	}

	private void pl(String level,String str) {
		Color color = oneceFlag?oneceColor:textColor;
		oneceFlag = false;
		String text = "\u001b[38;2" + ";" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
		if(!hideDate) {
			synchronized(sdf) {
				text += "[" + sdf.format(Calendar.getInstance().getTime()) + "]";
			}
		}
		if(!hideUpTime) {
			Long time = System.currentTimeMillis();
			text += "[" + nf.format(time - upTime) + "]";
		}
		if(!hideLevel) {
			text += "[" + level + "]";
		}
		if(!hideCallClass) {
			text += "(" + Thread.currentThread().getStackTrace()[3].getClassName() + ":" + Thread.currentThread().getStackTrace()[3].getLineNumber() + ")";
		}
		if(!hideMessage) {
			text += str;
		}
		text += "\u001b[00m";
		super.print(text);
		super.print(sep);

	}

	private void pr(String level,String str) {
		Color color = oneceFlag?oneceColor:textColor;
		oneceFlag = false;
		String text = "\u001b[38;2" + ";" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
		if(!hideDate) {
			synchronized(sdf) {
				text += "[" + sdf.format(Calendar.getInstance().getTime()) + "]";
			}
		}
		if(!hideUpTime) {
			Long time = System.currentTimeMillis();
			text += "[" + nf.format(time - upTime) + "]";
		}
		if(!hideLevel) {
			text += "[" + level + "]";
		}
		if(!hideCallClass) {
			text += "(" + Thread.currentThread().getStackTrace()[3].getClassName() + ":" + Thread.currentThread().getStackTrace()[3].getLineNumber() + ")";
		}
		if(!hideMessage) {
			text += str;
		}
		text += "\u001b[00m";
		super.print(text);
	}

	private void napl(String str) {
		Color color = oneceFlag?oneceColor:textColor;
		oneceFlag = false;
		String text = "\u001b[38;2" + ";" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
		if(!hideMessage) {
			text += str;
		}
		text += "\u001b[00m";
		super.print(text);
		super.print(sep);
	}

	private void napr(String str) {
		Color color = oneceFlag?oneceColor:textColor;
		oneceFlag = false;
		String text = "\u001b[38;2" + ";" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
		if(!hideMessage) {
			text += str;
		}
		text += "\u001b[00m";
		super.print(text);
	}

	private void sep() {
		super.print(sep);
	}
}