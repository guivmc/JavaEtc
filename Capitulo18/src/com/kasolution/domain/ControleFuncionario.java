/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kasolution.domain;

import com.kasolution.dao.DAOException;
import com.kasolution.dao.FuncionarioDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 130955800299
 */
public class ControleFuncionario {

    private static final BufferedReader cs = new BufferedReader(new InputStreamReader(System.in));

    public static void cadastrar() throws IOException {
        //NOME, SEXO, IDADE, CIDADE, ESTADO, SALARIO
        System.out.println("\n[ CADASTRAR FUNCIOANARIO ===================================]");
        System.out.print("Nome: ");
        String nome = cs.readLine();
        System.out.print("Salário: ");
        double salario = Double.parseDouble(cs.readLine());

        //completar com try/catch (with resources) para cadastar funcionário
        Funcionario f = new Funcionario.Builder().nome(nome).salario(salario).build();
        
        try(FuncionarioDAO dao = new FuncionarioDAO())
        {
        	dao.salvar(f);
        }
        catch(DAOException e)
        {
        	System.out.println(e.getMessage());
        }


    }//fim cadastrar

    public static void buscar() throws IOException {
        System.out.println("\n[ BUSCAR ===================================================]");
        System.out.print("[T]todos - [C]codigo ");
        char op = cs.readLine().charAt(0);
        try (FuncionarioDAO dao = new FuncionarioDAO()) {
            if (op == 'T' || op == 't') {
                List<Funcionario> fs = dao.buscarTodos();
                fs.stream().sorted().forEach(System.out::println);
            } else {
                System.out.print("Informe o código do funcionario: ");
                int codigo = Integer.parseInt(cs.readLine());
                Funcionario f = dao.buscarId(codigo);
                if (f != null) {
                    Funcionario.print(f);
                } else {
                    System.out.println("[-Funcionario não localizado!-]");
                }
            }
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
    } //fim buscar

    public static void atualizar() throws IOException {
        System.out.println("\n[ ATUALIZAR ================================================]");
        try (FuncionarioDAO dao = new FuncionarioDAO()) {
            System.out.print("Informe o código do funcionario: ");
            int codigo = Integer.parseInt(cs.readLine());
            Funcionario f = dao.buscarId(codigo);
            if (f != null) {
                String dado;
                Funcionario.print(f);
                System.out.println("Novos dados:");
                System.out.print("Nome [ENTER P/ MANTER]: ");
                dado = cs.readLine();
                String nome = (dado.length() == 0) ? f.getNome() : dado;
                System.out.print("Salário [ENTER P/ MANTER]: ");
                dado = cs.readLine();
                double salario = (dado.length() == 0) ? f.getSalario() : Double.parseDouble(dado);

                f = new Funcionario.Builder()
                        .codigo(f.getCodigo())
                        .nome(nome)
                        .salario(salario)
                        .build();
                dao.atualizar(f);
                System.out.println("[-Funcionario cadastrado com sucesso!-]");

            } else {
                System.out.println("[-Funcionario não localizado!-]");
            }
        } catch (DAOException ex) {
            System.out.println(ex);
        }
    }// fim atualizar

    public static void excluir() throws IOException {
        System.out.println("\n[ EXCLUIR ==================================================]");
        try (FuncionarioDAO dao = new FuncionarioDAO()) {
            System.out.print("Informe o código do funcionario: ");
            int codigo = Integer.parseInt(cs.readLine());
            Funcionario f = dao.buscarId(codigo);
            if (f != null) {
                Funcionario.print(f);
                Scanner sc = new Scanner(System.in);
                System.out.print("Confirma a exclusão do funcionario? [S/N]: ");
                String op = sc.next();
                if (op != null && (op.equals("S") || op.equals("s"))) {
                    dao.excluir(f);
                    System.out.println("[-Funcionario excluido com sucesso!-]");
                }
            } else {
                System.out.println("[-Funcionario não localizado!-]");
            }
        } catch (DAOException ex) {
            System.out.println(ex);
        }

    }
}