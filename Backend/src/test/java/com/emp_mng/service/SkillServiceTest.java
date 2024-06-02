package com.emp_mng.service;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emp_mng.dto.UserDetailsDTO;
import com.emp_mng.repository.SkillRepository;


public class SkillServiceTest {

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private SkillService skillService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsersBySkillName() {
        
        UserDetailsDTO user1 = new UserDetailsDTO(1, "Ria Arj", "riya.arj@example.com");
        UserDetailsDTO user2 = new UserDetailsDTO(2, "Sia Smith", "sia.smith@example.com");
        List<UserDetailsDTO> expectedUsers = Arrays.asList(user1, user2);

        when(skillRepository.findUsersBySkillName(anyString())).thenReturn(expectedUsers);

      
        List<UserDetailsDTO> actualUsers = skillService.getUsersBySkillName("Java");
        assertThat(actualUsers).isNotNull();
        assertThat(actualUsers.size()).isEqualTo(2);
        assertThat(actualUsers).isEqualTo(expectedUsers);
    }
}
