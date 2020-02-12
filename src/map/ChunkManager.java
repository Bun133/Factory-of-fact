package map;

public class ChunkManager {
	private Map map;
	public ChunkManager() {
		System.out.println("マップが読み込まれない状態で開始します。");
		System.out.println("*デバッグ時以外は発生しえない挙動です。");
	}
	public ChunkManager(Map m) {
		map=m;
	}
}
