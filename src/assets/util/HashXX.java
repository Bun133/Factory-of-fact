/**
 * hash maker
 *
 * @author nyuto
 * @version 1.0
 */
package assets.util;

import java.nio.ByteBuffer;

public class HashXX {
	static final long serialVersionUID = 1L;

	/**
	 * set length 32bit
	 */
	public static final int OUTPUT_32 = 4;

	/**
	 * set length 64bit
	 */
	public static final int OUTPUT_64 = 8;

	/**
	 * set length 128bit
	 */
	public static final int OUTPUT_128 = 16;

	/**
	 * set length 256bit
	 */
	public static final int OUTPUT_256 = 32;

	/**
	 * set length 512bit
	 */
	public static final int OUTPUT_512 = 64;

	/**
	 * set length 1024bit
	 */
	public static final int OUTPUT_1024 = 128;

	/**
	 * set length 2048bit
	 */
	public static final int OUTPUT_2048 = 256;

	/**
	 * max input length
	 * 268,435,455(byte)
	 */
	public static final int MAX_INPUT_LENGTH = 0x0FFFFFFF;

	/**
	 * max output length
	 * 268,435,455(byte)
	 */
	public static final int MAX_OUTPUT_LENGTH = 0x0FFFFFFF;


	private int outputLength;


	/**
	 * Default
	 *
	 * set output length 256bit
	 */
	public HashXX() {
		setOutputLength(OUTPUT_256);
	}

	/**
	 * set output length argument
	 *
	 * @param outputLength
	 */
	public HashXX(int outputLength) {
		setOutputLength(outputLength);
	}

	/**
	 * Determines whether the specified argument is appropriate for the output array size.
	 *
	 * @param outputLength
	 */
	public void setOutputLength(int outputLength) {
		if(outputLength <= 0) {
			this.outputLength = 32;
		}else if(outputLength > MAX_OUTPUT_LENGTH) {
			this.outputLength = MAX_OUTPUT_LENGTH;
		}else {
			this.outputLength = outputLength;
		}
	}

	public int getOutputLength() {
		return outputLength;
	}

	public byte[] getHash(byte[] data) {
		return getHash(data,outputLength);
	}

	public byte[] getHash(byte[] data,int outputLength) {
		int len = data.length;
		int out = outputLength > MAX_OUTPUT_LENGTH ? MAX_OUTPUT_LENGTH : outputLength;
		int buf[] = new int[out];
		int worlkNum = len ^ 0x5A5A5A5A;
		if(worlkNum == 0) {
			worlkNum = 0xAA55A5A5;
		}else {
			if(worlkNum <= 0x0000FFFF) {
				if(worlkNum >= 0x8000FFFF) {
					worlkNum += 0xAFA5CD92;
				}
			}
		}
		for(int i=0;i<data.length;i++) {
			buf[i%out] += data[i];
		}
		if(len < out) {
			for(int i=len;i<out;i++) {
				buf[i] = i + 1;
			}
		}
		int works = out >= 64 ? 64 :(int)(64 + (((double)out - 64) * 0.8));
		for(int i=0;i<works;i++) {
			for(int j=0;j<out;j++) {
				buf[j] = buf[j] * worlkNum >> 4;
			}
			int abs = worlkNum;
			for(int k=0;k<out;k+=11) {
				abs = ((abs * buf[(i+k)%out] ^ buf[(i+k+1)%out]) *
						(buf[(i+k+2)%out] * buf[(i+k+3)%out] ^ buf[(i+k+4)%out])) ^
						((buf[(i+k+5)%out] * buf[(i+k+6)%out] ^ buf[(i+k+7)%out]) *
						(buf[(i+k+8)%out] * buf[(i+k+9)%out] ^ buf[(i+k+10)%out]));
			}
			buf[i%out] = buf[i%out] * abs;
		}
		int mask = 0xFF;
		byte output[] = new byte[out];
		for(int i=0;i<out;i++) {
			output[i] = (byte)((buf[i] >> 0) & mask);
		}
		return output;
	}

	public byte[] getHash(String data) {
		return getHash(data.getBytes());
	}

	public byte[] getHash(String data,int outputLength) {
		return getHash(data.getBytes(),outputLength);
	}

	public byte[] getHash(short[] data) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*2);
		for(short i:data)bb.putShort(i);
		return getHash(bb.array());
	}

	public byte[] getHash(short[] data,int outputLength) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*2);
		for(short i:data)bb.putShort(i);
		return getHash(bb.array(),outputLength);
	}

	public byte[] getHash(int[] data) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*4);
		for(int i:data)bb.putInt(i);
		return getHash(bb.array());
	}

	public byte[] getHash(int[] data,int outputLength) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*4);
		for(int i:data)bb.putInt(i);
		return getHash(bb.array(),outputLength);
	}

	public byte[] getHash(long[] data) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*8);
		for(long i:data)bb.putLong(i);
		return getHash(bb.array());
	}

	public byte[] getHash(long[] data,int outputLength) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*8);
		for(long i:data)bb.putLong(i);
		return getHash(bb.array(),outputLength);
	}

	public byte[] getHash(float[] data) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*4);
		for(float i:data)bb.putFloat(i);
		return getHash(bb.array());
	}

	public byte[] getHash(float[] data,int outputLength) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*4);
		for(float i:data)bb.putFloat(i);
		return getHash(bb.array(),outputLength);
	}

	public byte[] getHash(double[] data) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*8);
		for(double i:data)bb.putDouble(i);
		return getHash(bb.array());
	}

	public byte[] getHash(double[] data,int outputLength) {
		ByteBuffer bb = ByteBuffer.allocate(data.length*8);
		for(double i:data)bb.putDouble(i);
		return getHash(bb.array(),outputLength);
	}
}
