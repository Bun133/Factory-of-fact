/**
 * デバッグ用メソッドです
 * 時間、開始からの経過時間(ms)呼び出したクラスも追加で表示します
 *
 * @version 1.2
 * @author nyuto
 */

package main;


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

	private Long upTime = System.currentTimeMillis();

	private boolean hideAll = false;

	private boolean hideLog = false;

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

	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

	private NumberFormat nf = NumberFormat.getNumberInstance();

	private String sep = System.lineSeparator();

	public Logger(OutputStream out) {
		super(out);
	}

	public Logger(OutputStream out,boolean autoFlush) {
		super(out,autoFlush);
	}

	public Logger(OutputStream out,boolean autoFlush,String encoding) throws UnsupportedEncodingException{
		super(out,autoFlush,encoding);
	}

	public Logger(OutputStream out,boolean autoFlush,Charset charset) {
		super(out,autoFlush,charset);
	}

	public Logger(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	public Logger(String fileName,String csn) throws FileNotFoundException,UnsupportedEncodingException{
		super(fileName,csn);
	}

	public Logger(String fileName,Charset charset) throws IOException {
		super(fileName,charset);
	}

	public Logger(File file) throws FileNotFoundException {
		super(file);
	}

	public Logger(File file,String csn) throws FileNotFoundException,UnsupportedEncodingException{
		super(file,csn);
	}

	public Logger(File file,Charset charset) throws IOException{
		super(file,charset);
	}

	public void hideAll(boolean flag) {
		hideAll = flag;
	}

	public void hideLog(boolean flag) {
		hideLog = flag;
	}

	public void hideWarn(boolean flag) {
		hideWarn = flag;
	}

	public void hideError(boolean flag) {
		hideError = flag;
	}

	public void hideException(boolean flag) {
		hideException = flag;
	}

	public void hideDate(boolean flag) {
		hideDate = flag;
	}

	public void hideUpTime(boolean flag) {
		hideUpTime = flag;
	}

	public void hideLevel(boolean flag) {
		hideLevel = flag;
	}

	public void hideCallClass(boolean flag) {
		hideCallClass = flag;
	}

	public void hideMessage(boolean flag) {
		hideMessage = flag;
	}

	public void setDefaultTextColor() {
		textColor = new Color(0,0,0);
	}

	public void setTextColor(Color color) {
		if(color == null) {
			setDefaultTextColor();
			return;
		}
		textColor = color;
	}

	public void setTextColorOnece(Color color) {
		if(color == null)return;
		oneceColor = color;
		oneceFlag = true;
	}

	public void print(boolean b) {
		if(hideAll)return;
		if(hideLog)return;
		pr("INFO",String.valueOf(b));
	}

	public void print(char c) {
		if(hideAll)return;
		if(hideLog)return;
		pr("INFO",String.valueOf(c));
	}

	public void print(int i) {
		if(hideAll)return;
		if(hideLog)return;
		pr("INFO",String.valueOf(i));
	}

	public void print(long l) {
		if(hideAll)return;
		if(hideLog)return;
		pr("INFO",String.valueOf(l));
	}

	public void print(float f) {
		if(hideAll)return;
		if(hideLog)return;
		pr("INFO",String.valueOf(f));
	}

	public void print(double d) {
		if(hideAll)return;
		if(hideLog)return;
		pr("INFO",String.valueOf(d));
	}

	/**
	 * char配列のprintです
	 * ※自分の技量では実装できませんでした。
	 */
	public void print(char s[]) {
		if(hideAll)return;
		if(hideLog)return;
		this.print(s);
	}

	public void print(String s) {
		if(s.equals(sep))sep();
		if(hideAll)return;
		if(hideLog)return;
		pr("INFO",String.valueOf(s));
	}

	public void print(Object obj) {
		if(hideAll)return;
		if(hideLog)return;
		pr("INFO",String.valueOf(obj));
	}

	public void println() {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO","");
	}

	public void println(boolean b) {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO",String.valueOf(b));
	}

	public void println(char c) {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO",String.valueOf(c));
	}

	public void println(int i) {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO",String.valueOf(i));
	}

	public void println(long l) {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO",String.valueOf(l));
	}

	public void println(float f) {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO",String.valueOf(f));
	}

	public void println(double d) {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO",String.valueOf(d));
	}

	/**
	 * char配列のprintlnです
	 * ※自分の技量では実装できませんでした。
	 */
	public void println(char s[]) {
		if(hideAll)return;
		if(hideLog)return;
		this.println(s);
	}

	public void println(String s) {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO",String.valueOf(s));
	}

	public void println(Object obj) {
		if(hideAll)return;
		if(hideLog)return;
		pl("INFO",String.valueOf(obj));
	}

	public void printNoAdd(String str) {
		if(hideAll)return;
		if(hideLog)return;
		napr(str);
	}

	public void printlnNoAdd(String str) {
		if(hideAll)return;
		if(hideLog)return;
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
			text += "[" + sdf.format(Calendar.getInstance().getTime()) + "]";
		}
		if(!hideUpTime) {
			Long time = System.currentTimeMillis();
			text += "[" + nf.format(time - upTime) + "]";
		}
		if(!hideLevel) {
			text += "[" + level + "]";
		}
		if(!hideCallClass) {
			text += "[" + Thread.currentThread().getStackTrace()[3].getClassName() + "]";
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
			text += "[" + sdf.format(Calendar.getInstance().getTime()) + "]";
		}
		if(!hideUpTime) {
			Long time = System.currentTimeMillis();
			text += "[" + nf.format(time - upTime) + "]";
		}
		if(!hideLevel) {
			text += "[" + level + "]";
		}
		if(!hideCallClass) {
			text += "[" + Thread.currentThread().getStackTrace()[3].getClassName() + "]";
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
