/**
 * コンフィグの読み込みを行うクラスです
 * ConfigTransformerに各型のキー、デフォルトの値を指定して渡すことでRegisterに整形して渡すことができます
 *
 * @version 1.0
 * @author nyuto
 */

package assets.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Map;
import java.util.Properties;

public class Config {

	private ConfigTransformer conftf;

	private Properties prop;

	private String stringPath;

	private Path filePath;

	private InputStream istream;

	private int pathState;

	private static final int PATH_NONE = 0x00;

	private static final int PATH_STRING = 0x01;

	private static final int PATH_FILE = 0x02;

	private static final int PATH_STREAM = 0x03;


	public Config() {
		pathState = PATH_NONE;
	}

	public Config(String path) {
		setPath(path);
	}

	public Config(Path path) {
		setPath(path);
	}

	public Config(InputStream stream) {
		setPath(stream);
	}

	public Config(String path,ConfigTransformer ctf) {
		setPath(path);
		conftf = ctf;
	}

	public Config(Path path,ConfigTransformer ctf) {
		setPath(path);
		conftf = ctf;
	}

	public Config(InputStream stream,ConfigTransformer ctf) {
		setPath(stream);
		conftf = ctf;
	}

	public void setPath(String path) {
		stringPath = path;
		pathState = PATH_STRING;
	}

	public void setPath(Path path) {
		filePath = path;
		pathState = PATH_FILE;
	}

	public void setPath(InputStream stream) {
		istream = stream;
		pathState = PATH_STREAM;
	}

	public void setConfigTransformer(ConfigTransformer ctf) {
		conftf = ctf;
	}

	public void readConfig() {
		switch(pathState) {
		case PATH_NONE:
			return;
		case PATH_STRING:
			readConfig(stringPath);
			break;
		case PATH_FILE:
			readConfig(filePath);
			break;
		case PATH_STREAM:
			readConfig(istream);
			break;
		}
	}

	public void readConfig(String path) {
		System.out.println("Read config : " + path);
		prop = new Properties();
		try {
			InputStreamReader stream = new InputStreamReader(getClass().getResourceAsStream(path),"UTF-8");
			prop.load(stream);
			stream.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void readConfig(Path path) {
		System.out.println("Read config : " + path.toString());
		prop = new Properties();
		try {
			InputStreamReader stream = new InputStreamReader(new FileInputStream(new File(path.toUri())),"UTF-8");
			prop.load(stream);
			stream.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void readConfig(InputStream stream) {
		System.out.println("Read config : " + stream.toString());
		prop = new Properties();
		try {
			prop.load(stream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		return prop;
	}

	public Register getTransformedData() {
		return getTransformedData(conftf);
	}

	public Register getTransformedData(ConfigTransformer ctf) {
		Register regist = new Register();
		Map<String,String> ctm = ctf.getBooleanMap();
		boolean bool;
		for(String key:ctm.keySet()) {
			try {
				bool = Boolean.valueOf(prop.getProperty(key,ctm.get(key)));
				regist.register(key,bool);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		ctm = ctf.getByteMap();
		byte byt;
		for(String key:ctm.keySet()) {
			try {
				byt = Byte.valueOf(prop.getProperty(key,ctm.get(key)));
				regist.register(key,byt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		ctm = ctf.getByteMap();
		short sht;
		for(String key:ctm.keySet()) {
			try {
				sht = Short.valueOf(prop.getProperty(key,ctm.get(key)));
				regist.register(key,sht);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		ctm = ctf.getByteMap();
		int inte;
		for(String key:ctm.keySet()) {
			try {
				inte = Integer.valueOf(prop.getProperty(key,ctm.get(key)));
				regist.register(key,inte);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		ctm = ctf.getByteMap();
		Long lon;;
		for(String key:ctm.keySet()) {
			try {
				lon = Long.valueOf(prop.getProperty(key,ctm.get(key)));
				regist.register(key,lon);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		ctm = ctf.getByteMap();
		float flo;
		for(String key:ctm.keySet()) {
			try {
				flo = Float.valueOf(prop.getProperty(key,ctm.get(key)));
				regist.register(key,flo);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		ctm = ctf.getByteMap();
		double dou;
		for(String key:ctm.keySet()) {
			try {
				dou = Double.valueOf(prop.getProperty(key,ctm.get(key)));
				regist.register(key,dou);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		ctm = ctf.getByteMap();
		String str;
		for(String key:ctm.keySet()) {
			try {
				str = String.valueOf(prop.getProperty(key,ctm.get(key)));
				regist.register(key,str);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		ctm = ctf.getByteMap();
		char cha;
		for(String key:ctm.keySet()) {
			try {
				cha = prop.getProperty(key,ctm.get(key)).charAt(0);
				regist.register(key,cha);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return regist;
	}
}
