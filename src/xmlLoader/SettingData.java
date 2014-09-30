package xmlLoader;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class SettingData {
	@Attribute(required = false)
	private String property;

	@Text
	private String content;

	public String getProperty() {
		return property;
	}

	public String getContent() {
		return content;
	}
}
