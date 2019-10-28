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
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.empresa.Empresa;

public class EmpresaTest {

    private Empresa empTest;

    @BeforeClass
    public static void inicioTestes() {
        System.out.println("Iniciando teste...");
    }

    @Before
    public void antes() {
        String cnpj = "61902722000126";
        String razaoSocial = "Sport Clube Corinthians Paulista";
        String nomeFantasia = "Corinthians";
        String areaAtuacao = "Futebol";
        Telefone telefone = new Telefone(11, 20953000, "Comercial");
        String numeroFuncionarios = "45";
        empTest = new Empresa(cnpj, razaoSocial, nomeFantasia, areaAtuacao, telefone, numeroFuncionarios);
    }

    @After
    public void depois() {
        empTest = null;
    }

    @AfterClass
    public static void fimTestes() {
        System.out.println("Teste concluído.");
    }

    @Test
    public void deve_apresentar_os_dados_da_empresa_no_console() {
        System.out.println(empTest);
    }

    @Test
    public void deve_apresentar_os_dados_da_empresa_com_alteracoes() {
        empTest.setRazaoSocial("Sem nome");
        System.out.println(empTest);
    }

    @Ignore
    @Test
    public void deve_ignorar_este_teste() {
        System.out.println("Isso não deve ser impresso!");
    }

    @Test(timeout = 100)
    public void nao_deve_exceder_o_tempo_proposto() {
        String cnpj = "61902722000126";
        String razaoSocial = "Sport Clube Corinthians Paulista";
        String nomeFantasia = "Corinthians";
        String areaAtuacao = "Futebol";
        Telefone telefone = new Telefone(11, 20953000, "Comercial");
        String numeroFuncionarios = "45";
        empTest = new Empresa(cnpj, razaoSocial, nomeFantasia, areaAtuacao, telefone, numeroFuncionarios);
    }

    @Test
    public void deve_apontar_igualdade_de_objetos_utilizando_hashcode() {
        String cnpj = empTest.getCnpj();
        String razaoSocial = empTest.getRazaoSocial();
        String nomeFantasia = empTest.getNomeFantasia();
        String areaAtuacao = empTest.getAreaAtuacao();
        Telefone telefone = new Telefone(11, 20953000, "Comercial");
        String numeroFuncionarios = empTest.getNumeroFuncionarios();
        Empresa empTest2 = new Empresa(cnpj, razaoSocial, nomeFantasia, areaAtuacao, telefone, numeroFuncionarios);
        assertEquals(empTest.hashCode(), empTest2.hashCode());
    }

    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_hashcode() {
        String cnpj = "11862405000155";
        String razaoSocial = empTest.getRazaoSocial();
        String nomeFantasia = empTest.getNomeFantasia();
        String areaAtuacao = empTest.getAreaAtuacao();
        Telefone telefone = new Telefone(11, 20953000, "Comercial");
        String numeroFuncionarios = empTest.getNumeroFuncionarios();
        Empresa empTest2 = new Empresa(cnpj, razaoSocial, nomeFantasia, areaAtuacao, telefone, numeroFuncionarios);
        assertNotEquals(empTest.hashCode(), empTest2.hashCode());
    }

