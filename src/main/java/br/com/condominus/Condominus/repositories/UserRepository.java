package br.com.condominus.Condominus.repositories;

import br.com.condominus.Condominus.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByCpf(String cpf);
    @Modifying
    @Query(value = "UPDATE User u SET u.enabled = false where u.cpf =:cpf")
    void disableUser(@Param("cpf") String cpf);

    @Modifying
    @Query(value = "UPDATE User u SET u.enabled = true where u.cpf =:cpf")
    void enableUser(@Param("cpf") String cpf);


}
