package com.emp_mng.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import com.emp_mng.dto.RequestResourcesDTO;
import com.emp_mng.entities.RequestResources;
import com.emp_mng.exceptions.AlreadyAssignedException;
import com.emp_mng.exceptions.PendingRequestException;
import com.emp_mng.repository.RequestResourceRepository;
//import com.emp_mng.service.RequestResourceService;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequestResourceServiceTest {

    @Mock
    private RequestResourceRepository requestResourceRepository;

    @InjectMocks
    private RequestResourceService requestResourceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRequest_Success() {
        // Arrange
        RequestResourcesDTO requestDTO = new RequestResourcesDTO();
        requestDTO.setEmployeeId(123);
        requestDTO.setManagerId(456);
        requestDTO.setProjectId(789);

        when(requestResourceRepository.findByEmployeeId(123)).thenReturn(Optional.empty());
        when(requestResourceRepository.save(any(RequestResources.class))).thenReturn(new RequestResources());

        // Act
        requestResourceService.createRequest(requestDTO);

        // Assert
        verify(requestResourceRepository, times(1)).findByEmployeeId(123);
        verify(requestResourceRepository, times(1)).save(any(RequestResources.class));
    }

    @Test
    public void testCreateRequest_AlreadyAssigned() {
        // Arrange
        RequestResourcesDTO requestDTO = new RequestResourcesDTO();
        requestDTO.setEmployeeId(123);
        requestDTO.setManagerId(456);
        requestDTO.setProjectId(789);

        RequestResources existingRequest = new RequestResources();
        existingRequest.setStatus("Approved");

        when(requestResourceRepository.findByEmployeeId(123)).thenReturn(Optional.of(existingRequest));

        // Act & Assert
        assertThrows(AlreadyAssignedException.class, () -> {
            requestResourceService.createRequest(requestDTO);
        });

        verify(requestResourceRepository, times(1)).findByEmployeeId(123);
        verify(requestResourceRepository, never()).save(any(RequestResources.class));
    }

    @Test
    public void testCreateRequest_PendingRequest() {
        // Arrange
        RequestResourcesDTO requestDTO = new RequestResourcesDTO();
        requestDTO.setEmployeeId(123);
        requestDTO.setManagerId(456);
        requestDTO.setProjectId(789);

        RequestResources existingRequest = new RequestResources();
        existingRequest.setStatus("Pending");

        when(requestResourceRepository.findByEmployeeId(123)).thenReturn(Optional.of(existingRequest));

        // Act & Assert
        assertThrows(PendingRequestException.class, () -> {
            requestResourceService.createRequest(requestDTO);
        });

        verify(requestResourceRepository, times(1)).findByEmployeeId(123);
        verify(requestResourceRepository, never()).save(any(RequestResources.class));
    }
}

