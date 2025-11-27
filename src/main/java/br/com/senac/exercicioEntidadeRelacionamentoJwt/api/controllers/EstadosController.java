package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.controllers;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.dtos.EstadosDTO;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Estados;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.services.EstadosService;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estados")
@CrossOrigin
public class EstadosController {

    @Autowired
    private EstadosService estadosService;

    @GetMapping("/listar")
    public ResponseEntity<List<Estados>> listarTodos() {
        return ResponseEntity.ok(estadosService.listar());
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody EstadosDTO entrada) {
        try {
            return ResponseEntity.ok(estadosService.criar(entrada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id,
                                       @RequestBody EstadosDTO entrada) {
        try {
            return ResponseEntity.ok(estadosService.atualizar(id, entrada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            estadosService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }
}
