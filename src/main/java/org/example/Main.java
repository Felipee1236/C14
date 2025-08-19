package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        UsuarioService usuarioService = new UsuarioService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Usuários ===");

        String opcao;
        do {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            usuarios.add(new Usuario(nome, idade));

            System.out.print("Deseja adicionar outro usuário? (s/n): ");
            opcao = scanner.nextLine();
        } while (opcao.equalsIgnoreCase("s"));

        usuarioService.salvarUsuarios(usuarios);
    }
}
