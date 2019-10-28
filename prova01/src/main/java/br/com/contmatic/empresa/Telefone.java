package br.com.contmatic.empresa;

public class Telefone {

    private static final int MAIOR_NUMERO_DDD = 99;

    private static final int MENOR_NUMERO_DDD = 11;

    private Integer ddd;

    private Integer numero;

    private String tipo;

    public Telefone(Integer ddd, Integer numero, String tipo) {
        this.ddd = setDdd(ddd);
        this.numero = setNumero(numero);
        this.tipo = setTipo(tipo);
    }

    public Integer getDdd() {
        return ddd;
    }

    public Integer setDdd(Integer ddd) {
        verificaDddNulo(ddd);
        verificaDddValido(ddd);
        verificaDddInvalido(ddd);
        return this.ddd = ddd;
    }

    private void verificaDddInvalido(Integer ddd) {
        Integer dddInvalido[] = { 20, 23, 25, 26, 29, 30, 36, 39, 40, 50, 52, 56, 57, 58, 59, 60, 70, 72, 76, 78, 80, 90 };
        
        int i;
        for(i = 0 ; i < 21 ; i++) {
            if (ddd == dddInvalido[i]) {
                throw new IllegalArgumentException("DDD Inválido.");
            }

        }
    }

    private void verificaDddValido(Integer ddd) {
        if (!(ddd >= MENOR_NUMERO_DDD && ddd <= MAIOR_NUMERO_DDD)) {
            throw new IllegalArgumentException("O DDD deve ser entre os números 11 e 99");
        }
    }

    private void verificaDddNulo(Integer ddd) {
        if (ddd == null) {
            throw new IllegalArgumentException("O DDD não deve ser nulo.");
        }
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer setNumero(Integer numero) {
        verificaNumeroNulo(numero);
        verificaTamanhoCorretoNumero(numero);
        return this.numero = numero;
    }

    private void verificaTamanhoCorretoNumero(Integer numero) {
        if (numero < 10000000 || numero > 999999999) {
            throw new IllegalArgumentException("O número deve conter entre 8 e 9 números.");
        }
    }

    private void verificaNumeroNulo(Integer numero) {
        if (numero == null) {
            throw new IllegalArgumentException("O número não deve ser nulo.");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public String setTipo(String tipo) {
        verificaTipoNuloOuEmBranco(tipo);
        return this.tipo = tipo;
    }

    private void verificaTipoNuloOuEmBranco(String tipo) {
        if (tipo == null || tipo.isEmpty() || tipo.equals(" ")) {
            throw new IllegalArgumentException("O Tipo não deve ser nulo ou vazio.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Telefone other = (Telefone) obj;
        if (!ddd.equals(other.ddd)) {
            return false;
        }
        if (!numero.equals(other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ddd.hashCode();
        result = prime * result + numero.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + ddd + ") " + numero + " / Tipo: " + tipo;
    }

}
