package br.com.condominus.Condominus.unitTests.mockito;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.repositories.UserRepository;
import br.com.condominus.Condominus.services.UserService;
import br.com.condominus.Condominus.unitTests.MockUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    MockUser input;

    @Mock
    UserRepository repository;

    @InjectMocks
    private UserService service;

    @BeforeEach
    void setUpMocks() {
        input = new MockUser();
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void createUser() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByCPF() {
        User user = input.mockEntity();
        when(repository.findByCpf(user.getCpf())).thenReturn(Optional.of(user));

        var result = service.findByCPF("Cpf Test1");
        assertNotNull(result);
        assertNotNull(result.getName());
        assertNotNull(result.getPhone());
        assertNotNull(result.getRole());
        assertNotNull(result.getEmail());
        assertNotNull(result.getBirthDay());
        assertNotNull(result.getCondominiumPrice());
        assertNotNull(result.getApartmentNumber());


    }

    @Test
    void findByName() {
    }

    @Test
    void updateUserByCpf() {
    }

    @Test
    void disableUserByCpf() {
    }

    @Test
    void enableUserByCpf() {
    }
}