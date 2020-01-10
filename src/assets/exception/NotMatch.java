package assets.exception;

import java.nio.file.Path;

public class NotMatch extends RuntimeException{
	public NotMatch() {
		System.out.println("Template Not Match.");
	}

	public NotMatch(Path path) {
		System.out.println("Template Not Match."+path.toString());
	}
}
