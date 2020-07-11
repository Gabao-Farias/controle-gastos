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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.pessoa.Contato;
import model.pessoa.Pessoa;
import model.pessoa.Profissao;
import model.pessoa.Salario;
import model.usuario.UsuarioAdmin;
import model.usuario.UsuarioComum;

/**
 *
 * @author Gabriel
 */
public class BD_Usuarios {
    private File file;
    
    private FileInputStream fileInputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    
    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;

    public BD_Usuarios() {}

    public boolean autenticarUsuario(String nome, String senha){
        String auxLinha, bd_nome, bd_senha;
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            bd_nome = this.getNome(auxLinha);
                            bd_senha = this.getSenha(auxLinha);
                            
                            if(bd_nome.equals(nome) && bd_senha.equals(senha)){
                                bufferedReader.close();
                                return(true);
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            JOptionPane.showMessageDialog(null, "Login Negado! Não existem tais credenciais cadastradas no sistema.");
            
            return(false);
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Arquivo db_users.txt não encontrado no diretório raíz!\nCertifique-se de que o arquivo exista e esteja devidamente formatado!");
            return(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(false);
        }
    }
    
    public boolean autenticarAdmin(String senha){
        String auxLinha, bd_senha;
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            bd_senha = this.getSenha(auxLinha);
                            
                            if(bd_senha.equals(senha)){
                                if(this.getID(auxLinha).equals("0")){
                                    return(true);
                                }else{
                                    return(false);
                                }
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            return(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(false);
        }
    }
    
    public boolean isUsuarioComum(String nome, String senha){
        String auxLinha, bd_nome, bd_senha;
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            bd_nome = this.getNome(auxLinha);
                            bd_senha = this.getSenha(auxLinha);
                            
                            if(bd_nome.equals(nome) && bd_senha.equals(senha)){
                                if(!(this.getID(auxLinha).equals("0"))){
                                    return(true);
                                }else{
                                    return(false);
                                }
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            return(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(false);
        }
    }
    
    public void novoUsuario(String nomeArquivo, String dados){
        try{
            this.file = new File(nomeArquivo);
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true),"UTF-8"));
            
            this.bufferedWriter.newLine();
            this.bufferedWriter.write(dados);
            
            bufferedWriter.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public UsuarioComum toUsuarioComum(String csv) throws ParseException{
        
        String id = "";
        String senha = "";
        
        String nome = "";
        String sexo = "";
        Date dataNascimento = null;
        
        String telefoneCelular = "";
        String telefoneFixo = "";
        String email = "";
        String emailAlternativo = "";
        String site = "";
        
        String nomeProfissao = "";
        int jornadaTrabalho = 0;
        String turno = "";
        
        double valorLiquido = 0.0;
        double valorBruto = 0.0;
        int diaRecebimento = 0;
        
        
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        
        
        int i, start, end, contSemicolon;
        
        i = start = end = contSemicolon = 0;
        while(contSemicolon < 15){
            
            if(csv.charAt(i) == ';'){
                end = i;
                contSemicolon++;
                
                switch(contSemicolon){
                    case 1:
                        id = csv.substring(start, end);
                        break;
                    case 2:
                        senha = csv.substring(start, end);
                        break;
                    case 3:
                        nome = csv.substring(start, end);
                        break;
                    case 4:
                        if(csv.substring(start, end).equals("null")){
                            sexo = null;
                        }else{
                            sexo = csv.substring(start, end);
                        }
                        break;
                    case 5:
                        if(csv.substring(start, end).equals("null")){
                            dataNascimento = null;
                        }else{
                            dataNascimento = formato.parse(csv.substring(start, end));
                        }
                        break;
                    case 6:
                        telefoneCelular = csv.substring(start, end);
                        break;
                    case 7:
                        telefoneFixo = csv.substring(start, end);
                        break;
                    case 8:
                        email = csv.substring(start, end);
                        break;
                    case 9:
                        emailAlternativo = csv.substring(start, end);
                        break;
                    case 10:
                        site = csv.substring(start, end);
                        break;
                    case 11:
                        nomeProfissao = csv.substring(start, end);
                        break;
                    case 12:
                        jornadaTrabalho = Integer.parseInt(csv.substring(start, end));
                        break;
                    case 13:
                        turno = csv.substring(start, end);
                        break;
                    case 14:
                        valorLiquido = Double.parseDouble(csv.substring(start, end));
                        break;
                    case 15:
                        valorBruto = Double.parseDouble(csv.substring(start, end));
                        break;
                }
                start = i + 1;
            }
            i++;
        }
        
        diaRecebimento = Integer.parseInt(csv.substring(start, csv.length()));
        
        return(
                new UsuarioComum(id, senha,
                        new Pessoa(nome, sexo, dataNascimento),
                        new Contato(telefoneCelular, telefoneFixo, email, emailAlternativo, site),
                        new Profissao(nomeProfissao, jornadaTrabalho, turno, new Salario(valorLiquido, valorBruto, diaRecebimento)))
                );
    }
    
    public UsuarioAdmin toUsuarioAdmin(String csv){
        String senha = "";        
        
        int i, start, end, contSemicolon;
        
        i = start = end = contSemicolon = 0;
        while(contSemicolon < 3){
            
            if(csv.charAt(i) == ';'){
                end = i;
                contSemicolon++;
                
                switch(contSemicolon){
                    case 2:
                        senha = csv.substring(start, end);
                        break;
                }
                start = i + 1;
            }
            i++;   
        }
        return(new UsuarioAdmin(senha));
    }
    
    public void excluirUsuario(String ID){
        ArrayList listaNova = new ArrayList(getUsuariosPreExlcusao(ID));
        int i = 0;
        
        try{
            this.file = new File("db_users.txt");
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            
            this.bufferedWriter.write("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento");
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
    
    public void alterarUsuario(String id, String csvAtualizado){
        ArrayList listaNova = new ArrayList(getUsuariosPreAlteracao(id, csvAtualizado));
        int i = 0;
        
        try{
            this.file = new File("db_users.txt");
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            
            this.bufferedWriter.write("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento");
            this.bufferedWriter.newLine();
            
            while(i < listaNova.size()){
                this.bufferedWriter.write(listaNova.get(i).toString());
                
                if(!(i == listaNova.size() - 1)){
                    this.bufferedWriter.newLine();
                }
                
                i++;
            }
            
            bufferedWriter.close();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Arquivo db_users.txt não encontrado no diretório raíz!\nCertifique-se de que o arquivo exista e esteja devidamente formatado!");
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public String getID(String csv){
        int i=0;        
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                return(csv.substring(0, i));
            }
            i++;
        }
        
        return(null);
    }
    
    public String getSenha(String csv){
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
    
    public String getNome(String csv){
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
    
    public String getSexo(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 3){
                    start = i + 1;
                }else{
                    if(contSemicolon == 4){
                        end = i;
                        
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public Date getDataNascimento(String csv){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 4){
                    start = i + 1;
                }else{
                    if(contSemicolon == 5){
                        try {
                            end = i;
                            d = formato.parse(csv.substring(start, end));
                            return(d);
                        } catch (ParseException e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public String getTelefoneCelular(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 5){
                    start = i + 1;
                }else{
                    if(contSemicolon == 6){
                        end = i;
                        
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public String getTelefoneFixo(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 6){
                    start = i + 1;
                }else{
                    if(contSemicolon == 7){
                        end = i;
                        
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public String getEmail(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 7){
                    start = i + 1;
                }else{
                    if(contSemicolon == 8){
                        end = i;
                        
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public String getEmailAlternativo(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 8){
                    start = i + 1;
                }else{
                    if(contSemicolon == 9){
                        end = i;
                        
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public String getSite(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 9){
                    start = i + 1;
                }else{
                    if(contSemicolon == 10){
                        end = i;
                        
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public String getNomeProfissao(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 10){
                    start = i + 1;
                }else{
                    if(contSemicolon == 11){
                        end = i;
                        
                        return(csv.substring(start, end));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public int getJornadaTrabalho(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 11){
                    start = i + 1;
                }else{
                    if(contSemicolon == 12){
                        end = i;
                        
                        return(Integer.parseInt(csv.substring(start, end)));
                    }
                }
            }
            i++;
        }
        return(0);
    }
    
    public String getTurno(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 12){
                    start = i + 1;
                }else{
                    if(contSemicolon == 13){
                        end = i;
                        
                        return((csv.substring(start, end)));
                    }
                }
            }
            i++;
        }
        return(null);
    }
    
    public double getValorLiquido(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 13){
                    start = i + 1;
                }else{
                    if(contSemicolon == 14){
                        end = i;
                        
                        return(Double.parseDouble(csv.substring(start, end)));
                    }
                }
            }
            i++;
        }
        return(0);
    }
    
    public double getValorBruto(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 14){
                    start = i + 1;
                }else{
                    if(contSemicolon == 15){
                        end = i;
                        
                        return(Double.parseDouble(csv.substring(start, end)));
                    }
                }
            }
            i++;
        }
        return(0);
    }
    
    public int getDiaRecebimento(String csv){
        int i, contSemicolon, start, end;
        
        i = contSemicolon = start = end = 0;
        
        while(i < csv.length()){
            if(csv.charAt(i) == ';'){
                contSemicolon++;
                if(contSemicolon == 15){
                    start = i + 1;
                    end = csv.length();
                    return(Integer.parseInt(csv.substring(start, end)));
                }
            }
            i++;
        }
        return(0);
    }
    
    public UsuarioComum getUsuarioComum(String id){
        String auxLinha;
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            if(getID(auxLinha).equals(id)){
                                return(toUsuarioComum(id));
                            }
                            //listaUsuarios.add(new UsuarioComum(senha, pessoa, contato, profissao));
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return(null);
    }
    
    public UsuarioComum getUsuarioComum(String nome, String senha){
        String auxLinha, bd_nome, bd_senha;
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            bd_nome = this.getNome(auxLinha);
                            bd_senha = this.getSenha(auxLinha);
                            
                            if(bd_nome.equals(nome) && bd_senha.equals(senha))
                                return(toUsuarioComum(auxLinha));
                            
                            //listaUsuarios.add(new UsuarioComum(senha, pessoa, contato, profissao));
                        }
                    }
                }
            } while(auxLinha != null);
            
            return(null);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    public UsuarioAdmin getUsuarioAdmin(String nome, String senha){
        String auxLinha, bd_nome, bd_senha;
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            bd_nome = this.getNome(auxLinha);
                            bd_senha = this.getSenha(auxLinha);
                            
                            if(bd_nome.equals(nome) && bd_senha.equals(senha))
                                return(toUsuarioAdmin(auxLinha));
                        }
                    }
                }
            } while(auxLinha != null);
            
            return(null);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    private ArrayList getUsuariosPreExlcusao(String idExcluido){
        String auxLinha;
        ArrayList listaUsuarios = new ArrayList();
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            if(!(idExcluido.equals(getID(auxLinha)))){
                                listaUsuarios.add(auxLinha);
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            
            return(listaUsuarios);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    private ArrayList getUsuariosPreAlteracao(String idAlterado, String csvUsuarioAtualizado){
        String auxLinha;
        int j;
        ArrayList listaUsuarios = new ArrayList();
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            if(!(idAlterado.equals(getID(auxLinha)))){
                                listaUsuarios.add(auxLinha);
                            }else{
                                listaUsuarios.add(csvUsuarioAtualizado);
                            }
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            
            return(listaUsuarios);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
    
    public ArrayList getUsuariosIDs(){
        String auxLinha = "";
        int j;
        ArrayList listaIDs = new ArrayList();
        
        try{
            this.file = new File("db_users.txt");
            this.fileInputStream = new FileInputStream(file);
            this.inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            this.bufferedReader = new BufferedReader(inputStreamReader);
            
            do{
                auxLinha = bufferedReader.readLine();
                
                if(auxLinha != null){
                    if(!(auxLinha.equals("ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento"))){
                        if(!(auxLinha.equals(""))){
                            j = 0;
                            while(auxLinha.charAt(j) != ';'){
                                j++;
                            }
                            
                            listaIDs.add(Integer.parseInt(auxLinha.substring(0, j)));
                        }
                    }
                }
            } while(auxLinha != null);
            
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            
            return(listaIDs);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return(null);
        }
    }
}