    @Test
    public void deve_apontar_igualdade_de_objetos_utilizando_equals() {
        String cnpj = empTest.getCnpj();
        String razaoSocial = empTest.getRazaoSocial();
        String nomeFantasia = empTest.getNomeFantasia();
        String areaAtuacao = empTest.getAreaAtuacao();
        Telefone telefone = new Telefone(11, 20953000, "Comercial");
        String numeroFuncionarios = empTest.getNumeroFuncionarios();
        Empresa empTest2 = new Empresa(cnpj, razaoSocial, nomeFantasia, areaAtuacao, telefone, numeroFuncionarios);
        assertTrue(empTest.equals(empTest2));
    }

    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_equals() {
        String cnpj = "76514162000100";
        String razaoSocial = empTest.getRazaoSocial();
        String nomeFantasia = empTest.getNomeFantasia();
        String areaAtuacao = empTest.getAreaAtuacao();
        Telefone telefone = new Telefone(11, 20953000, "Comercial");
        String numeroFuncionarios = empTest.getNumeroFuncionarios();
        Empresa empTest2 = new Empresa(cnpj, razaoSocial, nomeFantasia, areaAtuacao, telefone, numeroFuncionarios);
        assertFalse(empTest.equals(empTest2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_nulo() {
        empTest.setCnpj(null);
        assertNotNull("should not be null", empTest.getCnpj());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_vazio() {
        empTest.setCnpj("");
        assertNotNull("should not be empty", empTest.getCnpj());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_em_branco() {
        empTest.setCnpj(" ");
        assertNotNull("should not be blank", empTest.getCnpj());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numero_e_letras() {
        empTest.setCnpj("6190272200012R");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_apenas_com_letras() {
        empTest.setCnpj("aaaaaaaaaaaaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_zero() {
        empTest.setCnpj("00000000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_um() {
        empTest.setCnpj("11111111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_dois() {
        empTest.setCnpj("22222222222222");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_tres() {
        empTest.setCnpj("33333333333333");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_quatro() {
        empTest.setCnpj("44444444444444");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_cinco() {
        empTest.setCnpj("55555555555555");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_seis() {
        empTest.setCnpj("66666666666666");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_sete() {
        empTest.setCnpj("77777777777777");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_oito() {
        empTest.setCnpj("88888888888888");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_numeros_iguais_nove() {
        empTest.setCnpj("99999999999999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_menos_de_14_digitos() {
        empTest.setCnpj("12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_cnpj_com_mais_de_14_digitos() {
        empTest.setCnpj("123456789101213");
    }

    @Test
    public void deve_apontar_cnpj_valido() {
        empTest.setCnpj("61902722000126");
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_apontar_cnpj_invalido() {
        empTest.setCnpj("61902722000127");
    }

    @Test
    public void deve_apontar_igualdade_cnpj() {
        assertEquals(empTest.getCnpj(), empTest.getCnpj());
    }

    @Test
    public void nao_deve_apontar_igualdade_cnpj() {
        assertThat(empTest.getCnpj(), is(not("61750345000157")));
    }

    @Test
    public void deve_aceitar_razao_social_valida() {
        empTest.setRazaoSocial("Sport Clube Corinthians Paulista");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razaoSocial_nula() {
        empTest.setRazaoSocial(null);
        assertNotNull("should not be null", empTest.getRazaoSocial());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razaoSocial_vazio() {
        empTest.setRazaoSocial("");
        assertNotNull("should not be empty", empTest.getRazaoSocial());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_razaoSocial_em_branco() {
        empTest.setRazaoSocial(" ");
        assertNotNull("should not be blank", empTest.getRazaoSocial());
    }

    @Test
    public void deve_apontar_igualdade_razaoSocial() {
        assertEquals("Sport Clube Corinthians Paulista", empTest.getRazaoSocial());
    }

    @Test
    public void nao_deve_apontar_igualdade_razaoSocial() {
        assertThat(empTest.getRazaoSocial(), is(not("Sociedade Esportiva Palmeiras")));
    }

    @Test
    public void deve_aceitar_nome_fantasia_valido() {
        empTest.setNomeFantasia("Corinthians");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nomeFantasia_nulo() {
        empTest.setNomeFantasia(null);
        assertNotNull("should not be null", empTest.getNomeFantasia());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nomeFantasia_vazio() {
        empTest.setNomeFantasia("");
        assertNotNull("should not be empty", empTest.getRazaoSocial());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_nomeFantasia_invalido() {
        empTest.setNomeFantasia(" ");
        assertNotNull("should not be blank", empTest.getNomeFantasia());
    }

    @Test
    public void deve_apontar_igualdade_nomeFantasia() {
        assertEquals("Corinthians", empTest.getNomeFantasia());
    }

    @Test
    public void nao_deve_apontar_igualdade_nomeFantasia() {
        assertThat(empTest.getNomeFantasia(), is(not("Palmeiras")));
    }

    @Test
    public void deve_aceitar_area_atuacao_valido() {
        empTest.setAreaAtuacao("Futebol");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_areaAtuacao_nula() {
        empTest.setAreaAtuacao(null);
        assertNotNull("should not be null", empTest.getAreaAtuacao());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_areaAtuacao_vazio() {
        empTest.setAreaAtuacao("");
        assertNotNull("should not be empty", empTest.getAreaAtuacao());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_areaAtuacao_invalido() {
        empTest.setAreaAtuacao(" ");
        assertNotNull("should not be blank", empTest.getAreaAtuacao());
    }

    @Test
    public void deve_apontar_igualdade_areaAtuacao() {
        assertEquals("Futebol", empTest.getAreaAtuacao());
    }

    @Test
    public void nao_deve_apontar_igualdade_areaAtuacao() {
        assertThat(empTest.getAreaAtuacao(), is(not("Aviação")));
    }

    @Test
    public void deve_aceitar_numeroFuncionarios_valido() {
        empTest.setNumeroFuncionarios("45");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numumeroFuncionarios_nulo() {
        empTest.setNumeroFuncionarios(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numumeroFuncionarios_vazio() {
        empTest.setNumeroFuncionarios("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numumeroFuncionarios_em_branco() {
        empTest.setNumeroFuncionarios(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numeroFuncionarios_com_letras() {
        empTest.setNumeroFuncionarios("XXXXXX");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numeroFuncionarios_com_mais_digitos_que_o_permitido() {
        empTest.setNumeroFuncionarios("1234567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numeroFuncionarios_abaixo_do_permitido() {
        empTest.setNumeroFuncionarios("0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numeroFuncionarios_com_numeros_invalidos() {
        empTest.setNumeroFuncionarios("00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numeroFuncionarios_com_numeros_invalidos2() {
        empTest.setNumeroFuncionarios("000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numeroFuncionarios_com_numeros_invalidos3() {
        empTest.setNumeroFuncionarios("0000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numeroFuncionarios_com_numeros_invalidos4() {
        empTest.setNumeroFuncionarios("00000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numeroFuncionarios_com_numeros_invalidos5() {
        empTest.setNumeroFuncionarios("000000");
    }

    @Test
    public void deve_apontar_igualdade_numeroFuncionarios() {
        assertEquals("45", empTest.getNumeroFuncionarios());
    }

    @Test
    public void nao_deve_apontar_igualdade_numFuncionarios() {
        assertThat(empTest.getNumeroFuncionarios(), is(not("54")));
    }

}
