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
public class Profissao {
    private String nome;
    private int horasTrabalhoDia;
    private String turno;
    private Salario salario;

    public Profissao(String nome, Salario salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public Profissao(String nome, int jornadaTrabalho, String turno, Salario salario) {
        this.nome = nome;
        this.horasTrabalhoDia = jornadaTrabalho;
        this.turno = turno;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhoDia() {
        return horasTrabalhoDia;
    }

    public void setHorasTrabalhoDia(int horasTrabalhoDia) {
        this.horasTrabalhoDia = horasTrabalhoDia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }
    
    
}
