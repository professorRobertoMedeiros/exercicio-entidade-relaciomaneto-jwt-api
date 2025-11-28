package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2)
    private String uf;

    @OneToMany(mappedBy = "estado")
    @JsonManagedReference
    private List<Cidades> cidadesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Cidades> getCidadesList() {
        return cidadesList;
    }

    public void setCidadesList(List<Cidades> cidadesList) {
        this.cidadesList = cidadesList;
    }
}
