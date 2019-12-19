package map;

public class Map {
	private long[] ints;
	private int max_x;
	private int max_y;
	public Map(int x,int y) {
		ints=new long [x*y];
		max_x=x;
		max_y=y;
	}

	public void set(int x,int y,int num) {
		ints[getindex(x,y)]=num;
	}

	public void set(int x,int y,long num) {
		ints[getindex(x,y)]=num;
	}

	public long get(int x,int y) {
		return ints[getindex(x,y)];
	}

	public int getindex(int x,int y) {
		if (x==0) {
			return y;
		}
		return (x-1)*max_y+y;
	}

}
