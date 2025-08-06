package com.wagnerquadros.agendadortarefas.controller;

import com.wagnerquadros.agendadortarefas.business.dto.TarefasDTO;
import com.wagnerquadros.agendadortarefas.business.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, dto));
    }
}
