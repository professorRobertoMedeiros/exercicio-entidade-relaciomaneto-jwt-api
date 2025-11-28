package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.services;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.dtos.CidadesDTO;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Cidades;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Estados;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.repositorios.CidadesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadesService {

    @Autowired
    private CidadesRepositorio cidadesRepositorio;

    private EstadosService estadosService;

    public CidadesService(EstadosService estadosService) {
        this.estadosService = estadosService;
    }

    public List<Cidades> listar() {
        return cidadesRepositorio.findAll();
    }

    public Cidades criar(CidadesDTO cidade) {

        return cidadesRepositorio.save(this.cidadesRequestDtoParaCidades(cidade));
    }

    public Cidades atualizar(Long id, CidadesDTO cidade) {
        if(!cidadesRepositorio.existsById(id)) {
            throw new RuntimeException("Cidade não encontrado");
        }

        Cidades cidadesPersist = this.cidadesRequestDtoParaCidades(cidade);
        cidadesPersist.setId(id);

        return cidadesRepositorio.save(cidadesPersist);
    }

    public void deletar(Long id) {
        if(!cidadesRepositorio.existsById(id)) {
            throw new RuntimeException("Cidade não encontrado");
        }
    }

    private Cidades cidadesRequestDtoParaCidades(CidadesDTO entrada) {
        Estados estadoResult =
                estadosService.listarById(entrada.getEstadoId());
        Cidades saida = new Cidades();
        saida.setNome(entrada.getNome());
        saida.setEstado(estadoResult);

        return saida;
    }

    public Cidades listarById(Long id) {
        Optional<Cidades> cidadeResult = cidadesRepositorio.findById(id);
        if(cidadeResult.isEmpty()) {
            throw new RuntimeException("Cidade não encontrada");
        }

        return cidadeResult.get();
    }
}
