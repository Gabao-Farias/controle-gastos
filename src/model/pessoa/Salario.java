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
public class Salario {
    private double valorLiquido;
    private double valorBruto;
    private int dataRecebimento;

    public Salario(double valorLiquido, int diaRecebimento) {
        this.valorLiquido = valorLiquido;
        this.dataRecebimento = diaRecebimento;
    }

    public Salario(double valorLiquido, double valorBruto, int diaRecebimento) {
        this.valorLiquido = valorLiquido;
        this.valorBruto = valorBruto;
        this.dataRecebimento = diaRecebimento;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public int getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(int dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }
}
