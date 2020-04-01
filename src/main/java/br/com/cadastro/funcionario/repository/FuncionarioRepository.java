package br.com.cadastro.funcionario.repository;

import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.funcionario.model.Funcionario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, ApiJpaRepository<Funcionario> {

}
