package com.emp_mng.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_mng.repository.ProjectRepository;
import com.emp_mng.repository.RequestResourceRepository;
//import com.emp_mng.repository.RequestResourceRepositoryTest;
import com.emp_mng.repository.UserRepository;
import com.emp_mng.entities.Project;
import com.emp_mng.entities.RequestResources;
import com.emp_mng.entities.User;
import com.emp_mng.dto.RequestResourcesDTO;
import com.emp_mng.exceptions.AlreadyAssignedException;
import com.emp_mng.exceptions.PendingRequestException;

@Service
public class RequestResourceService {
	
	@Autowired
    private RequestResourceRepository requestResourceRepository;
	
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;
	
	public RequestResources createRequest(RequestResourcesDTO requestResourcesDTO)
	{
		Optional<RequestResources> existingRequest = requestResourceRepository.findByEmployeeId(requestResourcesDTO.getEmployeeId());

        if (existingRequest.isPresent()) {
            RequestResources existingResource = existingRequest.get();

            
            if ("Approved".equals(existingResource.getStatus())) {
                throw new AlreadyAssignedException("Cannot request for an already assigned employee");
            }
            else if ("Pending".equals(existingResource.getStatus())) {
            	
            	throw new PendingRequestException("Cannot request for an  employee,He is already in pending");
            }
        }
		RequestResources request=new RequestResources();
		request.setManagerId(requestResourcesDTO.getManagerId());
		request.setEmployeeId(requestResourcesDTO.getEmployeeId());
		request.setProjectId(requestResourcesDTO.getProjectId());
		return requestResourceRepository.save(request);
		
	}
	
	public List<Map<String,Object>> getPendingRequestWithNames()
	{
		List<RequestResources> pendingRequest=requestResourceRepository.findByStatus("Pending");
		List<Map<String,Object>> result=new ArrayList<>();
		for(RequestResources request:pendingRequest)
		{
			Map<String,Object> map=new HashMap<>();
		    User employee = userRepository.findById(request.getEmployeeId()).orElse(null);
	        User manager = userRepository.findById(request.getManagerId()).orElse(null);
	        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
	        if (employee != null) {
                map.put("employeeName", employee.getName());
            }
            if (manager != null) {
                map.put("managerName", manager.getName());
            }
            if (project != null) {
                map.put("projectName", project.getName());
            }
            map.put("requestId", request.getRequestId());
            result.add(map);
		}
		return result;
		
	}
	
	public RequestResources updateRequestStatus(int id, String status) {
        Optional<RequestResources> optionalRequest = requestResourceRepository.findById(id);
        if (optionalRequest.isPresent()) {
            RequestResources request = optionalRequest.get();
            request.setStatus(status);
            return requestResourceRepository.save(request);
        } else {
            throw new RuntimeException("Request not found with id " + id);
        }
    }

    public RequestResources approveRequest(int id) {
        return updateRequestStatus(id, "approved");
    }

    public void rejectRequest(int id) {
        if (requestResourceRepository.existsById(id)) {
        	requestResourceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Request not found with id " + id);
        }
    }
    public List<Map<String,Object>> getApprovedRequestWithNames()
	{
		List<RequestResources> approvedRequest=requestResourceRepository.findByStatus("approved");
		List<Map<String,Object>> result=new ArrayList<>();
		for(RequestResources request:approvedRequest)
		{
			Map<String,Object> map=new HashMap<>();
		    User employee = userRepository.findById(request.getEmployeeId()).orElse(null);
	        User manager = userRepository.findById(request.getManagerId()).orElse(null);
	        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
	        if (employee != null) {
                map.put("employeeName", employee.getName());
            }
            if (manager != null) {
                map.put("managerName", manager.getName());
            }
            if (project != null) {
                map.put("projectName", project.getName());
            }
            map.put("requestId", request.getRequestId());
            result.add(map);
		}
		return result;
		
	}
    
    public List<Map<String, Object>> getApprovedRequestsByEmployeeId(int employeeId) {
        List<RequestResources> requests = requestResourceRepository.findApprovedRequestsByEmployeeId(employeeId);
        List<Map<String, Object>> result = new ArrayList<>();

        for (RequestResources request : requests) {
                   
        	Map<String,Object> map=new HashMap<>();
		    User employee = userRepository.findById(request.getEmployeeId()).orElse(null);
	        User manager = userRepository.findById(request.getManagerId()).orElse(null);
	        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
	        if (employee != null) {
                map.put("employeeName", employee.getName());
            }
            if (manager != null) {
                map.put("managerName", manager.getName());
            }
            if (project != null) {
                map.put("projectName", project.getName());
            }
            map.put("requestId", request.getRequestId());
            result.add(map);
	
        
        }

        return result;
    }
    public List<Map<String, Object>> getApprovedRequestsByManagerId(int managerId) {
        List<RequestResources> requests = requestResourceRepository.findApprovedRequestsByManagerId(managerId);
        List<Map<String, Object>> result = new ArrayList<>();

        for (RequestResources request : requests) {
                   
        	Map<String,Object> map=new HashMap<>();
		    User employee = userRepository.findById(request.getEmployeeId()).orElse(null);
	        User manager = userRepository.findById(request.getManagerId()).orElse(null);
	        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
	        if (employee != null) {
                map.put("employeeName", employee.getName());
            }
            if (manager != null) {
                map.put("managerName", manager.getName());
            }
            if (project != null) {
                map.put("projectName", project.getName());
            }
            map.put("requestId", request.getRequestId());
            result.add(map);
	
        
        }

        return result;
    }
    


}

