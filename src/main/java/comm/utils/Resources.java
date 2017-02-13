package comm.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Resources {
	private String resourceId;
	private String name;
	public List<Object> la;

	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString()
	{
		return "Resources (" + resourceId + ", " + name + ")";

}
	public List<Object> getLa() {
		return la;
	}
	public void setLa(List<Object> la) {
		this.la = la;
	}
	
}
