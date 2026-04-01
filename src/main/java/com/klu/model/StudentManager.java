package com.klu.model;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.exception.StudentNotFoundException;
import com.klu.repository.StudentRepository;

@Service
public class StudentManager 
{
	@Autowired
	StudentRepository sr;
	public String insertData(Student s1)
	{
		sr.save(s1);
		return "Data was inserted successfully";
	}
	
	public List<Student> getData()
	{
		return sr.findAll();
	}
	
	public Student getDataById(Long sid)
	{
		Optional<Student> s1=sr.findById(sid);
		if (s1.isPresent())
		{
			return s1.get();
		}
		else
		{
		throw new StudentNotFoundException("Student data is not found with id is "+sid);
		}
		
	}
	
	public String updateData(Long sid,Student s2)
	{
		Optional<Student> s3=sr.findById(sid);
		if (s3.isPresent())
		{
			Student s4= s3.get();
			s4.setSname(s2.getSname());
			s4.setSdept(s2.getSdept());
			sr.save(s4);
			return "Updation was done successfully";
		}
		else
		{
		throw new StudentNotFoundException("Student data is not found with id is "+sid);
		}
	}
	
	public String updateByName(Long sid,String sname)
	{
		Optional<Student> s3=sr.findById(sid);
		if (s3.isPresent())
		{
			Student s4= s3.get();
			s4.setSname(sname);
			sr.save(s4);
			return "Updation was done successfully";
		}
		else
		{
		throw new StudentNotFoundException("Student data is not found with id is "+sid);
		}
	}
	
	public String updateByDept(Long sid,String sdept)
	{
		Optional<Student> s3=sr.findById(sid);
		if (s3.isPresent())
		{
			Student s4= s3.get();
			s4.setSdept(sdept);
			sr.save(s4);
			return "Updation was done successfully";
		}
		else
		{
		throw new RuntimeException("Student data is not found with id is "+sid);
		}
	}

	public String deleteData(Long sid)
	{
		Optional<Student> s1=sr.findById(sid);
		if (s1.isPresent())
		{
			sr.deleteById(sid);
			return "deletion was done successfully";
		}
		else
		{
		throw new RuntimeException("Student data is not found with id is "+sid);
		}
	}
}

