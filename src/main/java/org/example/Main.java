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
            while (idade < 0 || idade > 120) {
                System.out.println("Idade inválida! Digite um valor entre 0 e 120.");
                System.out.print("Idade: ");
                idade = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Email: ");
            String email = scanner.nextLine();

            usuarios.add(new Usuario(nome, idade, email));

            System.out.print("Deseja adicionar outro usuário? (s/n): ");
            opcao = scanner.nextLine();
        } while (opcao.equalsIgnoreCase("s"));

        usuarioService.salvarUsuarios(usuarios);
    }
}
