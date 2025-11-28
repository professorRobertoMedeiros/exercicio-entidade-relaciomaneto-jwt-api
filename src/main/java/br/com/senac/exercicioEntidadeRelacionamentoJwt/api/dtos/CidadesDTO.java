package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.dtos;

public class CidadesDTO {
    private String nome;
    private Long estadoId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
