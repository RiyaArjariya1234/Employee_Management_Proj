package com.emp_mng.repository;

import com.emp_mng.dto.UserDetailsDTO;
//import com.emp_mng.repository.SkillRepository;
import com.emp_mng.service.SkillService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class SkillRepositoryTest {

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private SkillService skillService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUsersBySkillName() {
        // Arrange
        UserDetailsDTO user1 = new UserDetailsDTO(1, "User One", "userone@example.com");
        UserDetailsDTO user2 = new UserDetailsDTO(2, "User Two", "usertwo@example.com");
        List<UserDetailsDTO> expectedUsers = Arrays.asList(user1, user2);

        when(skillRepository.findUsersBySkillName(anyString())).thenReturn(expectedUsers);

        // Act
        List<UserDetailsDTO> foundUsers = skillService.getUsersBySkillName("Java");

        // Assert
        assertThat(foundUsers).isNotNull();
        assertThat(foundUsers).hasSize(expectedUsers.size());
        assertThat(foundUsers).containsExactlyElementsOf(expectedUsers);
    }
}

