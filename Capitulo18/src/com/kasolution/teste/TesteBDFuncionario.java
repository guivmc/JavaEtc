/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasolution.teste;

import com.kasolution.domain.ControleFuncionario;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 130955800299
 */
public class TesteBDFuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        char prompt = '\u0000';
        do {
            System.out.println("\n[=========== SISTEMA DE CONTROLE DE FUNCIOANRIOS ===========]\n"); 
            System.out.println("[C]cadastrar - [A]alterar - [E]excluir - [B]buscar - [S]sair");
            System.out.print("Escolha uma das opções do menu: ");
            prompt = sc.next().charAt(0);
            
            switch (prompt) {
                case 'C':
                case 'c': ControleFuncionario.cadastrar(); break;
                case 'A':
                case 'a': ControleFuncionario.atualizar(); break;
                case 'E':
                case 'e': ControleFuncionario.excluir(); break;
                case 'B':
                case 'b': ControleFuncionario.buscar(); break;
                case 'S':
                case 's': System.out.println("\nAté breve!\n\n");break;
                default : System.out.println("[-OPÇÃO INVÁLIDA!-]");
            }
        } while (prompt != 'S' && prompt != 's');
    }

}
