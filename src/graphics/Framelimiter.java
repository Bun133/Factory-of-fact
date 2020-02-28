package graphics;

public class Framelimiter {
    public static long Before_time = System.currentTimeMillis();
    public static int Limit_FPS = 1000;
    private static final int WaitTime = 1000 / Limit_FPS;

    public static void setLimit_FPS(int FPS) {
        Limit_FPS = FPS;
    }

    public static void setFPS_UP(int num) {
        Limit_FPS += num;
        System.out.println(Limit_FPS);
    }

    public static void setFPS_Down(int num) {
        Limit_FPS -= num;
        System.out.println(Limit_FPS);
    }

    public static void limitFPS() throws InterruptedException {
        Thread.sleep(getWaitTime());
        setTime();
    }

    private static void setTime() {
        Before_time = System.currentTimeMillis();
    }

    private static long getWaitTime() {
        if (System.currentTimeMillis() - Before_time > WaitTime) {
            return 0;
        } else {
            return WaitTime - (System.currentTimeMillis() - Before_time);
        }
    }
}
