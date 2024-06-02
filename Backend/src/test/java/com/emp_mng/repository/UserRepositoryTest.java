package com.emp_mng.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.emp_mng.entities.User;




@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Mock
    private UserRepository mockUserRepository;
    

  
    @Test
    public void whenFindByEmail_thenReturnUser() {
        User user = new User();
        user.setEmail("riya.arj@example.com");

        when(mockUserRepository.findByEmail("riya.arj@example.com")).thenReturn(user);

        User found = mockUserRepository.findByEmail("riya.arj@example.com");
        assertThat(found.getEmail()).isEqualTo("riya.arj@example.com");
    }
   
  
   
  
}
