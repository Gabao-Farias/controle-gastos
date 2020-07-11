/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.registros;

import controller.BD_Registros;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Registro {
    private String id;
    private String idRegistro;
    private String responsavel;
    private double valor;
    private String descricao;
    private Date dataVencimento;
    private Date dataOperacao;
    private String tipo;
    private String formaOperacao;
    private String condicoesOperacao;

    public Registro(String id, String responsavel, double valor, String descricao, Date dataVencimento, Date dataPagamento, String tipoGasto, String formaPagamento, String condicoesPagamento) {
        this.id = id;
        this.idRegistro = this.defineID();
        this.responsavel = responsavel;
        this.valor = valor;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.dataOperacao = dataPagamento;
        this.tipo = tipoGasto;
        this.formaOperacao = formaPagamento;
        this.condicoesOperacao = condicoesPagamento;
    }
    
    public Registro(String id, String idRegistro, String responsavel, double valor, String descricao, Date dataVencimento, Date dataPagamento, String tipoGasto, String formaPagamento, String condicoesPagamento) {
        this.id = id;
        this.idRegistro = idRegistro;
        this.responsavel = responsavel;
        this.valor = valor;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.dataOperacao = dataPagamento;
        this.tipo = tipoGasto;
        this.formaOperacao = formaPagamento;
        this.condicoesOperacao = condicoesPagamento;
    }
    
    public Registro(){}
    
    private String defineID(){
        boolean flag = false;
        int i = 0;
        int j = 0;
        int newID = 0;
        BD_Registros arq = new BD_Registros();
        ArrayList listaIDs = new ArrayList();
        
        listaIDs = arq.getListaIDRegistros();
        
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getIdRegistro() {
        return idRegistro;
    }
    
    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }
    
    public String getDataVencimentoFormatada(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return(formato.format(this.getDataVencimento()));
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }
    
    public String getDataOperacaoFormatada(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return(formato.format(this.getDataOperacao()));
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormaOperacao() {
        return formaOperacao;
    }

    public void setFormaOperacao(String formaOperacao) {
        this.formaOperacao = formaOperacao;
    }

    public String getCondicoesOperacao() {
        return condicoesOperacao;
    }

    public void setCondicoesOperacao(String condicoesOperacao) {
        this.condicoesOperacao = condicoesOperacao;
    }
    
    public String getRegistroFormatadoCSV(){
        String csv = (
                this.id +
                ";" +
                this.idRegistro +
                ";" +
                this.responsavel +
                ";" +
                this.valor +
                ";" +
                this.descricao +
                ";" +
                this.getDataVencimentoFormatada() +
                ";" +
                this.getDataOperacaoFormatada() +
                ";" +
                this.tipo +
                ";" +
                this.formaOperacao +
                ";" +
                this.condicoesOperacao
                );
        return(csv);
    }
}
