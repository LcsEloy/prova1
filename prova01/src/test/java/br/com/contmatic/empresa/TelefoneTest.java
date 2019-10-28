package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.empresa.Telefone;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelefoneTest {
    
    private Telefone telefoneTest;
    
    @BeforeClass
    public static void inicioTestes() {
        System.out.println("Iniciando teste...");
    }
    
    @Before
    public void antes() {
        Integer ddd = 11;
        Integer numero = 981549141;
        String tipo = "Residencial";
        telefoneTest = new Telefone(ddd, numero, tipo);
    }
    
    @After
    public void depois() {
        telefoneTest = null;
    }
    
    @AfterClass
    public static void fimTestes() {
        System.out.println("Teste concluído.");
    }
    
    @Test
    public void deve_apresentar_os_dados_do_telefone_no_console() {
        System.out.println(telefoneTest);
    }
    
    @Test
    public void deve_apresentar_os_dados_do_telefone_com_alteracoes() {
        telefoneTest.setDdd(21);
        System.out.println(telefoneTest);
    }

    @Test
    public void deve_apontar_igualdade_de_objetos_utilizando_hashcode() {
        Integer ddd = telefoneTest.getDdd();
        Integer numero = telefoneTest.getNumero();
        String tipo = telefoneTest.getTipo();        
        Telefone telefoneTest2 = new Telefone(ddd, numero, tipo);
        assertEquals(telefoneTest.hashCode(), telefoneTest2.hashCode());
    }

    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_hashcode() {
        Integer ddd = telefoneTest.getDdd();
        Integer numero = 25647891;
        String tipo = telefoneTest.getTipo();
        Telefone telefoneTest2 = new Telefone(ddd, numero, tipo);
        assertNotEquals(telefoneTest.hashCode(), telefoneTest2.hashCode());
    }

    @Test
    public void deve_apontar_igualdade_de_objetos_utilizando_equals() {
        Integer ddd = telefoneTest.getDdd();
        Integer numero = telefoneTest.getNumero();
        String tipo = telefoneTest.getTipo();        
        Telefone telefoneTest2 = new Telefone(ddd, numero, tipo);
        assertTrue(telefoneTest.equals(telefoneTest2));
    }

    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_equals_ddd() {
        Integer ddd = 21;
        Integer numero = telefoneTest.getNumero();
        String tipo = telefoneTest.getTipo();      
        Telefone telefoneTest2 = new Telefone(ddd, numero, tipo);
        assertFalse(telefoneTest.equals(telefoneTest2));
    }
    
    @Test
    public void nao_deve_apontar_igualdade_de_objetos_utilizando_equals_numero() {
        Integer ddd = telefoneTest.getDdd();
        Integer numero = 598456698;
        String tipo = telefoneTest.getTipo();      
        Telefone telefoneTest2 = new Telefone(ddd, numero, tipo);
        assertFalse(telefoneTest.equals(telefoneTest2));
    }    
        
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ddd_nulo() {
        telefoneTest.setDdd(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ddd_com_3_digitos() {
        telefoneTest.setDdd(121);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_ddd_com_1_digito() {
        telefoneTest.setDdd(1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deve_indicar_ddd_invalido() {
        telefoneTest.setDdd(20);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_nulo() {
        telefoneTest.setNumero(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_com_menos_de_8_digitos() {
        telefoneTest.setNumero(190);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_numero_com_mais_de_9_digitos() {
        telefoneTest.setNumero(1000000000);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_tipo_nulo() {
        telefoneTest.setTipo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_tipo_em_branco() {
        telefoneTest.setTipo("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nao_deve_aceitar_tipo_vazio() {
        telefoneTest.setTipo(" ");
    }

}
