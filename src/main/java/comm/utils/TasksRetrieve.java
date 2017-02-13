package comm.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TasksRetrieve {
	private int Tasks_id;
	public int getTasks_id() {
		return Tasks_id;
	}
	public void setTasks_id(int tasks_id) {
		Tasks_id = tasks_id;
	}
	private String Resource_id;
	private String tasks;
	private int estimatedhours;
	private int completedhours;
	
	public List<Object> lt;
	
	public List<Object> getLt() {
		return lt;
	}
	public void setLt(List<Object> lt) {
		this.lt = lt;
	}
	
	public String getResource_id() {
		return Resource_id;
	}
	public void setResource_id(String resource_id) {
		Resource_id = resource_id;
	}
	public String getTasks() {
		return tasks;
	}
	public void setTasks(String tasks) {
		this.tasks = tasks;
	}
	public int getEstimatedhours() {
		return estimatedhours;
	}
	public void setEstimatedhours(int estimatedhours) {
		this.estimatedhours = estimatedhours;
	}
	public int getCompletedhours() {
		return completedhours;
	}
	public void setCompletedhours(int completedhours) {
		this.completedhours = completedhours;
	}
	public String toString()
	{
		return Resource_id+tasks+estimatedhours+completedhours;
	}

}
