package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Complaint;
import com.klef.soa.repository.ComplaintRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComplaintRepositoryTest {

    @Autowired
    private ComplaintRepository repository;


    @Test
    void testFindComplaintById() {
        Optional<Complaint> complaint = repository.findById(1L);

        assertTrue(complaint.isPresent());
        assertEquals(1L, complaint.get().getComplaintId());

        System.out.println("Complaint ID: " + complaint.get().getComplaintId());
        System.out.println("Name: " + complaint.get().getName());
    }

    @Test
    void testFindComplaintByName() {
        List<Complaint> complaints = repository.findByName("Water");

        assertNotNull(complaints);
        assertFalse(complaints.isEmpty());

        System.out.println("Complaints by Name: " + complaints.size());
    }

    @Test
    void testFindComplaintByType() {
        List<Complaint> complaints = repository.findByType("Municipal");

        assertNotNull(complaints);
        assertFalse(complaints.isEmpty());

        System.out.println("Complaints by Type: " + complaints.size());
    }

    @Test
    void testDatabaseConnection() {
        long count = repository.count();

        assertTrue(count >= 0);

        System.out.println("Total Complaints in Database: " + count);
    }

}