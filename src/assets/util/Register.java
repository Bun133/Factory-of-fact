/***
 * データ保存用のクラスです。
 *
 * @version 1.0
 * @author nyuto
 */


package assets.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import assets.exception.DuplicateKeyException;
import assets.exception.ValueNotFoundException;

public class Register {
	private static final long serialVersionUID = 1L;

	private Map<String,Object> list_Object;

	private Map<String, Boolean> list_Flag;

	private Map<String, Byte> list_Byte;

	private Map<String,Short> list_Short;

	private Map<String,Integer> list_Integer;

	private Map<String,Long> list_Long;

	private Map<String,Float> list_Float;

	private Map<String,Double> list_Double;

	private Map<String,String> list_String;

	private Map<String,Character> list_Char;

	private Map<String,BigDecimal> list_Decimal;

	public Register() {
		System.out.println("Init Register.");
		list_Object = new HashMap<String,Object>();
		list_Flag = new HashMap<String,Boolean>();
		list_Byte = new HashMap<String,Byte>();
		list_Short = new HashMap<String,Short>();
		list_Integer = new HashMap<String,Integer>();
		list_Long = new HashMap<String,Long>();
		list_Float = new HashMap<String,Float>();
		list_Double = new HashMap<String,Double>();
		list_String = new HashMap<String,String>();
		list_Char = new HashMap<String,Character>();
		list_Decimal = new HashMap<String,BigDecimal>();
	}


	public void register(String key,Object obj) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Object.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Object.put(key,obj);

	}

	public void register(String key,boolean flag) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Flag.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Flag.put(key,flag);
	}

	public void register(String key,byte value) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Byte.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Byte.put(key,value);
	}

	public void register(String key,short value) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Short.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Short.put(key,value);
	}

	public void register(String key,int value) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Integer.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Integer.put(key,value);
	}

	public void register(String key,long value) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Long.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Long.put(key,value);
	}

	public void register(String key,float value) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Float.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Float.put(key,value);
	}

	public void register(String key,double value) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Double.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Double.put(key,value);
	}

	public void register(String key,String value) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_String.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_String.put(key,value);
	}

	public void register(String key,char value) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Char.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Char.put(key,value);
	}

	public void register(String key,BigDecimal decimal) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(list_Decimal.containsKey(key))throw new DuplicateKeyException( key + " is already used.");
		list_Decimal.put(key,decimal);
	}

	public Object getObject(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Object.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Object.get(key);
	}

	public boolean getFlag(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Flag.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Flag.get(key);
	}

	public byte getByte(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Byte.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Byte.get(key);
	}

	public short getShort(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Short.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Short.get(key);
	}

	public int getInteger(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Integer.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Integer.get(key);
	}

	public long getLong(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Long.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Long.get(key);
	}

	public float getFloat(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Float.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Float.get(key);
	}

	public double getDouble(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Double.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Double.get(key);
	}

	public String getString (String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_String.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_String.get(key);
	}

	public char getChar(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Char.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Char.get(key);
	}

	public BigDecimal getDecimal(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		if(!list_Decimal.containsKey(key))throw new ValueNotFoundException(key + " is not found.");
		return list_Decimal.get(key);
	}

	public void deleteObject(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Object.remove(key);
	}

	public void deleteFlag(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Flag.remove(key);
	}

	public void deleteByte(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Byte.remove(key);
	}

	public void deleteShort(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Short.remove(key);
	}

	public void deleteInteger(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Integer.remove(key);
	}

	public void deleteLong(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Long.remove(key);
	}

	public void deleteFloat(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Float.remove(key);
	}

	public void deleteDouble(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Double.remove(key);
	}

	public void deleteString(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_String.remove(key);
	}

	public void deleteChar(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Char.remove(key);
	}

	public void deleteDecimal(String key) {
		if(key == null)throw new IllegalArgumentException("key cannot be null.");
		list_Decimal.remove(key);
	}
}
