/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

import model.pessoa.Contato;
import model.pessoa.Pessoa;
import model.pessoa.Profissao;

/**
 *
 * @author Gabriel
 */
public class UsuarioComum extends Usuario {
    private String senha;
    private Pessoa pessoa;
    private Contato contato;
    private Profissao profissao;

    public UsuarioComum(String senha, Pessoa pessoa, Contato contato, Profissao profissao) {
        super();
        this.senha = senha;
        this.pessoa = pessoa;
        this.contato = contato;
        this.profissao = profissao;
    }
    
    public UsuarioComum(String id, String senha, Pessoa pessoa, Contato contato, Profissao profissao) {
        super(id);
        this.senha = senha;
        this.pessoa = pessoa;
        this.contato = contato;
        this.profissao = profissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }
    
    public String getUsuarioFormatado(){
        String csv;
        
        csv = (
                this.getId() +
                ";" +
                this.senha +
                ";" +
                this.pessoa.getNome() +
                ";" +
                this.pessoa.getSexo() +
                ";" +
                this.pessoa.getDataNascimentoFormatada() +
                ";" +
                this.contato.getTelefoneCelular() +
                ";" +
                this.contato.getTelefoneFixo() +
                ";" +
                this.contato.getEmail() +
                ";" +
                this.contato.getEmailAlternativo() +
                ";" +
                this.contato.getSite() +
                ";" +
                this.profissao.getNome() +
                ";" +
                this.profissao.getHorasTrabalhoDia() +
                ";" +
                this.profissao.getTurno() +
                ";" +
                this.profissao.getSalario().getValorLiquido() +
                ";" +
                this.profissao.getSalario().getValorBruto() +
                ";" +
                this.profissao.getSalario().getDataRecebimento()
            );
        return(csv);
    }
}
