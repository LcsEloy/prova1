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
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.empresa.Telefone;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioTest {
    
    private Funcionario funcionarioTest;
    
    @BeforeClass
    public static void inicioTestes() {
        System.out.println("Iniciando teste...");
    }

    @Before
    public void antes() {
        String nome = "Lucas";
        String sobrenome = "Eloy";
        String cargo = "Estagiário";
        Double salario = 2000.00;
        String email = "lucas.silva@contmatic.com.br";
        String cpf = "41779801882";
        Telefone telefone = new Telefone(11, 981549141, "Celular");
        funcionarioTest = new Funcionario(nome, sobrenome, email, cpf, telefone, cargo, salario);
    }

    @After
    public void depois() {
        funcionarioTest = null;
    }

    @AfterClass
    public static void fimTestes() {
        System.out.println("Teste concluído.");
    }

    @Test
    public void deve_apresentar_os_dados_do_funcionario_no_console() {
        System.out.println(funcionarioTest);
    }

    @Test
    public void deve_apresentar_os_dados_do_funcionario_com_alteracoes() {
        funcionarioTest.setNome("Sem nome");
        System.out.println(funcionarioTest);
    }

    @Test
    public void deve_apontar_igualdade_de_objetos_utilizando_hashcode() {
        String nome = funcionarioTest.getNome();
        String sobrenome = funcionarioTest.getSobrenome();
        String cargo = funcionarioTest.getCargo();
        Double salario = funcionarioTest.getSalario();
        String email = funcionarioTest.getEmail();
        String cpf = funcionarioTest.getCpf();
        Telefone telefone = new Telefone(11, 29871764, "casa");
        Funcionario funcionarioTest2 = new Funcionario(nome, sobrenome, email, cpf, telefone, cargo, salario);
        assertEquals(funcionarioTest.hashCode(), funcionarioTest2.hashCode());
    }

    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_hashcode() {
        String nome = funcionarioTest.getNome();
        String sobrenome = funcionarioTest.getSobrenome();
        String cargo = funcionarioTest.getCargo();
        Double salario = funcionarioTest.getSalario();
        String email = funcionarioTest.getEmail();
        String cpf = "86753910050";
        Telefone telefone = new Telefone(11, 29871764, "casa");
        Funcionario funcionarioTest2 = new Funcionario(nome, sobrenome, email, cpf, telefone, cargo, salario);
        assertNotEquals(funcionarioTest.hashCode(), funcionarioTest2.hashCode());
    }

    @Test
    public void deve_apontar_igualdade_de_objetos_utilizando_equals() {
        String nome = funcionarioTest.getNome();
        String sobrenome = funcionarioTest.getSobrenome();
        String cargo = funcionarioTest.getCargo();
        Double salario = funcionarioTest.getSalario();
        String email = funcionarioTest.getEmail();
        String cpf = funcionarioTest.getCpf();
        Telefone telefone = new Telefone(11, 29871764, "casa");
        Funcionario funcionarioTest2 = new Funcionario(nome, sobrenome, email, cpf, telefone, cargo, salario);
        assertTrue(funcionarioTest.equals(funcionarioTest2));
    }

    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_equals() {
        String nome = funcionarioTest.getNome();
        String sobrenome = funcionarioTest.getSobrenome();
        String cargo = funcionarioTest.getCargo();
        Double salario = funcionarioTest.getSalario();
        String email = funcionarioTest.getEmail();
        String cpf = "86753910050";
        Telefone telefone = new Telefone(11, 29871764, "casa");
        Funcionario funcionarioTest2 = new Funcionario(nome, sobrenome, email, cpf, telefone, cargo, salario);
        assertFalse(funcionarioTest.equals(funcionarioTest2));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_nulo() {
        funcionarioTest.setNome(null);
        assertNotNull("should not be null", funcionarioTest.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_vazio() {
        funcionarioTest.setNome("");
        assertNotNull("should not be empty", funcionarioTest.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_em_branco() {
        funcionarioTest.setNome(" ");
        assertNotNull("should not be blank", funcionarioTest.getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_numero_e_letras() {
        funcionarioTest.setNome("Luc4s");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_apenas_com_numeros() {
        funcionarioTest.setNome("456465");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_com_apenas_uma_leta() {
        funcionarioTest.setNome("llllll");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nome_maior_que_15_caracteres() {
        funcionarioTest.setNome("Lucas Oliveira Eloy");
    }

    @Test
    public void deve_aceitar_nome_valido() {
        funcionarioTest.setNome("Grace");
        assertTrue(true);
    }

    @Test
    public void deve_apontar_igualdade_nome() {
        assertEquals(funcionarioTest.getNome(), funcionarioTest.getNome());
    }

    @Test
    public void nao_deve_apontar_igualdade_nome() {
        assertThat(funcionarioTest.getNome(), is(not("Grace")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_nulo() {
        funcionarioTest.setSobrenome(null);
        assertNotNull("should not be null", funcionarioTest.getSobrenome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_vazio() {
        funcionarioTest.setSobrenome("");
        assertNotNull("should not be empty", funcionarioTest.getSobrenome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_em_branco() {
        funcionarioTest.setSobrenome(" ");
        assertNotNull("should not be blank", funcionarioTest.getSobrenome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_com_numero_e_letras() {
        funcionarioTest.setSobrenome("El0y");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_apenas_com_numeros() {
        funcionarioTest.setSobrenome("456465");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_com_apenas_uma_leta() {
        funcionarioTest.setSobrenome("llllll");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_sobrenome_maior_que_30_caracteres() {
        funcionarioTest.setSobrenome("Oliveira Eloy da Silva Sousa Castro Alves Barbosa");
    }

    @Test
    public void deve_apontar_igualdade_sobrenome() {
        assertEquals("Eloy", funcionarioTest.getSobrenome());
    }

    @Test
    public void nao_deve_apontar_igualdade_sobrenome() {
        assertThat(funcionarioTest.getSobrenome(), is(not("Sousa")));
    }

    @Test
    public void deve_aceitar_email_valido() {
        funcionarioTest.setEmail("lucas.silva@contmatic.com.br");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_invalido() {
        funcionarioTest.setEmail("luc@s@contmatic.com.br");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_nulo() {
        funcionarioTest.setEmail(null);
        assertNotNull("should not be null", funcionarioTest.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_vazio() {
        funcionarioTest.setEmail("");
        assertNotNull("should not be empty", funcionarioTest.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_email_em_branco() {
        funcionarioTest.setEmail(" ");
        assertNotNull("should not be blank", funcionarioTest.getEmail());
    }

    @Test
    public void deve_apontar_igualdade_email() {
        assertEquals("lucas.silva@contmatic.com.br", funcionarioTest.getEmail());
    }

    @Test
    public void nao_deve_apontar_igualdade_email() {
        assertThat(funcionarioTest.getEmail(), is(not("lucaseloy70@hotmail.com")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_nulo() {
        funcionarioTest.setCpf(null);
        assertNotNull("should not be null", funcionarioTest.getCpf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_vazio() {
        funcionarioTest.setCpf("");
        assertNotNull("should not be empty", funcionarioTest.getCpf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_em_branco() {
        funcionarioTest.setCpf(" ");
        assertNotNull("should not be blank", funcionarioTest.getCpf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numero_e_letras() {
        funcionarioTest.setCpf("4177980188r");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_apenas_com_letras() {
        funcionarioTest.setCpf("aaaaaaaaaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_zero() {
        funcionarioTest.setCpf("00000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_um() {
        funcionarioTest.setCpf("11111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_dois() {
        funcionarioTest.setCpf("22222222222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_tres() {
        funcionarioTest.setCpf("33333333333");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_quatro() {
        funcionarioTest.setCpf("44444444444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_cinco() {
        funcionarioTest.setCpf("55555555555");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_seis() {
        funcionarioTest.setCpf("66666666666");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_sete() {
        funcionarioTest.setCpf("77777777777");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_oito() {
        funcionarioTest.setCpf("88888888888");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_numeros_iguais_nove() {
        funcionarioTest.setCpf("99999999999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_menos_de_11_digitos() {
        funcionarioTest.setCpf("12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cpf_com_mais_de_11_digitos() {
        funcionarioTest.setCpf("123456789101");
    }

    @Test
    public void deve_apontar_cpf_valido() {
        funcionarioTest.setCpf("41779801882");
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_apontar_cpf_invalido() {
        funcionarioTest.setCpf("49739801582");
    }

    @Test
    public void deve_apontar_igualdade_cpf() {
        assertEquals(funcionarioTest.getCpf(), funcionarioTest.getCpf());
    }

    @Test
    public void nao_deve_apontar_igualdade_cpf() {
        assertThat(funcionarioTest.getCpf(), is(not("45896542355")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cargo_nulo() {
        funcionarioTest.setCargo(null);
        assertNotNull("should not be null", funcionarioTest.getCargo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cargo_vazio() {
        funcionarioTest.setCargo("");
        assertNotNull("should not be empty", funcionarioTest.getCargo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cargo_em_branco() {
        funcionarioTest.setCargo(" ");
        assertNotNull("should not be blank", funcionarioTest.getCargo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cargo_com_numero_e_letras() {
        funcionarioTest.setCargo("Es7ag14ri0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cargo_apenas_com_numeros() {
        funcionarioTest.setCargo("45");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cargo_com_apenas_uma_leta() {
        funcionarioTest.setCargo("sssss");
    }

    @Test
    public void deve_aceitar_cargo_valido() {
        funcionarioTest.setCargo("Desenvolvedor");
        assertTrue(true);
    }
    
    @Test
    public void deve_aceitar_salario_valido() {
        funcionarioTest.setSalario(5000.00);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_salario_nulo() {
        funcionarioTest.setSalario(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_salario_invalido() {
        funcionarioTest.setSalario(0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_salario_menor_ou_igual_zero() {
        funcionarioTest.setSalario(-1.0);
    }

}
