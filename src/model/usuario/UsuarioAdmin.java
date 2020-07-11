/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

/**
 *
 * @author Gabriel
 */
public class UsuarioAdmin extends Usuario{
    private String senha;

    public UsuarioAdmin(String senha) {
        super();
            this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getAdminFormatado(){
        String s = "";
        
        s = (
                this.getId() +
                ";" +
                this.senha +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";" +
                ";"
            );
        
        return (s);
    }
}
