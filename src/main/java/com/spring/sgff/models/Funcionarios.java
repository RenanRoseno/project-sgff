package com.spring.sgff.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "funcionarios")

public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String nome;

    private String dataAdmissao;

    private int cargo;

    private String telefone;

    @OneToMany
    @JoinColumn(name = "funcionario_id")
    private List<Ponto> ponto;

    @NotBlank
    private String senha;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @NotBlank
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPonto(List<Ponto> ponto) {
        this.ponto = ponto;
    }

    public List<Ponto> getPonto() {
        return this.ponto;
    }

    @Override
    public String toString() {
        return "Funcionarios{" + "id=" + id + ", cpf=" + cpf + ", rg=" + rg + ", nome=" + nome + ", dataAdmissao="
                + dataAdmissao + ", cargo=" + cargo + ", telefone=" + telefone + ", senha=" + senha + ", email=" + email
                + '}';
    }
}
