package br.com.alaimsistemaAPI.alaimsistemaAPI.repository;

import br.com.alaimsistemaAPI.alaimsistemaAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //algumas consultas simples com as palavras chaves find e Like e o nome do campo
    User findByCpf(String cpf);
    List<User> queryByNomeLike(String nome);

}
