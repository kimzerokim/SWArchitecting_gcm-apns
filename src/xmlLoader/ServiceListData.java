package xmlLoader;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="pushConfig")
public class ServiceListData {
	@ElementList(entry="service", inline=true)
	private List<SettingListData> service;
	
	public List<SettingListData> getService() {
		return service;
	}
}
