package model;

import jakarta.persistence.*;

@Entity
@Table(name = "ator")
public class Ator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAtor", nullable = false)
    private int id;

    @Column(name = "nome", nullable = false)
    private String name;

    public Ator(String nome) {
        this.name = nome;
    }

    public Ator() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
