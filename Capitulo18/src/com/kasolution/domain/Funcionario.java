/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasolution.domain;

import java.text.NumberFormat;

/**
 *
 * @author igort
 */
public class Funcionario implements Comparable<Funcionario> {

    private final int codigo;
    private final String nome;
    private final double salario;
    
    @Override
    public int compareTo(Funcionario t) {
        Integer i1 = this.getCodigo();
        Integer i2 = t.getCodigo();
        return i1.compareTo(i2);
    }

    public static class Builder {

        private int codigo;
        private String nome = "";
        private double salario = 0.0;

        public Funcionario.Builder codigo(int codigo) {
            this.codigo = codigo;
            return this;
        }
        
        public Funcionario.Builder nome(String nome) {
            this.nome = nome;
            return this;
        }
                
        public Funcionario.Builder salario(double salario) {
            this.salario = salario;
            return this;
        }
        
        public Funcionario build() {
            return new Funcionario(this);
        }
    }
    
    private Funcionario(Funcionario.Builder builder) {
        this.codigo = builder.codigo;
        this.nome = builder.nome;
        this.salario = builder.salario;
    }

    @Override
    public String toString() {
        return "Funcionario {" + "Código: " + codigo + ", Nome: " + nome + ", Salário: "
                + NumberFormat.getCurrencyInstance().format(salario) + '}';
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public static void print(Funcionario f) {
        System.out.println(f.toString());
    }    
   
}
