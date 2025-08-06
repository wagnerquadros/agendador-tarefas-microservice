package com.wagnerquadros.agendadortarefas.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wagnerquadros.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTO {
    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCricacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificacaoEnum statusNotificacaoEnum;
}
