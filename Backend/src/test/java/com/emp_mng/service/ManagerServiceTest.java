package com.emp_mng.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emp_mng.dto.ManagerDTO;
import com.emp_mng.entities.RoleType;
import com.emp_mng.repository.UserRepository;
//import com.emp_mng.service.ManagerService;

public class ManagerServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ManagerService managerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllManagers() {
     
        ManagerDTO manager1 = new ManagerDTO(1, "Manager 1");
        ManagerDTO manager2 = new ManagerDTO(2, "Manager 2");
        List<ManagerDTO> expectedManagers = Arrays.asList(manager1, manager2);

     
        when(userRepository.findManagersByRoleType(RoleType.MANAGER)).thenReturn(expectedManagers);

    
        List<ManagerDTO> result = managerService.findAllManagers();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactlyElementsOf(expectedManagers);
    }
}
