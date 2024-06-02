package com.emp_mng.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp_mng.entities.RequestResources;
import com.emp_mng.service.RequestResourceService;

@SpringBootTest
public class RequestResourceRepositoryTest {

    @Mock
    private RequestResourceRepository requestResourceRepository;

    @InjectMocks
    private RequestResourceService requestResourceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByEmployeeId() {
        
        int employeeId = 123;
        RequestResources requestResource = new RequestResources();
        requestResource.setEmployeeId(employeeId);
        
        Optional<RequestResources> optionalRequestResource = Optional.of(requestResource);

        when(requestResourceRepository.findByEmployeeId(employeeId)).thenReturn(optionalRequestResource);

     
        Optional<RequestResources> foundRequestResource = requestResourceRepository.findByEmployeeId(employeeId);

      
        assertThat(foundRequestResource).isPresent();
        assertThat(foundRequestResource.get().getEmployeeId()).isEqualTo(employeeId);
    }

    @Test
    public void testFindByEmployeeId_NotFound() {
     
        int employeeId = 123;

        when(requestResourceRepository.findByEmployeeId(employeeId)).thenReturn(Optional.empty());

     
        Optional<RequestResources> foundRequestResource = requestResourceRepository.findByEmployeeId(employeeId);

        
        assertThat(foundRequestResource).isNotPresent();
    }
    @Test
    public void testFindByStatus() {
        // Arrange
        String status = "APPROVED";
        RequestResources requestResource1 = new RequestResources();
        requestResource1.setStatus(status);
        requestResource1.setEmployeeId(1);

        RequestResources requestResource2 = new RequestResources();
        requestResource2.setStatus(status);
        requestResource2.setEmployeeId(2);

        List<RequestResources> requestResourcesList = Arrays.asList(requestResource1, requestResource2);

        when(requestResourceRepository.findByStatus(status)).thenReturn(requestResourcesList);

        List<RequestResources> foundRequestResources = requestResourceRepository.findByStatus(status);
        assertThat(foundRequestResources).hasSize(2);
        assertThat(foundRequestResources).extracting(RequestResources::getStatus).containsOnly(status);
        assertThat(foundRequestResources).extracting(RequestResources::getEmployeeId).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    public void testFindByStatus_Empty() {
        String status = "PENDING";

        when(requestResourceRepository.findByStatus(status)).thenReturn(Arrays.asList());
        List<RequestResources> foundRequestResources = requestResourceRepository.findByStatus(status);
        assertThat(foundRequestResources).isEmpty();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

