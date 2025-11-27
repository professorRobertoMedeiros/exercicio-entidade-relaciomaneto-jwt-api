package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.controllers;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.dtos.CepsRequestDTO;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Ceps;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.services.CepsService;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ceps")
@CrossOrigin
public class CepsController {

    @Autowired
    private CepsService cepsService;

    @GetMapping("/listar")
    public ResponseEntity<List<Ceps>> listarTodos() {
        return ResponseEntity.ok(cepsService.listar());
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody CepsRequestDTO entrada) {
        try {
            return ResponseEntity.ok(cepsService.criar(entrada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id,
                                       @RequestBody CepsRequestDTO entrada) {
        try {
            return ResponseEntity.ok(cepsService.atualizar(id, entrada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            cepsService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }
}
