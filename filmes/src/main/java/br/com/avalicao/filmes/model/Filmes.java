package br.com.avalicao.filmes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "Filmes")
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "tipo_filme")
    private String tipoFilme;

    @NotNull
    @Column(name = "duracao")
    private int duracao;

    @NotNull
    @Column(name = "avaliacao")
    private double estrelasAvaliacao;

    public Filmes() {
    }

    public Filmes(Long id, String nome, String tipoFilme, int duracao, int estrelasAvaliacao) {
        this.id = id;
        this.nome = nome;
        this.tipoFilme = tipoFilme;
        this.duracao = duracao;
        this.estrelasAvaliacao = estrelasAvaliacao;
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

    public String getTipoFilme() {
        return tipoFilme;
    }

    public void setTipoFilme(String tipoFilme) {
        this.tipoFilme = tipoFilme;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double getEstrelasAvaliacao() {
        return estrelasAvaliacao;
    }

    public void setEstrelasAvaliacao(double estrelasAvaliacao) {
        this.estrelasAvaliacao = estrelasAvaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Filmes filmes = (Filmes) o;
        return Objects.equals(id, filmes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
