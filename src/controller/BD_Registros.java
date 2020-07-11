/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.registros.Registro;

/**
 *
 * @author Gabriel
 */
public class BD_Registros {
    protected File file;
    
    protected FileInputStream fileInputStream;
    protected InputStreamReader inputStreamReader;
    protected BufferedReader bufferedReader;
    
    protected BufferedWriter bufferedWriter;
    protected FileWriter fileWriter;

    public BD_Registros() {}
    
    public void alterarRegistro(String idRegistro, String csvRegistroAtualizado){
        ArrayList listaNova = new ArrayList(getRegistrosPreAlteracao(idRegistro, csvRegistroAtualizado));
        int i = 0;
        
        try{
            this.file = new File("db_registers.txt");
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            
            this.bufferedWriter.write("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação");
            this.bufferedWriter.newLine();
            
            while(i < listaNova.size()){
                this.bufferedWriter.write(listaNova.get(i).toString());
                
                if(!(i == listaNova.size() - 1)){
                    this.bufferedWriter.newLine();
                }
                
                i++;
            }
            
            bufferedWriter.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void excluirRegistro(String idRegistro){
        ArrayList listaNova = new ArrayList(getRegistrosPreExlcusao(idRegistro));
        int i = 0;
        
        try{
            this.file = new File("db_registers.txt");
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            
            this.bufferedWriter.write("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação");
            this.bufferedWriter.newLine();
            
            while(i < listaNova.size()){
                this.bufferedWriter.write(listaNova.get(i).toString());
                
                if(!(i == listaNova.size() - 1)){
                    this.bufferedWriter.newLine();
                }
                
                i++;
            }
            
            bufferedWriter.close();
            
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void excluirTodosRegistrosUsuario(String idUsuario){
        ArrayList listaNova = new ArrayList(getRegistrosPreExlusaoUsuario(idUsuario));
        int i = 0;
        
        try{
            this.file = new File("db_registers.txt");
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            
            this.bufferedWriter.write("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação");
            this.bufferedWriter.newLine();
            
            while(i < listaNova.size()){
                this.bufferedWriter.write(listaNova.get(i).toString());
                
                if(!(i == listaNova.size() - 1)){
                    this.bufferedWriter.newLine();
                }
                
                i++;
            }
            
            bufferedWriter.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean registerExists(String idRegister){
        String auxLinha;
        
        try{
            this.file = new File("db_registers.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação"))){
                        if(!(auxLinha.equals(""))){
                            if(this.getIDRegistro(auxLinha).equals(idRegister)){
                                
                                bufferedReader.close();
                                
                                return(true);
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(false);
        }
    }
    
    protected String getID(String csv){
        int i=0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                return(csv.substring(0, i));
            }
            i++;
        }
        return(null);
    }
    
    protected String getResponsavel(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 2){
                    start = i + 1;
                }else{
                    if(contSemicolon == 3){
                        end = i;
                        
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    private String getIDRegistro(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 1){
                    start = i + 1;
                }else{
                    if(contSemicolon == 2){
                        end = i;
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    protected Object csvToRegistroObject(String csv) throws ParseException{
        Registro r = new Registro();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        int i, start, end, contSemicolon;
        i = start = end = contSemicolon = 0;
        
        while(contSemicolon < 9){
            
            if(csv.charAt(i) == ';'){
                end = i;
                contSemicolon++;
                
                switch(contSemicolon){
                    case 1:
                        r.setId(csv.substring(start, end));
                        break;
                    case 2:
                        r.setIdRegistro(csv.substring(start, end));
                        break;
                    case 3:
                        r.setResponsavel(csv.substring(start, end));
                        break;
                    case 4:
                        r.setValor(Double.parseDouble(csv.substring(start, end)));
                        break;
                    case 5:
                        r.setDescricao(csv.substring(start, end));
                        break;
                    case 6:
                        r.setDataVencimento(formato.parse(csv.substring(start, end)));
                        break;
                    case 7:
                        r.setDataOperacao(formato.parse(csv.substring(start, end)));
                        break;
                    case 8:
                        r.setTipo(csv.substring(start, end));
                        break;
                    case 9:
                        r.setFormaOperacao(csv.substring(start, end));
                        break;
                }
                start = i + 1;
            }
            i++;
        }
        
        r.setCondicoesOperacao(csv.substring(start, csv.length()));
                
        return(r);
    }
    
    public ArrayList<Registro> getRegistrosUsuario(String id){
        ArrayList<Registro> a = new ArrayList();
        String auxLinha;
        
        try{
            this.file = new File("db_registers.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação"))){
                        if(!(auxLinha.equals(""))){
                            
                            if(this.getID(auxLinha).equals(id)){
                                a.add((Registro) this.csvToRegistroObject(auxLinha));
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            return a;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    private ArrayList getRegistrosPreAlteracao(String idRegistroAlterado, String csvRegistroAtualizado){
        String auxLinha;
        int j;
        ArrayList listaUsuarios = new ArrayList();
        
        try{
            this.file = new File("db_registers.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação"))){
                        if(!(auxLinha.equals(""))){
                            if(!(idRegistroAlterado.equals(getIDRegistro(auxLinha)))){
                                listaUsuarios.add(auxLinha);
                            }else{
                                listaUsuarios.add(csvRegistroAtualizado);
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            
            return(listaUsuarios);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    private ArrayList getRegistrosPreExlcusao(String idRegistroExcluido){
        String auxLinha;
        ArrayList listaRegistros = new ArrayList();
        
        try{
            this.file = new File("db_registers.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação"))){
                        if(!(auxLinha.equals(""))){
                            if(!(idRegistroExcluido.equals(getIDRegistro(auxLinha)))){                                
                                listaRegistros.add(auxLinha);
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            
            return(listaRegistros);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    private ArrayList getRegistrosPreExlusaoUsuario(String idUsuario){
        String auxLinha;
        ArrayList listaRegistros = new ArrayList();
        
        try{
            this.file = new File("db_registers.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação"))){
                        if(!(auxLinha.equals(""))){
                            if(!(idUsuario.equals(getID(auxLinha)))){
                                listaRegistros.add(auxLinha);
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            
            return(listaRegistros);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    public ArrayList getListaIDRegistros(){
        String auxLinha = "";
        int j;
        ArrayList listaIDs = new ArrayList();
        
        try{
            this.file = new File("db_registers.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação"))){
                        if(!(auxLinha.equals(""))){
                            listaIDs.add(Integer.parseInt(this.getIDRegistro(auxLinha)));
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            
            return(listaIDs);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    public Registro getRegistro(String idRegistro){
        String auxLinha;
        
        try{
            this.file = new File("db_registers.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);

            do{
                auxLinha = bufferedReader.readLine();

                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação"))){
                        if(!(auxLinha.equals(""))){
                            if(this.getIDRegistro(auxLinha).equals(idRegistro)){
                                bufferedReader.close();
                                return((Registro) this.csvToRegistroObject(auxLinha));
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            bufferedReader.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return(null);
    }
    
    public void novoRegistro(String dados){
        try{
            this.file = new File("db_registers.txt");
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true),"UTF-8"));
            
            this.bufferedWriter.newLine();
            this.bufferedWriter.write(dados);
            
            bufferedWriter.close();
            
        }catch(Exception e){
        }
    }
}
