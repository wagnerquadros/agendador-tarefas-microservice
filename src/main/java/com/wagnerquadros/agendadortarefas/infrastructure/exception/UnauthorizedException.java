package com.wagnerquadros.agendadortarefas.infrastructure.exception;

import org.springframework.security.core.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {

    public UnauthorizedException(String mensagem) {
        super(mensagem);
    }

    public UnauthorizedException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
