package com.api.pessoasapi.reposirory;

import com.api.pessoasapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PessoaReposirory extends JpaRepository<Pessoa,Long> {
    @Query(value = "SELECT * FROM PESSOAS WHERE nome = ?nome limit 1", nativeQuery = true)
    public Optional<Pessoa> getPessoaPorNome(String nome);
}
