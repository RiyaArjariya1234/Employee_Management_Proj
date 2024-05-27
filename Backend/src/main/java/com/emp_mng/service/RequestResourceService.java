package com.emp_mng.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_mng.repository.RequestResourceRepository;
import com.emp_mng.entities.RequestResources;
import com.emp_mng.dto.RequestResourcesDTO;
import com.emp_mng.exceptions.AlreadyAssignedException;
import com.emp_mng.exceptions.PendingRequestException;

@Service
public class RequestResourceService {
	
	@Autowired
    private RequestResourceRepository requestResourceRepository;
	
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


}

