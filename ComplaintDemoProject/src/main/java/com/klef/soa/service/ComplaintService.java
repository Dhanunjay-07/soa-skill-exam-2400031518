package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Complaint;

public interface ComplaintService {
	Complaint addComplaint(Complaint complaint);//
	List<Complaint> displayAllComplaints();//
	Complaint updateComplaint(Long id,Complaint complaint);//
	Complaint displayComplaintById(Long id);//
	String deleteComplaintById(Long id);
	List<Complaint>displayComplaintByName(String name);
	List<Complaint>displayComplaintByType(String type);

}
