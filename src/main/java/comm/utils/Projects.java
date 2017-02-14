package comm.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Projects {
	
	private int project_id;
	private String project_name;
	public List<Object> la;
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public List<Object> getLa() {
		return la;
	}
	public void setLa(List<Object> la) {
		this.la = la;
	}
	
	
}
