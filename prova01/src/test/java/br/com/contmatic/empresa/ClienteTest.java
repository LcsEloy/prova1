package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Cliente;
import br.com.contmatic.empresa.Telefone;

public class ClienteTest {

    private Cliente clienteTest;

    @BeforeClass
    public static void inicioTestes() {
        System.out.println("Iniciando teste...");
    }

    @Before
    public void antes() {
        String nome = "Lucas";
        String sobrenome = "Eloy";
        String email = "lucas.silva@contmatic.com.br";
        String cpf = "41779801882";
        Telefone telefone = new Telefone(11, 981549141, "Celular");
        clienteTest = new Cliente(nome, sobrenome, email, cpf, telefone);
    }

    @After
    public void depois() {
        clienteTest = null;
    }

    @AfterClass
    public static void fimTestes() {
        System.out.println("Teste concluído.");
    }

    @Test
    public void deve_apresentar_os_dados_do_cliente_no_console() {
        System.out.println(clienteTest);
    }

    @Test
    public void deve_apresentar_os_dados_do_cliente_com_alteracoes() {
        clienteTest.setNome("Sem nome");
        System.out.println(clienteTest);
    }

    @Test
    public void deve_apontar_igualdade_de_objetos_utilizando_hashcode() {
        String nome = clienteTest.getNome();
        String sobrenome = clienteTest.getSobrenome();
        String email = clienteTest.getEmail();
        String cpf = clienteTest.getCpf();
        Telefone telefone = new Telefone(11, 29871764, "casa");
        Cliente clienteTest2 = new Cliente(nome, sobrenome, email, cpf, telefone);
        assertEquals(clienteTest.hashCode(), clienteTest2.hashCode());
    }

    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_hashcode() {
        String nome = clienteTest.getNome();
        String sobrenome = clienteTest.getSobrenome();
        String email = clienteTest.getEmail();
        String cpf = "86753910050";
        Telefone telefone = new Telefone(11, 29871764, "casa");
        Cliente clienteTest2 = new Cliente(nome, sobrenome, email, cpf, telefone);
        assertNotEquals(clienteTest.hashCode(), clienteTest2.hashCode());
    }

