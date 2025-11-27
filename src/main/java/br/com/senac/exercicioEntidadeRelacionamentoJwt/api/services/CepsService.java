package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.services;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.dtos.CepsRequestDTO;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Ceps;
import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.repositorios.CepsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CepsService {

    @Autowired
    private CepsRepositorio cepsRepositorio;

    public List<Ceps> listar() {
        return cepsRepositorio.findAll();
    }

    public Ceps criar(CepsRequestDTO cep) {

        return cepsRepositorio.save(this.cepsRequestDtoParaCeps(cep));
    }

    public Ceps atualizar(Long id, CepsRequestDTO cep) {
        if(!cepsRepositorio.existsById(id)) {
            throw new RuntimeException("Cep não encontrado");
        }

        Ceps cepsPersist = this.cepsRequestDtoParaCeps(cep);
        cepsPersist.setId(id);

        return cepsRepositorio.save(cepsPersist);
    }

    public void deletar(Long id) {
        if(!cepsRepositorio.existsById(id)) {
            throw new RuntimeException("Cep não encontrado");
        }
    }

    private Ceps cepsRequestDtoParaCeps(CepsRequestDTO entrada) {
        Ceps saida = new Ceps();
        saida.setCep(entrada.getCep());
        saida.setBairro(entrada.getBairro());
        saida.setRua(entrada.getRua());

        return saida;
    }
}
