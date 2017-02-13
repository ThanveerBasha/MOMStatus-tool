package comm.controllers;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import comm.DAO.DatabaseOperations;

import comm.services.Services;
import comm.utils.Resources;

import comm.utils.TasksRetrieve;
import comm.utils.Utility;



@RestController

@RequestMapping("/Controller")

public class MOMController {
	
	//final Logger log = LogFactory.getLog(MOMController.class.getName());

	@Autowired

	Services services;

	@Autowired

	DatabaseOperations databaseOperations;

	@Autowired

	TasksRetrieve taskretrieve;
	

	@RequestMapping(value = "/retrieveusers", method = RequestMethod.GET)

	public String retrieveusers() {

		// JSONObject resource;

		// JSONArray resourceArray = new JSONArray();

		// System.out.println("resourceArray" + resourceArray);

		Resources resources = new Resources();

		try {

			System.out.println("hai");

			List<Map<String, Object>> list = services.getResources();
			//System.out.println(resources);

			List<Object> la = new ArrayList<Object>();

			for (Map row1 : list) {

				la.add(row1);

			}

			resources.setLa(la);
			System.out.println(la);

			return new Gson().toJson(resources);

		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("innn" + databaseOperations.checkJdbcTemplate());

		// return "Hello " + name;

		return "success";

	}
	
	
	
	//Added by kavitha for resource tasks
	
	
	@RequestMapping(value = "/resourceTasks/{resourceid}", method = RequestMethod.GET)

	public String resourceTasks(@PathVariable String resourceid) {
		
		
		System.out.println("resourceTasks"+resourceid);
		List<Map<String, Object>> list = null;
		try {
                    list = services.getTaskData(resourceid);
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return new Gson().toJson(list);
	}
	

	@RequestMapping(value = "/insertResources", method = RequestMethod.GET)

	public void insertResources() {

		services.insertResourceData();

		databaseOperations.retrieveResources();

	}

	@CrossOrigin

	@RequestMapping(value = "/insertTaskData", method = RequestMethod.POST)

	public void insertTaskData(@RequestBody List<TasksRetrieve> varee) throws Exception {
		
		
		System.out.println("incontroller"+varee);
		
		for(TasksRetrieve taskretrieve :varee)
		{
			System.out.println(taskretrieve.getEstimatedhours());
			services.insertTaskData(taskretrieve);
		}
		
	}
	
	//updating task data
	@CrossOrigin

	@RequestMapping(value = "/updateTaskData", method = RequestMethod.POST)

	public void updateTaskData(@RequestBody List<TasksRetrieve> updateddata) throws Exception {
		
		
		System.out.println("sizeeeee"+updateddata.size());
		
	for(TasksRetrieve taskretrieve :updateddata)
		{
			System.out.println("updateTaskdata");
			System.out.println("sooooooo"+taskretrieve.getTasks_id());
		services.updateTaskData(taskretrieve);
	}
		
	}
	
	
	
	
	
  
	@RequestMapping(value = "/retrieveTasks", method = RequestMethod.GET)

	public String retrieveTasks() {

		Resources resources = new Resources();

		try {

			System.out.println("retrievetasks");

			List<Map<String, Object>> list = services.getTaskData();

			List<Object> lt = new ArrayList<Object>();

			for (Map row1 : list) {

				lt.add(row1);

			}

			taskretrieve.setLt(lt);
			System.out.println(taskretrieve);

			return new Gson().toJson(taskretrieve);

		} catch (Exception e) {
			Utility.sendGrid(e,this.getClass().getName(),new Object(){}.getClass().getEnclosingMethod().getName());
			System.out.println("exception occured"+e.getMessage());

			//e.printStackTrace();

		}

		System.out.println("innn" + databaseOperations.checkJdbcTemplate());

		// return "Hello " + name;

		return "success";

	}

}