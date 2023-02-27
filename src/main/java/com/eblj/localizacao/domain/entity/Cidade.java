package com.eblj.localizacao.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_cidade")
public class Cidade {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Long id;
     @Column(name = "nome",length = 50)
     private String nome;
     @Column(name = "qtd_habitantes")
     private Long habitantes;

     public Cidade(){}
    public Cidade(Long id, String nome, Long habitantes) {
        this.id = id;
        this.nome = nome;
        this.habitantes = habitantes;
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

    public Long getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Long habitantes) {
        this.habitantes = habitantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id.equals(cidade.id) && Objects.equals(nome, cidade.nome) && Objects.equals(habitantes, cidade.habitantes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, habitantes);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", habitantes=" + habitantes +
                '}';
    }
}
