/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.usuario;

import controller.BD_Usuarios;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public abstract class Usuario {
    private String id;

    public Usuario() {
        this.id = this.defineID();
    }
    
    public Usuario(String id){
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    private String defineID(){
        boolean flag = false;
        int i = 0;
        int j = 0;
        int newID = 0;
        BD_Usuarios arq = new BD_Usuarios();
        ArrayList listaIDs = new ArrayList();
        
        listaIDs = arq.getUsuariosIDs();
        
        while(i < listaIDs.size()){
            
            j = 0;
            flag = false;
            while(j < listaIDs.size() && flag == false){
                if(newID == (int) listaIDs.get(j)){
                    flag = true;
                }
                j++;
            }
            
            if(flag==false){
                return(Integer.toString(newID));
            }
            newID++;
            i++;
        }
        
        return(Integer.toString(newID));
    }
}
