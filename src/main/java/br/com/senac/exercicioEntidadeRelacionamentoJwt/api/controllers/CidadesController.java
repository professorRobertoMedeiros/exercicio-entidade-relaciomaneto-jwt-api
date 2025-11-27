package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.controllers;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.dtos.CidadesDTO;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Cidades;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.services.CidadesService;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cidades")
@CrossOrigin
public class CidadesController {

    @Autowired
    private CidadesService cidadesService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cidades>> listarTodos() {
        return ResponseEntity.ok(cidadesService.listar());
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody CidadesDTO entrada) {
        try {
            return ResponseEntity.ok(cidadesService.criar(entrada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id,
                                       @RequestBody CidadesDTO entrada) {
        try {
            return ResponseEntity.ok(cidadesService.atualizar(id, entrada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            cidadesService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }
}
