package br.com.cadastro.funcionario.exceptions;

import com.totvs.tjf.api.context.stereotype.ApiError;
import org.springframework.http.HttpStatus;

@ApiError(status = HttpStatus.NOT_FOUND, value = "FuncionarioNaoEncontradoException", helpUrl = "www.totvs.com.br/faq/frwk/3934856")
public class FuncionarioNaoEncontradoException extends RuntimeException {

    public FuncionarioNaoEncontradoException(String message) {
        super(message);
    }
}
