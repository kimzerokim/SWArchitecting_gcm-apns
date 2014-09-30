package xmlLoader;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

public class SettingListData {

	@ElementList(entry = "setting", inline = true)
	private List<SettingData> setting;

	@Attribute
	private String name;

	public List<SettingData> getSetting() {
		return setting;
	}

	public String getName() {
		return name;
	}
}
