package main;

import assets.util.Logger;
import assets.util.Register;

public class Main {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	public static Logger logger = new Logger(System.out);

	public static Register register = new Register();

	public static void main(String[] args) {
		System.setOut(logger);

		register.register("test","test");
		//下のコメントアウトした部分を有効にするとキーが重複しているので例外が発生します
		//register.register("test","test2");
		register.register("try","test3");

		System.out.println(register.getString("test"));
		//下のコメントアウトした部分を有効にすると指定したキーが発見できないので例外が発生します
		//System.out.println(register.getString("tyy"));
		System.out.println(register.getString("try"));
	}

}