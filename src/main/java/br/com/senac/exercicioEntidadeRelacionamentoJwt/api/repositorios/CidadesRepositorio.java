package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.repositorios;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Cidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadesRepositorio extends JpaRepository<Cidades, Long> {
}
