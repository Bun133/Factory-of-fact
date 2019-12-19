package assets.actor;

public class ActorManager {
	public Player mainplayer;
	public ActorManager() {
		mainplayer.x=0;
		mainplayer.y=0;
		mainplayer .inrunning=false;
		mainplayer.rotation=1;
	}

	public Player getMainPlayer() {
		return mainplayer;
	}

}