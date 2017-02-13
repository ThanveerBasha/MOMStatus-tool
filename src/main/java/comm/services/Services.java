package comm.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import comm.DAO.DatabaseOperations;
import comm.utils.Resources;
import comm.utils.TasksRetrieve;

@Component
public class Services {
	@Autowired
	Resources resources;
	
	@Autowired
	DatabaseOperations databaseOperations;

	public void insertResourceData() {

		System.out.println(databaseOperations);
		try {
			resources.setResourceId("11");
			resources.setName("phani");
			databaseOperations.insertResources(resources);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Map<String, Object>> getResources() throws Exception {
		
		// System.out.println(databaseOperations);
		List<Map<String, Object>> resources;
		try {
			System.out.println("wh");
			resources = databaseOperations.getResources();
			
			return resources;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;

		}

	}

	public void insertTaskData(TasksRetrieve taskretrieve) throws SQLException {
		System.out.println(databaseOperations);
	
		databaseOperations.insertTasks(taskretrieve);

	}
	public void updateTaskData(TasksRetrieve taskretrieve) throws SQLException {
		System.out.println(databaseOperations);
	
		databaseOperations.updateTasks(taskretrieve);

	}
	
	
	
	
	
	public List<Map<String, Object>> getTaskData() throws Exception {

		// System.out.println(databaseOperations);
		List<Map<String, Object>> tasks;
		try {
			tasks = databaseOperations.getTasks();

			return tasks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;

		}
	}
	
	public List<Map<String, Object>> getTaskData(String id) throws Exception {

		// System.out.println(databaseOperations);
		List<Map<String, Object>> tasks;
		try {
			System.out.println("getTaskData");
			System.out.println(id);
			tasks = databaseOperations.getTasks(id);

			return tasks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;

		}
	}
	
	
}

