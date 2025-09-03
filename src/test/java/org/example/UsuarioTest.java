package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    // CASOS POSITIVOS

    @Test
    void testCriarUsuarioComDadosValidos() {
        Usuario usuario = new Usuario("Maria Santos", 30, "maria@email.com");

        assertNotNull(usuario);
        assertEquals("Maria Santos", usuario.getNome());
        assertEquals(30, usuario.getIdade());
        assertEquals("maria@email.com", usuario.getEmail());
    }

    @Test
    void testGetNome() {
        Usuario usuario = new Usuario("João Silva", 25, "joao@email.com");
        assertEquals("João Silva", usuario.getNome());
    }

    @Test
    void testGetIdade() {
        Usuario usuario = new Usuario("João Silva", 25, "joao@email.com");
        assertEquals(25, usuario.getIdade());
    }

    @Test
    void testGetEmail() {
        Usuario usuario = new Usuario("João Silva", 25, "joao@email.com");
        assertEquals("joao@email.com", usuario.getEmail());
    }

    @Test
    void testSetters() {
        Usuario usuario = new Usuario("João Silva", 25, "joao@email.com");

        usuario.setNome("Pedro Costa");
        usuario.setIdade(35);
        usuario.setEmail("pedro@email.com");

        assertEquals("Pedro Costa", usuario.getNome());
        assertEquals(35, usuario.getIdade());
        assertEquals("pedro@email.com", usuario.getEmail());
    }

    // CASOS NEGATIVOS

    @Test
    void testCriarUsuarioComNomeNull() {
        Usuario usuario = new Usuario(null, 25, "teste@email.com");

        assertNotNull(usuario);
        assertNull(usuario.getNome());
        assertEquals(25, usuario.getIdade());
        assertEquals("teste@email.com", usuario.getEmail());
    }

    @Test
    void testCriarUsuarioComEmailNull() {
        Usuario usuario = new Usuario("Teste", 25, null);

        assertNotNull(usuario);
        assertEquals("Teste", usuario.getNome());
        assertEquals(25, usuario.getIdade());
        assertNull(usuario.getEmail());
    }

    @Test
    void testSetNomeNull() {
        Usuario usuario = new Usuario("João Silva", 25, "joao@email.com");
        usuario.setNome(null);
        assertNull(usuario.getNome());
    }

    @Test
    void testSetEmailNull() {
        Usuario usuario = new Usuario("João Silva", 25, "joao@email.com");
        usuario.setEmail(null);
        assertNull(usuario.getEmail());
    }

    @Test
    void testSetIdadeNegativa() {
        Usuario usuario = new Usuario("João Silva", 25, "joao@email.com");
        usuario.setIdade(-5);
        assertEquals(-5, usuario.getIdade());
    }
}

