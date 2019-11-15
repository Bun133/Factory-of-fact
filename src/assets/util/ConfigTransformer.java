/**
 * コンフィグを読み込んだ後、それぞれの型に変換するためのリストを作成します。
 *
 * @version 2.0
 * @author nyuto
 */

package assets.util;

import java.util.HashMap;
import java.util.Map;

import assets.exception.ArrayLengthNotSameException;

public class ConfigTransformer {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2L;

	private Map<String,String> booleanMap;

	private Map<String,String> byteMap;

	private Map<String,String> shortMap;

	private Map<String,String> integerMap;

	private Map<String,String> longMap;

	private Map<String,String> floatMap;

	private Map<String,String> doubleMap;

	private Map<String,String> stringMap;

	private Map<String,String> charMap;

	public ConfigTransformer() {
		booleanMap = new HashMap<String,String>();
		byteMap = new HashMap<String,String>();
		shortMap = new HashMap<String,String>();
		integerMap = new HashMap<String,String>();
		longMap = new HashMap<String,String>();
		floatMap = new HashMap<String,String>();
		doubleMap = new HashMap<String,String>();
		stringMap = new HashMap<String,String>();
		charMap = new HashMap<String,String>();
	}


	public void addTransformBoolean(String key,String defaultValue) {
		booleanMap.put(key, defaultValue);
	}

	public void addTransformByte(String key,String defaultValue) {
		byteMap.put(key, defaultValue);
	}

	public void addTransformShort(String key,String defaultValue) {
		shortMap.put(key, defaultValue);
	}

	public void addTransformInteger(String key,String defaultValue) {
		integerMap.put(key, defaultValue);
	}

	public void addTransformLong(String key,String defaultValue) {
		longMap.put(key, defaultValue);
	}

	public void addTransformFloat(String key,String defaultValue) {
		floatMap.put(key, defaultValue);
	}

	public void addTransformDouble(String key,String defaultValue) {
		doubleMap.put(key, defaultValue);
	}

	public void addTransformString(String key,String defaultValue) {
		stringMap.put(key, defaultValue);
	}

	public void addTransformChar(String key,String defaultValue) {
		charMap.put(key, defaultValue);
	}


	public void addTransformBoolean(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			booleanMap.put(key[i],defaultValue[i]);
		}
	}

	public void addTransformByte(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			byteMap.put(key[i],defaultValue[i]);
		}
	}

	public void addTransformShort(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			shortMap.put(key[i],defaultValue[i]);
		}
	}

	public void addTransformInteger(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			integerMap.put(key[i],defaultValue[i]);
		}
	}

	public void addTransformLong(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			longMap.put(key[i],defaultValue[i]);
		}
	}

	public void addTransformFloat(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			floatMap.put(key[i],defaultValue[i]);
		}
	}

	public void addTransformDouble(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			doubleMap.put(key[i],defaultValue[i]);
		}
	}

	public void addTransformString(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			stringMap.put(key[i],defaultValue[i]);
		}
	}

	public void addTransformChar(String[] key,String[] defaultValue) {
		if(key.length != defaultValue.length)throw new ArrayLengthNotSameException("key and defaultValue has must same length.");
		for(int i=0;i<key.length;i++) {
			charMap.put(key[i],defaultValue[i]);
		}
	}


	public Map<String,String> getBooleanMap(){
		return booleanMap;
	}

	public Map<String,String> getByteMap(){
		return byteMap;
	}

	public Map<String,String> getShortMap(){
		return shortMap;
	}

	public Map<String,String> getIntegerMap(){
		return integerMap;
	}

	public Map<String,String> getLongMap(){
		return longMap;
	}

	public Map<String,String> getFloatMap(){
		return floatMap;
	}

	public Map<String,String> getDoubleMap(){
		return doubleMap;
	}

	public Map<String,String> getStringMap(){
		return stringMap;
	}

	public Map<String,String> getCharMap(){
		return charMap;
	}


	public void addBooleanMap(Map<String,String> map) {
		booleanMap.putAll(map);
	}

	public void addByteMap(Map<String,String> map) {
		byteMap.putAll(map);
	}

	public void addShortMap(Map<String,String> map) {
		shortMap.putAll(map);
	}

	public void addIntegerMap(Map<String,String> map) {
		integerMap.putAll(map);
	}

	public void addLongMap(Map<String,String> map) {
		longMap.putAll(map);
	}

	public void addFloatMap(Map<String,String> map) {
		floatMap.putAll(map);
	}

	public void addDoubleMap(Map<String,String> map) {
		doubleMap.putAll(map);
	}

	public void addStringMap(Map<String,String> map) {
		stringMap.putAll(map);
	}

	public void addCharMap(Map<String,String> map) {
		charMap.putAll(map);
	}


	public void margeList(ConfigTransformer ct) {
		addBooleanMap(ct.getBooleanMap());
		addByteMap(ct.getByteMap());
		addShortMap(ct.getShortMap());
		addIntegerMap(ct.getIntegerMap());
		addLongMap(ct.getLongMap());
		addFloatMap(ct.getFloatMap());
		addDoubleMap(ct.getDoubleMap());
		addStringMap(ct.getStringMap());
		addCharMap(ct.getCharMap());
	}
}