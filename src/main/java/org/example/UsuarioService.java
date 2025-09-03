package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UsuarioService {

    private static final String ARQUIVO = "usuarios.html";

    public void salvarUsuarios(List<Usuario> usuarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(ARQUIVO)) {
            gson.toJson(usuarios, writer);
            System.out.println("Usuários salvos em " + ARQUIVO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
