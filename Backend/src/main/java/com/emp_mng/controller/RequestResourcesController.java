package com.emp_mng.controller;

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

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.emp_mng.service.RequestResourceService;
import com.emp_mng.dto.RequestResourcesDTO;
import com.emp_mng.entities.RequestResources;




@RestController
@CrossOrigin
@RequestMapping("/api/request")
public class RequestResourcesController {
	
	@Autowired
	private RequestResourceService requestResourcesService; 
	
	@PostMapping("/addRequest")
	public ResponseEntity<RequestResources> addRequest(@RequestBody RequestResourcesDTO requestResourcesDTO)
	{
		RequestResources saveResources=requestResourcesService.createRequest(requestResourcesDTO);
		return ResponseEntity.status(201).body(saveResources);
	}

	@GetMapping("/pending")
    public List<Map<String, Object>> getPendingRequestsWithNames() {
        return requestResourcesService.getPendingRequestWithNames();
    }

    @PutMapping("/{id}/status")
    public RequestResources updateStatus(@PathVariable int id, @RequestParam String status) {
        return requestResourcesService.updateRequestStatus(id, status);
    }

    @PutMapping("/{id}/approve")
    public RequestResources approveRequest(@PathVariable int id) {
        return requestResourcesService.approveRequest(id);
    }

    @DeleteMapping("/{id}/reject")
    public void rejectRequest(@PathVariable int id) {
        requestResourcesService.rejectRequest(id);
    }
    @GetMapping("/approved")
    public List<Map<String, Object>> getApprovedRequestsWithNames() {
        return requestResourcesService.getApprovedRequestWithNames();
    }
    @GetMapping("/approved/{employeeId}")
    public ResponseEntity<List<Map<String, Object>>> getApprovedRequests(@PathVariable int employeeId) {
        List<Map<String, Object>> requests = requestResourcesService.getApprovedRequestsByEmployeeId(employeeId);
        return ResponseEntity.ok(requests);
    }
    @GetMapping("/approved/managerId/{managerId}")
    public ResponseEntity<List<Map<String, Object>>> getApprovedRequests1(@PathVariable int managerId) {
        List<Map<String, Object>> requests = requestResourcesService.getApprovedRequestsByManagerId(managerId);
        return ResponseEntity.ok(requests);
    }
  
}
