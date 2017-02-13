package comm.DAO;

import java.sql.PreparedStatement;import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import comm.utils.Resources;
import comm.utils.TasksRetrieve;
import comm.utils.Utility;

@Component
public class DatabaseOperations {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate checkJdbcTemplate() {

		System.out.println(jdbcTemplate);
		return jdbcTemplate;

	}

	public void insertResources(Resources resources) throws SQLException {
		System.out.println("Insert Resources " + resources);
		String sql = "INSERT into resources VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { resources.getResourceId(), resources.getName() });
	}
	
	
	public List<Map<String, Object>> getResources() throws SQLException {
		try{
			System.out.println("hsejf"); 
			List<Map<String, Object>>  resources = jdbcTemplate.queryForList("select * from resources");
			
		return resources;
		
		}catch(Exception e){
			
			
			throw e;
		}
	}
	
	

	public void insertTasks(TasksRetrieve taskretrieve) {
		
		System.out.println("Insert tasks " + taskretrieve);
		String sql = "INSERT into tasksretrieve(tasks,estimated_hours,completed_hours,resource_id) VALUES (?,?,?,?)";
		
			jdbcTemplate.update(sql, new Object[] { taskretrieve.getTasks(),taskretrieve.getEstimatedhours(),taskretrieve.getCompletedhours(),taskretrieve.getResource_id()});
				System.out.println(this.getClass().getName());
			Utility.sendGrid(null,this.getClass().getName(),new Object(){}.getClass().getEnclosingMethod().getName());
		

	}
public void updateTasks(TasksRetrieve taskretrieve) {
		
		System.out.println("tasks update " + taskretrieve);
		//String sql = "INSERT into tasksretrieve(tasks,estimated_hours,completed_hours,resource_id) VALUES (?,?,?,?)";
		//for(TasksRetrieve task:taskretrieve){
		//String query="DELETE FROM tasksretrieve where resource_id=?";

		
		//jdbcTemplate.update(query,taskretrieve.get(0).getResource_id());
		//for(TasksRetrieve task:taskretrieve){
		//String sql = "INSERT into tasksretrieve(tasks,estimated_hours,completed_hours,resource_id) VALUES (?,?,?,?)";
		
		
			String sql = "UPDATE tasksretrieve SET tasks=?,estimated_hours=?,completed_hours=?,resource_id=? where tasks_id=?";
		jdbcTemplate.update(sql, new Object[] { taskretrieve.getTasks(),taskretrieve.getEstimatedhours(),taskretrieve.getCompletedhours(),taskretrieve.getResource_id(), taskretrieve.getTasks_id()});

		//}
	        
	
		
//			for(TasksRetrieve taskretrieve :updateddata)
//			{
//				System.out.println(taskretrieve.getEstimatedhours());
//				System.out.println("sooooooo"+taskretrieve.getTasks());
//				services.updateTaskData(taskretrieve);
//			}

	}
	

	public void retrieveResources() {
		String sql = "SELECT * FROM resources";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		for (Map row : list) {
			System.out.println(list);
		}

	}
	public List<Map<String, Object>> getTasks() throws SQLException {
		try{
			System.out.println("arda");
			List<Map<String, Object>>  tasks = jdbcTemplate.queryForList("select * from tasksretrieve");
			
		return tasks;
		
		}catch(Exception e){
			
			
			throw e;
		}
	}
	
	
	public List<Map<String, Object>> getTasks(String id) throws SQLException {
		try{
			List<Map<String, Object>>  tasks =null;
			System.out.println(id);
			String query="select * from tasksretrieve where resource_id='"+id+"'";
			System.out.println(query);
			if(id!=null){
			  tasks = jdbcTemplate.queryForList("select * from tasksretrieve where resource_id='"+id+"'");
			}
			
		return tasks;
		
		}catch(Exception e){
			
			
			throw e;
			
		}
	}
	
}