    @Test
    public void deve_apontar_igualdade_de_objetos_utilizando_equals() {
        String nome = clienteTest.getNome();
        String sobrenome = clienteTest.getSobrenome();
        String email = clienteTest.getEmail();
        String cpf = clienteTest.getCpf();
        Telefone telefone = new Telefone(11, 29871764, "casa");
        Cliente clienteTest2 = new Cliente(nome, sobrenome, email, cpf, telefone);
        assertTrue(clienteTest.equals(clienteTest2));
    }

    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_equals() {
        String nome = clienteTest.getNome();
        String sobrenome = clienteTest.getSobrenome();        
        String email = clienteTest.getEmail();
        String cpf = "86753910050";
        Telefone telefone = new Telefone(11, 29871764, "casa");
        Cliente clienteTest2 = new Cliente(nome, sobrenome, email, cpf, telefone);
        assertFalse(clienteTest.equals(clienteTest2));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_nulo() {
        clienteTest.setNome(null);
        assertNotNull("should not be null", clienteTest.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_vazio() {
        clienteTest.setNome("");
        assertNotNull("should not be empty", clienteTest.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_em_branco() {
        clienteTest.setNome(" ");
        assertNotNull("should not be blank", clienteTest.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_numero_e_letras() {
        clienteTest.setNome("Luc4s");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_apenas_com_numeros() {
        clienteTest.setNome("456465");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_apenas_uma_leta() {
        clienteTest.setNome("llllll");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_maior_que_15_caracteres() {
        clienteTest.setNome("Lucas Oliveira Eloy");
    }

    @Test
    public void deve_aceitar_nome_valido() {
        clienteTest.setNome("Grace");
        assertTrue(true);
    }

    @Test
    public void deve_apontar_igualdade_nome() {
        assertEquals(clienteTest.getNome(), clienteTest.getNome());
    }

    @Test
    public void nao_deve_apontar_igualdade_nome() {
        assertThat(clienteTest.getNome(), is(not("Grace")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_nulo() {
        clienteTest.setSobrenome(null);
        assertNotNull("should not be null", clienteTest.getSobrenome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_vazio() {
        clienteTest.setSobrenome("");
        assertNotNull("should not be empty", clienteTest.getSobrenome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_em_branco() {
        clienteTest.setSobrenome(" ");
        assertNotNull("should not be blank", clienteTest.getSobrenome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_com_numero_e_letras() {
        clienteTest.setSobrenome("El0y");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_apenas_com_numeros() {
        clienteTest.setSobrenome("456465");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_com_apenas_uma_leta() {
        clienteTest.setSobrenome("llllll");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_maior_que_30_caracteres() {
        clienteTest.setSobrenome("Oliveira Eloy da Silva Sousa Castro Alves Barbosa");
    }

    @Test
    public void deve_apontar_igualdade_sobrenome() {
        assertEquals("Eloy", clienteTest.getSobrenome());
    }

    @Test
    public void nao_deve_apontar_igualdade_sobrenome() {
        assertThat(clienteTest.getSobrenome(), is(not("Sousa")));
    }

    @Test
    public void deve_aceitar_email_valido() {
        clienteTest.setEmail("lucas.silva@contmatic.com.br");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_invalido() {
        clienteTest.setEmail("luc@s@contmatic.com.br");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_nulo() {
        clienteTest.setEmail(null);
        assertNotNull("should not be null", clienteTest.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_vazio() {
        clienteTest.setEmail("");
        assertNotNull("should not be empty", clienteTest.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_em_branco() {
        clienteTest.setEmail(" ");
        assertNotNull("should not be blank", clienteTest.getEmail());
    }

    @Test
    public void deve_apontar_igualdade_email() {
        assertEquals("lucas.silva@contmatic.com.br", clienteTest.getEmail());
    }

    @Test
    public void nao_deve_apontar_igualdade_email() {
        assertThat(clienteTest.getEmail(), is(not("lucaseloy70@hotmail.com")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_nulo() {
        clienteTest.setCpf(null);
        assertNotNull("should not be null", clienteTest.getCpf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_vazio() {
        clienteTest.setCpf("");
        assertNotNull("should not be empty", clienteTest.getCpf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_em_branco() {
        clienteTest.setCpf(" ");
        assertNotNull("should not be blank", clienteTest.getCpf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numero_e_letras() {
        clienteTest.setCpf("4177980188r");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_apenas_com_letras() {
        clienteTest.setCpf("aaaaaaaaaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_zero() {
        clienteTest.setCpf("00000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_um() {
        clienteTest.setCpf("11111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_dois() {
        clienteTest.setCpf("22222222222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_tres() {
        clienteTest.setCpf("33333333333");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_quatro() {
        clienteTest.setCpf("44444444444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_cinco() {
        clienteTest.setCpf("55555555555");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_seis() {
        clienteTest.setCpf("66666666666");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_sete() {
        clienteTest.setCpf("77777777777");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_oito() {
        clienteTest.setCpf("88888888888");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_nove() {
        clienteTest.setCpf("99999999999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_11_digitos() {
        clienteTest.setCpf("12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_mais_de_11_digitos() {
        clienteTest.setCpf("123456789101");
    }

    @Test
    public void deve_apontar_cpf_valido() {
        clienteTest.setCpf("41779801882");
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_apontar_cpf_invalido() {
        clienteTest.setCpf("49739801582");
    }

    @Test
    public void deve_apontar_igualdade_cpf() {
        assertEquals(clienteTest.getCpf(), clienteTest.getCpf());
    }

    @Test
    public void nao_deve_apontar_igualdade_cpf() {
        assertThat(clienteTest.getCpf(), is(not("45896542355")));
    }
    
}