package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.services;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.dtos.EstadosDTO;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Estados;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.repositorios.EstadosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadosService {

    @Autowired
    private EstadosRepositorio estadosRepositorio;

    public List<Estados> listar() {
        return estadosRepositorio.findAll();
    }

    public Estados criar(EstadosDTO estado) {

        return estadosRepositorio.save(this.estadosRequestDtoParaEstados(estado));
    }

    public Estados atualizar(Long id, EstadosDTO estado) {
        if(!estadosRepositorio.existsById(id)) {
            throw new RuntimeException("Estado não encontrado");
        }

        Estados estadosPersist = this.estadosRequestDtoParaEstados(estado);
        estadosPersist.setId(id);

        return estadosRepositorio.save(estadosPersist);
    }

    public void deletar(Long id) {
        if(!estadosRepositorio.existsById(id)) {
            throw new RuntimeException("Estado não encontrado");
        }
    }

    private Estados estadosRequestDtoParaEstados(EstadosDTO entrada) {
        Estados saida = new Estados();
        saida.setUf(entrada.getUf());

        return saida;
    }

    public Estados listarById(Long id) {
        Optional<Estados> estadoResult = estadosRepositorio.findById(id);
        if(estadoResult.isEmpty()) {
            throw new RuntimeException("Estado não encontrado");
        }

        return estadoResult.get();
    }
}
