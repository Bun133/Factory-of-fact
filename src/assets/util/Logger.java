/**
 * デバッグ用メソッドです
 * 時間、開始からの経過時間(ms)呼び出したクラスも追加で表示します
 *
 * @version 1.5
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
import java.util.Calendar;

public class Logger extends PrintStream{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 4L;

	private Long upTime = System.currentTimeMillis();

	private boolean showAll = true;

	private boolean showInfo = true;

	private boolean showWarn = true;

	private boolean showError = true;

	private boolean showException = true;

	private boolean showDate = true;

	private boolean showUpTime = true;

	private boolean showLevel = true;

	private boolean showCallClass = true;

	private boolean showMessage = true;

	private boolean oneceFlag = false;

	private Color textColor = new Color(0,0,0);

	private Color oneceColor;

	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

	private NumberFormat nf = NumberFormat.getNumberInstance();

	private String sep = System.lineSeparator();

	private StringBuilder builder[];

	private boolean used[];

	private boolean needRefresh[];

	private boolean refthread = false;

	private boolean watchFlag = false;

	private int usePos = 0;

	private int refreshPos = 0;

	private int builderLen;

	private Thread refresh;

	private Thread watchdog;

	private static int runNum = 1;

	private static int watchNum = 1;

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param out
	 */
	public Logger(OutputStream out) {
		super(out);
		initBuilder();
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param out
	 * @param autoFlush
	 */
	public Logger(OutputStream out,boolean autoFlush) {
		super(out,autoFlush);
		initBuilder();
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
		initBuilder();
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
		initBuilder();
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public Logger(String fileName) throws FileNotFoundException {
		super(fileName);
		initBuilder();
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
		initBuilder();
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
		initBuilder();
	}

	/**
	 * Loggerのコンストラクタです
	 * 基本的にはPrintStreamと同じです
	 * @param file
	 * @throws FileNotFoundException
	 */
	public Logger(File file) throws FileNotFoundException {
		super(file);
		initBuilder();
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
		initBuilder();
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
		initBuilder();
	}

	/**
	 * StringBuilder及び、それ関連のクラスの初期化です
	 */
	private void initBuilder() {
		 builderLen = (int)(Runtime.getRuntime().availableProcessors() * 1.5);
		builderLen = builderLen < 10 ? 10 : builderLen;
		builder = new StringBuilder[builderLen];
		used = new boolean[builderLen];
		needRefresh = new boolean[builderLen];
		usePos = 0;
		for(int i=0;i<builderLen;i++) {
			builder[i] = new StringBuilder();
			used[i] = false;
			needRefresh[i] = false;
		}
	}

	private synchronized int getRunNum() {
		return runNum++;
	}

	private synchronized int getWatchNum() {
		return watchNum++;
	}


	/**
	 * 全てのメッセージを表示するかを指定します
	 * @param flag
	 */
	public void showAll(boolean flag) {
		showAll = flag;
	}

	/**
	 * 通常メッセージ(INFO)を表示するかを指定します
	 * @param flag
	 */
	public void showInfo(boolean flag) {
		showInfo = flag;
	}

	/**
	 * 警告を(WARN)を表示するかを指定します
	 * @param flag
	 */
	public void showWarn(boolean flag) {
		showWarn = flag;
	}

	/**
	 * エラー(ERROR)を表示するかを指定します
	 * @param flag
	 */
	public void showError(boolean flag) {
		showError = flag;
	}

	/**
	 * 例外(EXVEPTION)を表示するかを指定します
	 * @param flag
	 */
	public void showException(boolean flag) {
		showException = flag;
	}

	/**
	 * 日付を表示するかを指定します
	 * @param flag
	 */
	public void showDate(boolean flag) {
		showDate = flag;
	}

	/**
	 * プログラムを起動してからの時間を表示するかを指定します
	 * @param flag
	 */
	public void showUpTime(boolean flag) {
		showUpTime = flag;
	}

	/**
	 * レベル(INFO、WARN、ERROR、EXCEPTION)を表示するかを指定します
	 * @param flag
	 */
	public void showLevel(boolean flag) {
		showLevel = flag;
	}

	/**
	 * 呼び出し元のクラスを表示するかを指定します
	 * @param flag
	 */
	public void showCallClass(boolean flag) {
		showCallClass = flag;
	}

	/**
	 * メッセージを表示するかを指定します
	 * @param flag
	 */
	public void showMessage(boolean flag) {
		showMessage = flag;
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
		if(showAll)if(showInfo)pr("INFO",String.valueOf(b));
	}

	public void print(char c) {
		if(showAll)if(showInfo)pr("INFO",String.valueOf(c));
	}

	public void print(int i) {
		if(showAll)if(showInfo)pr("INFO",String.valueOf(i));
	}

	public void print(long l) {
		if(showAll)if(showInfo)pr("INFO",String.valueOf(l));
	}

	public void print(float f) {
		if(showAll)if(showInfo)pr("INFO",String.valueOf(f));
	}

	public void print(double d) {
		if(showAll)if(showInfo)pr("INFO",String.valueOf(d));
	}

	/**
	 * char配列のprintです
	 * ※自分の技量では(面倒で)実装できませんでした。
	 */
	public void print(char s[]) {
		if(showAll)if(showInfo)this.print(s);
	}

	public void print(String s) {
		if(showAll)if(showInfo)pr("INFO",String.valueOf(s));
	}

	public void print(Object obj) {
		if(showAll)if(showInfo)pr("INFO",String.valueOf(obj));
	}

	public void println() {
		if(showAll)if(showInfo)pl("INFO","");
	}

	public void println(boolean b) {
		if(showAll)if(showInfo)pl("INFO",String.valueOf(b));
	}

	public void println(char c) {
		if(showAll)if(showInfo)pl("INFO",String.valueOf(c));
	}

	public void println(int i) {
		if(showAll)if(showInfo)pl("INFO",String.valueOf(i));
	}

	public void println(long l) {
		if(showAll)if(showInfo)pl("INFO",String.valueOf(l));
	}

	public void println(float f) {
		if(showAll)if(showInfo)pl("INFO",String.valueOf(f));
	}

	public void println(double d) {
		if(showAll)if(showInfo)pl("INFO",String.valueOf(d));
	}

	/**
	 * char配列のprintlnです
	 * ※自分の技量では実装できませんでした。
	 */
	public void println(char s[]) {
		if(showAll)if(showInfo)this.println(s);
	}

	public void println(String s) {
		if(showAll)if(showInfo)pl("INFO",String.valueOf(s));
	}

	public void println(Object obj) {
		if(showAll)if(showInfo)pl("INFO",String.valueOf(obj));
	}

	public void printNoAdd(String str) {
		if(showAll)if(showInfo)napr(str);
	}

	public void printlnNoAdd(String str) {
		if(showAll)if(showInfo)napl(str);
	}

	public void printWarn(String str) {
		if(showAll)if(showWarn) {
			setTextColorOnece(new Color(170,85,0));
			pl("WARN",str);
		}
	}

	public void printError(String str) {
		if(showAll)if(showError) {
			setTextColorOnece(new Color(252,127,0));
			pl("ERROR",str);
		}
	}

	public void printException(String str) {
		if(showAll)if(showException){
			setTextColorOnece(Color.RED);
			pl("EXCEPTION",str);
		}
	}

	public void printException(Exception e) {
		if(showAll)if(showException){
			pl("EXCEPTION", e.toString());
			e.printStackTrace(this);
		}
	}

	private void pl(String level,String str) {
		Color color = oneceFlag?oneceColor:textColor;
		oneceFlag = false;
		int pos = getPos();
		StringBuilder builder = this.builder[pos];
		builder.append("\u001b[38;2;" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m");
		synchronized(sdf) {
			builder.append(showDate ? "[" + sdf.format(Calendar.getInstance().getTime()) + "]" : "");
		}
		Long time = System.currentTimeMillis();
		builder.append(showUpTime ? "[" + nf.format(time - upTime) + "]" : "");
		builder.append(showLevel ? "[" + level + "]" : "");
		StackTraceElement ste = Thread.currentThread().getStackTrace()[3];
		builder.append(showCallClass ? "(" + ste.getClassName() + ":" + ste.getLineNumber() + ")" : "");
		builder.append(showMessage ? str : "");
		builder.append("\u001b[00m" + sep);
		super.print(builder.toString());
		endPos(pos);
	}

	private void pr(String level,String str) {
		Color color = oneceFlag?oneceColor:textColor;
		oneceFlag = false;
		int pos = getPos();
		StringBuilder builder = this.builder[pos];
		builder.append("\u001b[38;2" + ";" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m");
		synchronized(sdf) {
			builder.append(showDate ? "[" + sdf.format(Calendar.getInstance().getTime()) + "]" : "");
		}
		Long time = System.currentTimeMillis();
		builder.append(showUpTime ? "[" + nf.format(time - upTime) + "]" : "");
		builder.append(showLevel ? "[" + level + "]" : "");
		StackTraceElement ste = Thread.currentThread().getStackTrace()[3];
		builder.append(showCallClass ? "(" + ste.getClassName() + ":" + ste.getLineNumber() + ")" : "");
		builder.append(showMessage ? str : "");
		builder.append("\u001b[00m");
		super.print(builder);
		endPos(pos);
	}

	private void napl(String str) {
		Color color = oneceFlag?oneceColor:textColor;
		oneceFlag = false;
		String text = "\u001b[38;2" + ";" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
		if(!showMessage) {
			text += str;
		}
		text += "\u001b[00m" + sep;
		super.print(text);
	}

	private void napr(String str) {
		Color color = oneceFlag?oneceColor:textColor;
		oneceFlag = false;
		String text = "\u001b[38;2" + ";" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
		if(showMessage) {
			text += str;
		}
		text += "\u001b[00m";
		super.print(text);
	}

	private synchronized int getPos() {
		int num = usePos;
		used[num] = true;
		usePos++;
		usePos = usePos == builderLen ? 0 : usePos;
		return num;
	}

	private void endPos(int num) {
		needRefresh[num] = true;
		if(!refthread) {
			refresh = new Thread("Logger:" + getRunNum()) {
				public void run() {
					do {
						if(used[refreshPos] & needRefresh[refreshPos]) {
							builder[refreshPos] = new StringBuilder();
							used[refreshPos] = needRefresh[refreshPos] = false;
							refreshPos++;
							refreshPos = refreshPos == builderLen ? 0 : refreshPos;
						}else {
							try {
								Thread.sleep(10000);
							}catch(InterruptedException e) {}
						}
					}while(watchFlag);
					refthread = false;
				}
			};
			refWatchdog();
			refresh.start();
		}else {
			refresh.interrupt();
			refWatchdog();
		}
	}

	private void refWatchdog() {
		if(watchFlag) {
			watchdog.interrupt();
		}else {
			watchdog = new Thread("Logger:" + getWatchNum()) {
				public void run() {
					boolean flag;
					do {
						flag = false;
						try {
							Thread.sleep(10000);
						}catch(InterruptedException e) {
							flag = true;
						}
					}while(flag);
					watchFlag = false;
				}
			};
			watchFlag = true;
			watchdog.start();
		}
	}
}