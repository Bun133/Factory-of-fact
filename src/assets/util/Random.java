/**

 * java.util.Randomの拡張版です
 * 乱数の周期を伸ばし、更にランダム性を高めました。
 *
 * @version 1.1
 * @author nyuto
 */


package assets.util;

import java.nio.ByteBuffer;

public class Random extends java.util.Random{
	private static final long serialVersionUID = 20L;

	private long seed;

	private int exset;
	private int mulset;
	private int exvalset;
	private int mulvalset;

	private int count;

	private static final int mask = 0xF;

	private static final long[] exnum = {0x5D9A5B65C59A6A65L,
			0x59A8E64C9549BD6AL,
			0xB16E7456ABB54A69L,
			0xA659CDB55A6B6BB4L,
			0x8AE5B92CB1A6955AL,
			0x3165A5AC91A454D1L,
			0xD718A66B26564DADL,
			0xE68B275B14E926A5L,
			0x6565C9173B75A9D2L,
			0x9A6C574B2CA5925AL,
			0xAD15729C9DA23937L,
			0xCA1BAC92D69B25A3L,
			0x748A95D9AB46D19AL,
			0xE937A93254B32E25L,
			0x8A3156AA6D2B3ADCL,
			0xAE9731A9D54CB293L};
	private static final long[] multipiler = {0xA75A46C315D25AD7L,
			0x65B4A6398B73CA3AL,
			0x5973712A36ACB937L,
			0xD2672EB52ADD32CAL,
			0x8B291AE932D936B8L,
			0xA238AC93756AB36EL,
			0x2E8EB89CBB25398AL,
			0x5395AE952B12CB2EL,
			0xAE925B36D2BAE59CL,
			0x8E6D9D9B95CC9A71L,
			0xA95A795A734966BAL,
			0x16E512595A9A2565L,
			0xC896C66B266A9325L,
			0x35A5689B54B72CA9L,
			0xA95B1724A59565D3L,
			0x729A736CEC929A52L};
	private static final int[] exstep = {0xA8B2B128,
			0x6553B753,
			0xB59AE239,
			0xAE356763,
			0x459D631B,
			0xA9631A94,
			0xD55294E5,
			0x4916A323,
			0xA69D69AE,
			0x3A694AAD,
			0xA659B951,
			0x2962A4DA,
			0x4A2599BA,
			0xB3A56565,
			0x194E9ABA,
			0xD9A25596};
	private static final int[] multistep = {0x6CD129AB,
			0xA5AA9A93,
			0xBA4ACBAC,
			0x99166D6A,
			0x534BA319,
			0x5A354E54,
			0xDA354DAE,
			0xAAD924DB,
			0xCA58BA65,
			0x2A2595B1,
			0xD91A325A,
			0x55A931A3,
			0xA58A55B2,
			0x35A5A345,
			0xA594B954,
			0x325A56A5};
	private static final int[] exstepval = {0x6D125AB9,
			0xA52AA93B,
			0xA625A4EA,
			0xAAE58A4B,
			0x59132E56,
			0xD324DA54,
			0x91234A92,
			0x6CD9B12D,
			0xCB1AE525,
			0xD5ABA5A5,
			0x3AEDA592,
			0x52E534C1,
			0xA65251B5,
			0x56E524D8,
			0xBA5C5768,
			0x2D94BAB3};
	private static final int[] multistepval = {0xAE52931B,
			0x639971BA,
			0x58AEA4A7,
			0x5C54B654,
			0xA32D4EB5,
			0x16D8D1AC,
			0xAA4B264B,
			0x6976CA94,
			0xA7245A51,
			0x56E56BA9,
			0x99931A65,
			0xDAB164E3,
			0x4D1B25A2,
			0x932ED65B,
			0xB4B29A92,
			0xC95259BA};



	public Random() {
		this(genSeed());
	}

	public Random(Long seed) {
		setSeed(seed);
	}

	public Random(String seed) {
		this(genSeed(seed));
	}

	private static long genSeed() {
		HashXX hash = new HashXX(8);
		ByteBuffer bb = ByteBuffer.allocate(16);
		ByteBuffer seed = ByteBuffer.allocate(8);
		bb.putLong(System.nanoTime());
		bb.putLong(System.currentTimeMillis());
		seed.put(hash.getHash(bb.array()));
		return seed.getLong();
	}

	private static long genSeed(String str) {
		HashXX hash = new HashXX(8);
		ByteBuffer seed = ByteBuffer.allocate(8);
		seed.put(hash.getHash(str));
		return seed.getLong();
	}

	public synchronized void setSeed(long seed) {
		super.setSeed(seed);
		this.seed = seed;
		exset = exstep[(int)(seed & mask)];
		mulset = multistep[(int)(seed & mask)];
		exvalset = exstepval[(int)(seed & mask)];
		mulvalset = multistepval[(int)(seed & mask)];
		count = (int)(seed >> 32 + seed);
	}

	private synchronized long getNum() {
		long old = this.seed,
				next;
		do {
			exvalset += exstepval[count & mask];
			mulvalset += multistepval[count & mask];
			exset += exstep[(exvalset >> 28) & mask];
			mulset += multistep[(mulvalset >> 28) & mask];
			next = old * multipiler[(mulset >> 28) & mask] ^ exnum[(exset >> 28) & mask] +5;
			count += exset + mulset;
		}while(old == next);
		this.seed = next;
		return next;
	}

	protected int next(int bits) {
		return (int)(getNum() >>> (64 - bits));
	}

	public long getSeed() {
		return seed;
	}


}
