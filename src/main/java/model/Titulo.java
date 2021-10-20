package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Titulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany
    private List<Ator> ators;
    @ManyToOne
    private Diretor diretor;
    private int ano;
    private String sinopse;
    private String categoria;
    @ManyToOne
    private Classe classe;

    public Titulo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ator> getAtors() {
        return ators;
    }

    public void setAtors(List<Ator> ators) {
        this.ators = ators;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public boolean containsAtorId(int id) {
        for (Ator ator : this.ators) if (ator.getId() == id) return true;
        return false;
    }
}
