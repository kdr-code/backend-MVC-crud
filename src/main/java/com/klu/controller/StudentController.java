package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.klu.entity.Student;
import com.klu.model.StudentManager;

@RestController
@RequestMapping("/crud")
@ResponseBody
@CrossOrigin(origins="*")
public class StudentController 
{	
	@Autowired
	StudentManager sm;
	
	//http://localhost:8080/crud/insert
	@PostMapping("/insert")
	@ResponseBody
	public String Insert(@RequestBody Student s2)
	{
		return sm.insertData(s2);
	}
	
	//http://localhost:8080/crud/alldata
	@GetMapping("/alldata")
	@ResponseBody
	public List<Student> getAllData()
	{
		return sm.getData();
	}
	
	//http://localhost:8080/crud/getbyid/1
	@GetMapping("/getbyid/{sid}")
	@ResponseBody
	public Student getById(@PathVariable Long sid)
	{
		return sm.getDataById(sid);
	}
	
	//http://localhost:8080/crud/updateall/2
	@PutMapping("/updateall/{sid}")
	@ResponseBody
	public String updateAllData(@PathVariable Long sid,@RequestBody Student s1)
	{
		return sm.updateData(sid,s1);
	}
	
	//http://localhost:8080/crud/updatebydept/3?sname=meenu
	@PatchMapping("/updatebyname/{sid}")
	@ResponseBody
	public String updateByName(@PathVariable Long sid,@RequestParam String sname)
	{
		return sm.updateByName(sid,sname);
	}
	
	//http://localhost:8080/crud/updatebydept/3?sdept=CSE
	@PatchMapping("/updatebydept/{sid}")
	@ResponseBody
	public String updateByDept(@PathVariable Long sid,@RequestParam String sdept)
	{
		return sm.updateByDept(sid,sdept);
	}
	
	//http://localhost:8080/crud/delete/3
	@DeleteMapping("/delete/{sid}")
	@ResponseBody
	public String deleteData(@PathVariable Long sid)
	{
		return sm.deleteData(sid);
	}
}
