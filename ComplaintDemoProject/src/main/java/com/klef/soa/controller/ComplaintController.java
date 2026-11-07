package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Complaint;
import com.klef.soa.service.ComplaintService;
@RestController
@RequestMapping("/complaint")
@CrossOrigin(origins = "*")
public class ComplaintController 
{
	@Autowired
   private ComplaintService service;
   
		@GetMapping("/")
		public String test()

		{
			return "Complaint Demo Project";
		}

	@PostMapping("/add")
	public ResponseEntity<Complaint> addComplaint(@RequestBody Complaint complaint)
	{
	Complaint c=service.addComplaint(complaint);
	return ResponseEntity.status(201).body(c);
	}
	@GetMapping("/displayAll")
	public ResponseEntity<List<Complaint>> displayAllComplaints()
	{
		
		return ResponseEntity.status(200).body(service.displayAllComplaints());
	}
	@GetMapping("/display")
	public ResponseEntity<?> displayComplaintById(@RequestParam Long id)
	{
		Complaint comp=service.displayComplaintById(id);
		if(comp!=null)
		{
			return ResponseEntity.status(200).body(comp);
		}
		else
		{
			return ResponseEntity.status(404).body("Complaint ID not found");
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateComplaint(@PathVariable Long id,@RequestBody Complaint comp)
	{
		Complaint c=service.updateComplaint(id, comp);
		if(c!=null)
		{
			return ResponseEntity.status(200).body(c);
		}
		else
		{
			return ResponseEntity.status(400).body("Complaint ID Not Found");
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteComplaint(@PathVariable Long id)
	{
	String exists=service.deleteComplaintById(id);
	return  ResponseEntity.status(200).body(exists);
	}
	
	@GetMapping("/displayByName/{name}")
	public ResponseEntity<List<Complaint>> displayComplaintByName(@PathVariable String name)
	{
		List<Complaint> c=service.displayComplaintByName(name);
		return ResponseEntity.status(200).body(c);
		
	}
	@GetMapping("/displayByType/{type}")
	public ResponseEntity<List<Complaint>> displayComplaintByType(@PathVariable String type)
	{
		List<Complaint> c=service.displayComplaintByType(type);
		return ResponseEntity.status(200).body(c);
		
	}
}
