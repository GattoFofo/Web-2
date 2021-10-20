package model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "devolucao", nullable = false)
    private Date devolucao;

    public Classe() {
    }

    public Classe(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }
}
