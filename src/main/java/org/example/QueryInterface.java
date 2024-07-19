package org.example;

import org.example.Model.Cadastro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QueryInterface extends CrudRepository<Cadastro, Integer> {

    @Query(value = "SELECT * FROM Cadastro c WHERE c.email = :email",
        nativeQuery = true
    )
    List<Cadastro> finCadastroByEmail( @Param("email") String email);
}
