package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UsuarioServiceTest {

    // CASOS POSITIVOS

    @Test
    void testSalvarListaVazia() throws IOException {
        UsuarioService service = new UsuarioService();
        List<Usuario> listaVazia = new ArrayList<>();

        service.salvarUsuarios(listaVazia);

        File arquivo = new File("usuarios.json");
        assertTrue(arquivo.exists());

        String conteudo = Files.readString(arquivo.toPath());
        assertEquals("[]", conteudo);

        arquivo.delete();
    }

    @Test
    void testSalvarUmUsuario() throws IOException {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario("João Silva", 25, "joao@email.com");
        List<Usuario> lista = Arrays.asList(usuario);

        service.salvarUsuarios(lista);

        File arquivo = new File("usuarios.json");
        assertTrue(arquivo.exists());

        String conteudo = Files.readString(arquivo.toPath());
        assertTrue(conteudo.contains("João Silva"));
        assertTrue(conteudo.contains("joao@email.com"));
        assertTrue(conteudo.contains("25"));

        arquivo.delete();
    }

    @Test
    void testSalvarMultiplosUsuarios() throws IOException {
        UsuarioService service = new UsuarioService();
        Usuario usuario1 = new Usuario("João Silva", 25, "joao@email.com");
        Usuario usuario2 = new Usuario("Maria Santos", 30, "maria@email.com");
        Usuario usuario3 = new Usuario("Pedro Costa", 35, "pedro@email.com");
        List<Usuario> lista = Arrays.asList(usuario1, usuario2, usuario3);

        service.salvarUsuarios(lista);

        File arquivo = new File("usuarios.json");
        assertTrue(arquivo.exists());

        String conteudo = Files.readString(arquivo.toPath());
        assertTrue(conteudo.contains("João Silva"));
        assertTrue(conteudo.contains("Maria Santos"));
        assertTrue(conteudo.contains("Pedro Costa"));

        arquivo.delete();
    }

    @Test
    void testCriarArquivo() {
        UsuarioService service = new UsuarioService();
        List<Usuario> lista = Arrays.asList(new Usuario("Teste", 20, "teste@email.com"));
        File arquivo = new File("usuarios.json");

        if (arquivo.exists()) {
            arquivo.delete();
        }

        service.salvarUsuarios(lista);

        assertTrue(arquivo.exists());
        arquivo.delete();
    }

    @Test
    void testJsonValido() throws IOException {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario("Ana Costa", 28, "ana@email.com");
        List<Usuario> lista = Arrays.asList(usuario);

        service.salvarUsuarios(lista);

        File arquivo = new File("usuarios.json");
        String conteudo = Files.readString(arquivo.toPath());

        assertTrue(conteudo.startsWith("["));
        assertTrue(conteudo.endsWith("]"));
        assertTrue(conteudo.contains("{"));
        assertTrue(conteudo.contains("}"));

        arquivo.delete();
    }

    // CASOS NEGATIVOS

    @Test
    void testListaNull() {
        UsuarioService service = new UsuarioService();

        assertDoesNotThrow(() -> {
            service.salvarUsuarios(null);
        });

        File arquivo = new File("usuarios.json");
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }

    @Test
    void testUsuarioComDadosNull() throws IOException {
        UsuarioService service = new UsuarioService();
        Usuario usuarioComDadosNull = new Usuario(null, 0, null);
        List<Usuario> lista = Arrays.asList(usuarioComDadosNull);

        service.salvarUsuarios(lista);

        File arquivo = new File("usuarios.json");
        assertTrue(arquivo.exists());

        String conteudo = Files.readString(arquivo.toPath());
        assertTrue(conteudo.contains("0"));
        assertTrue(conteudo.startsWith("["));
        assertTrue(conteudo.endsWith("]"));

        arquivo.delete();
    }

    @Test
    void testIdadesExtremas() throws IOException {
        UsuarioService service = new UsuarioService();
        Usuario usuarioIdadeNegativa = new Usuario("Teste1", -100, "teste1@email.com");
        Usuario usuarioIdadeMuitoAlta = new Usuario("Teste2", 999, "teste2@email.com");
        List<Usuario> lista = Arrays.asList(usuarioIdadeNegativa, usuarioIdadeMuitoAlta);

        service.salvarUsuarios(lista);

        File arquivo = new File("usuarios.json");
        assertTrue(arquivo.exists());

        String conteudo = Files.readString(arquivo.toPath());
        assertTrue(conteudo.contains("-100"));
        assertTrue(conteudo.contains("999"));

        arquivo.delete();
    }

    @Test
    void testStringsVazias() throws IOException {
        UsuarioService service = new UsuarioService();
        Usuario usuarioComStringsVazias = new Usuario("", 25, "");
        List<Usuario> lista = Arrays.asList(usuarioComStringsVazias);

        service.salvarUsuarios(lista);

        File arquivo = new File("usuarios.json");
        assertTrue(arquivo.exists());

        String conteudo = Files.readString(arquivo.toPath());
        assertTrue(conteudo.contains("25"));

        arquivo.delete();
    }

    @Test
    void testListaComElementosNull() throws IOException {
        UsuarioService service = new UsuarioService();
        List<Usuario> listaComElementosNull = new ArrayList<>();
        listaComElementosNull.add(new Usuario("João", 25, "joao@email.com"));
        listaComElementosNull.add(null);
        listaComElementosNull.add(new Usuario("Maria", 30, "maria@email.com"));

        service.salvarUsuarios(listaComElementosNull);

        File arquivo = new File("usuarios.json");
        assertTrue(arquivo.exists());

        String conteudo = Files.readString(arquivo.toPath());
        assertTrue(conteudo.contains("João"));
        assertTrue(conteudo.contains("Maria"));

        arquivo.delete();
    }
}

