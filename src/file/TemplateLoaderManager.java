package file;

import java.io.IOException;
import java.nio.file.Path;

public class TemplateLoaderManager {
	private TemplateLoader[] TL;
	private String name;
	public TemplateLoaderManager(String name_) {
		name=name_;
	}
	public void newloader(Path path,int index) throws IOException {
		TL[index].loadmap(path,name);
	}
}
