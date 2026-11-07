package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Complaint;
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
 List<Complaint>findByName(String name);
 List<Complaint>findByType(String type);
}
