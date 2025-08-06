package com.wagnerquadros.agendadortarefas.business.service;

import com.wagnerquadros.agendadortarefas.business.dto.TarefasDTO;
import com.wagnerquadros.agendadortarefas.business.mapper.TarefasConverter;
import com.wagnerquadros.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.wagnerquadros.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.wagnerquadros.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.wagnerquadros.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setEmailUsuario(email);
        dto.setDataCricacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);
        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }

}
