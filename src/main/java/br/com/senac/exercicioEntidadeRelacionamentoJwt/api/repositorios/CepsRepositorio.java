package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.repositorios;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Ceps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepsRepositorio extends JpaRepository<Ceps, Long> {
}
