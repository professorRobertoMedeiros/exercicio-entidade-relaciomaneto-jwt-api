package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.repositorios;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepositorio extends JpaRepository<Estados, Long> {
}
