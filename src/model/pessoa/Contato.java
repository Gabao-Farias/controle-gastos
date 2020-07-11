/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pessoa;

/**
 *
 * @author Gabriel
 */
public class Contato {
    private String telefoneCelular;
    private String telefoneFixo;
    private String email;
    private String emailAlternativo;
    private String site;

    public Contato(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
    
    public Contato(String telefoneCelular, String telefoneFixo, String email, String emailAlternativo, String site) {
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.email = email;
        this.emailAlternativo = emailAlternativo;
        this.site = site;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
    
}
