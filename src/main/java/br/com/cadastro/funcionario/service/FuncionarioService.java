package br.com.cadastro.funcionario.service;

import br.com.cadastro.funcionario.exceptions.FuncionarioNaoEncontradoException;
import br.com.cadastro.funcionario.model.Funcionario;
import br.com.cadastro.funcionario.repository.FuncionarioRepository;
import com.totvs.tjf.api.context.v1.request.ApiFieldRequest;
import com.totvs.tjf.api.context.v1.request.ApiPageRequest;
import com.totvs.tjf.api.context.v1.response.ApiCollectionResponse;
import com.totvs.tjf.core.validation.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ValidatorService validatorService;

	public ApiCollectionResponse<Funcionario> obterListaDeFuncionarios(ApiPageRequest apiPage, ApiFieldRequest apiFieldRequest) throws FuncionarioNaoEncontradoException {
		ApiCollectionResponse<Funcionario> funcionarios = this.funcionarioRepository.findAllProjected(apiFieldRequest, apiPage);
		if (funcionarios.getItems().isEmpty()) {
			throw new FuncionarioNaoEncontradoException("Não há funcionários cadastrados.");
		}
		return funcionarios;
	}

	public Funcionario obterFuncionarioDetalhado(ApiFieldRequest field, Funcionario simpleFilter) throws FuncionarioNaoEncontradoException {
		Optional<Funcionario> funcionario = this.funcionarioRepository.findOne(simpleFilter, field);
		if (!funcionario.isPresent()) {
			throw new FuncionarioNaoEncontradoException("Funcionário não cadastrado.");
		}
		return funcionario.get();
	}

	public Funcionario cadastrarFuncionario(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}

}
