package com.ntech.demo1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ntech.demo1.model.*;


@RestController
public class EmployeeController {
	@RequestMapping(value="/")
	public String display() {
		return "Hello World this second update";
	}
	
	private static Map<String, Employee> empRepo= new HashMap<String, Employee>();
	
	static {
			Employee emp1=new Employee();
			emp1.setId("1");
			emp1.setName("Nikhil");
			emp1.setAge("27");
			empRepo.put(emp1.getId(), emp1);
			
			Employee emp2=new Employee();
			emp2.setId("2");
			emp2.setName("Nix");
			emp2.setAge("28");
			empRepo.put(emp2.getId(), emp2);
			
			Employee emp3=new Employee();
			emp3.setId("3");
			emp3.setName("Nick");
			emp3.setAge("29");
			empRepo.put(emp3.getId(), emp3);
			
	}
	
	
	@RequestMapping(value="/employee")
	public ResponseEntity<Object> getAllEmployee(){
		return new ResponseEntity<>(empRepo.values(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/employee/id/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id){
		return empRepo.get(id);
	}
	
	@RequestMapping(value="/employee/id")
	public ArrayList<String> getAllEmployeeIds() {
		ArrayList<String> ar = new ArrayList<String>(empRepo.keySet());
		return ar;
		
		
		}
		
		
		
	}
