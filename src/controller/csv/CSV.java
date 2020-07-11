/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.csv;

/**
 *
 * @author Gabriel
 */
public class CSV {
    private String cabecalhoRegistros;
    private String caebecalhoUsuarios;

    public CSV() {
        this.cabecalhoRegistros = "ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação";
        this.caebecalhoUsuarios = "ID;Senha;Nome;Sexo;DataNasc;Telefone Celular; Telefone Fixo;Email;Email Alternativo;Site;Profissão;Jornada de Trabalho;Turno;Valor Líquido;Valor Bruto;Data Recebimento";
    }

    public String getCabecalhoRegistros() {
        return cabecalhoRegistros;
    }

    public void setCabecalhoRegistros(String cabecalhoRegistros) {
        this.cabecalhoRegistros = cabecalhoRegistros;
    }

    public String getCaebecalhoUsuarios() {
        return caebecalhoUsuarios;
    }

    public void setCaebecalhoUsuarios(String caebecalhoUsuarios) {
        this.caebecalhoUsuarios = caebecalhoUsuarios;
    }
}
