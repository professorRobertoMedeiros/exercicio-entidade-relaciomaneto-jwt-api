package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.services;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.dtos.CidadesDTO;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Cidades;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.repositorios.CidadesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadesService {

    @Autowired
    private CidadesRepositorio cidadesRepositorio;

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
        Cidades saida = new Cidades();
        saida.setNome(entrada.getNome());

        return saida;
    }
}
