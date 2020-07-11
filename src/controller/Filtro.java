/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import model.registros.Registro;

/**
 *
 * @author Gabriel
 */
public class Filtro extends BD_Registros{
    public Filtro() {
    }    
    
    private boolean menorIgualData(Date a, Date b){
        if(a.before(b)){
            return(true);
        }else{
            if(!(a.before(b))){
                return(false);
            }else{
                return(true);
            }
        }
    }
    
    private boolean maiorIgualData(Date a, Date b){
        if(a.after(b)){
            return(true);
        }else{
            if(!(a.after(b))){
                return(false);
            }else{
                return(true);
            }
        }
    }
    
    private ArrayList<Registro> filtrarResponsavel(String responsavel, ArrayList<Registro> lista){
        ArrayList<Registro> a = new ArrayList();
        int i=0;
        
        while(i < lista.size()){
            if(lista.get(i).getResponsavel().contains(responsavel)){
                a.add(lista.get(i));
            }
            i++;
        }
        return (a);
    }
    
    private ArrayList<Registro> filtrarDescricao(String descricao, ArrayList<Registro> lista){
        ArrayList<Registro> a = new ArrayList();
        int i=0;
        
        while(i < lista.size()){
            if(lista.get(i).getDescricao().contains(descricao)){
                a.add(lista.get(i));
            }
            i++;
        }
        return (a);
    }
    
    private ArrayList<Registro> filtrarValor(double valorMin, double valorMax, ArrayList<Registro> lista){
        ArrayList<Registro> a = new ArrayList();
        
        int i=0;
        
        while(i < lista.size()){
            if((lista.get(i).getValor() >= valorMin) && (lista.get(i).getValor() <= valorMax)){
                a.add(lista.get(i));
            }
            i++;
        }
        return (a);
    }
    
    private ArrayList<Registro> filtrarDataOperacao(Date dataInicial, Date dataFinal, ArrayList<Registro> lista){
        ArrayList<Registro> a = new ArrayList();
        
        int i=0;
        
        while(i < lista.size()){
            if(this.maiorIgualData(lista.get(i).getDataOperacao(), dataInicial) && this.menorIgualData(lista.get(i).getDataOperacao(), dataFinal)){
                a.add(lista.get(i));
            }
            i++;
        }
        return (a);
    }
    
    private ArrayList<Registro> filtrarDataVencimento(Date dataInicial, Date dataFinal, ArrayList<Registro> lista){
        ArrayList<Registro> a = new ArrayList();
        
        int i=0;
        
        while(i < lista.size()){
            if(this.maiorIgualData(lista.get(i).getDataOperacao(), dataInicial) && this.menorIgualData(lista.get(i).getDataOperacao(), dataFinal)){
                a.add(lista.get(i));
            }
            i++;
        }
        return (a);
    }
    
    private ArrayList<Registro> filtrarTipo(String tipo, ArrayList<Registro> lista){
        ArrayList<Registro> a = new ArrayList();
        int i=0;
        
        while(i < lista.size()){
            if(lista.get(i).getTipo().equals(tipo)){
                a.add(lista.get(i));
            }
            i++;
        }
        return (a);
    }
    
    private ArrayList<Registro> filtrarForma(String formaOperacao, ArrayList<Registro> lista){
        ArrayList<Registro> a = new ArrayList<>();
        int i=0;
        
        while(i < lista.size()){
            if(lista.get(i).getFormaOperacao().equals(formaOperacao)){
                a.add(lista.get(i));
            }
            i++;
        }
        return (a);
    }
    
    private ArrayList<Registro> filtrarCondicao(String condicaoOperacao, ArrayList<Registro> lista){
        ArrayList<Registro> a = new ArrayList<>();
        int i=0;
        
        while(i < lista.size()){
            if(lista.get(i).getCondicoesOperacao().equals(condicaoOperacao)){
                a.add(lista.get(i));
            }
            i++;
        }
        return (a);
    }
    
    public ArrayList<Registro> filtrar(ArrayList<String> dados, ArrayList<JToggleButton> estadoBotoes, ArrayList<Registro> original){
        ArrayList<Registro> filtrado = original;
        
        if(estadoBotoes.get(0).isSelected() && !(dados.get(0).equals("")))
            filtrado = this.filtrarResponsavel(dados.get(0), filtrado);
        if(estadoBotoes.get(1).isSelected() && !(dados.get(1).equals("")))
            filtrado = this.filtrarDescricao(dados.get(1), filtrado);
        if(estadoBotoes.get(2).isSelected() && !(dados.get(2).equals("") && !(dados.get(3).equals(""))))
            try{
                filtrado = this.filtrarValor(Double.parseDouble(dados.get(3)), Double.parseDouble(dados.get(2)), filtrado);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Utilize apenas algarismos e ponto para definir um número no filtro!");
            }
        if(estadoBotoes.get(3).isSelected() && !(dados.get(4).equals("")) && !(dados.get(5).equals(""))){
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                filtrado = this.filtrarDataVencimento(formato.parse(dados.get(4)), formato.parse(dados.get(5)), filtrado);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data! Retornando dados iniciais...");
                return(original);
            }
        }
        if(estadoBotoes.get(4).isSelected() && !(dados.get(4).equals("")) && !(dados.get(5).equals(""))){
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                filtrado = this.filtrarDataOperacao(formato.parse(dados.get(6)), formato.parse(dados.get(7)), filtrado);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data! Retornando dados iniciais...");
                return(original);
            }
        }
        if(estadoBotoes.get(5).isSelected())
            filtrado = this.filtrarTipo(dados.get(8), filtrado);
        if(estadoBotoes.get(6).isSelected())
            filtrado = this.filtrarForma(dados.get(9), filtrado);
        if(estadoBotoes.get(7).isSelected())
            filtrado = this.filtrarCondicao(dados.get(10), filtrado);
            
        return(filtrado);
    }
}
