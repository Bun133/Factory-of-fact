package graphics;

public class SetFPS {
	public int MaxFPS;
	public int Minmillisec;
	public void setMaxFPS(int setMax) {
		MaxFPS=setMax;
		Minmillisec=1000/MaxFPS;
	}

	public void Force_wait(long time) throws InterruptedException {
		if (Minmillisec>time) {
			Thread.sleep(Minmillisec-time);
		}
	}
}
