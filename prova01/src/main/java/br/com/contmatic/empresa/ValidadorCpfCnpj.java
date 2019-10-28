package br.com.contmatic.empresa;

public class ValidadorCpfCnpj {

    private static final int TAMANHO_PADRAO_DIGITOS_CPF = 11;

    private static final int TAMANHO_PADRAO_DIGITOS_CNPJ = 14;

    private static final int[] PESO_DE_CADA_DIGITO_PARA_CALCULO_CPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

    private static final int[] PESO_DE_CADA_DIGITO_PARA_CALCULO_CPNJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

    private static int calcularDigito(String str, int[] peso) {
        int somaDigitosCpfCnpj = 0;
        somaDigitosCpfCnpj = verificaDigitosValidos(str, peso, somaDigitosCpfCnpj);
        somaDigitosCpfCnpj = 11 - somaDigitosCpfCnpj % 11;
        return somaDigitosCpfCnpj > 9 ? 0 : somaDigitosCpfCnpj;
    }

    private static int verificaDigitosValidos(String str, int[] peso, int somaDigitosCpfCnpj) {
        for(int indice = str.length() - 1, digitoDocumento ; indice >= 0 ; indice--) {
            digitoDocumento = Integer.parseInt(str.substring(indice, indice + 1));
            somaDigitosCpfCnpj += digitoDocumento * peso[peso.length - str.length() + indice];
        }
        return somaDigitosCpfCnpj;
    }

    public static boolean isCpfValido(String cpf) {
        verificaCpfNuloOuEmBranco(cpf);
        verificaCpfNumerosIguais(cpf);
        verificaCpfApenasComNumeros(cpf);
        verificaCpfTamanhoValido(cpf);
        Integer primeiroDigitoVerificador = calcularDigito(cpf.substring(0, 9), PESO_DE_CADA_DIGITO_PARA_CALCULO_CPF);
        Integer segundoDigitoVerificador = calcularDigito(cpf.substring(0, 9) + primeiroDigitoVerificador, PESO_DE_CADA_DIGITO_PARA_CALCULO_CPF);
        return cpf.equals(cpf.substring(0, 9) + primeiroDigitoVerificador.toString() + segundoDigitoVerificador.toString());
    }
    
    private static void verificaCpfNuloOuEmBranco(String cpf) {
        if (cpf == null || cpf.isEmpty() || cpf.equals(" ")) {
            throw new IllegalArgumentException("O CPF não deve ser nulo ou vazio.");
        }
    }

    private static void verificaCpfTamanhoValido(String cpf) {
        if (cpf.length() != TAMANHO_PADRAO_DIGITOS_CPF) {
            throw new IllegalArgumentException("O CPF Deve conter 11 dígitos.");
        }
    }

    private static void verificaCpfApenasComNumeros(String cpf) {
        for(int i = 0 ; i < cpf.length() ; i++) {
            if (!Character.isDigit(cpf.charAt(i))) {
                throw new IllegalArgumentException("O CPF Deve ser composto apenas por números.");
            }
        }
    }

    private static void verificaCpfNumerosIguais(String cpf) {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")) {
            throw new IllegalArgumentException("O CPF Não pode ser composto por números iguais.");
        }
    }

    public static boolean isCnpjValido(String cnpj) {
        verificaCnpjNuloOuEmBranco(cnpj);
        verificaCnpjNumerosIguais(cnpj);
        verificaCnpjTamanhoValido(cnpj);
        verificaCnpjApenasComNumeros(cnpj);
        Integer primeiroDigitoVerificador = calcularDigito(cnpj.substring(0, 12), PESO_DE_CADA_DIGITO_PARA_CALCULO_CPNJ);
        Integer segundoDigitoVerificador = calcularDigito(cnpj.substring(0, 12) + primeiroDigitoVerificador, PESO_DE_CADA_DIGITO_PARA_CALCULO_CPNJ);
        return cnpj.equals(cnpj.substring(0, 12) + primeiroDigitoVerificador.toString() + segundoDigitoVerificador.toString());
    }

    private static void verificaCnpjNuloOuEmBranco(String cnpj) {
        if (cnpj == null || cnpj.isEmpty() || cnpj.equals(" ")) {
            throw new IllegalArgumentException("O CNPJ não deve ser nulo ou vazio.");
        }
    }

    private static void verificaCnpjApenasComNumeros(String cnpj) {
        for(int i = 0 ; i < cnpj.length() ; i++) {
            if (!Character.isDigit(cnpj.charAt(i))) {
                throw new IllegalArgumentException("O CNPJ Deve ser composto apenas por números.");
            }
        }
    }

    private static void verificaCnpjTamanhoValido(String cnpj) {
        if (cnpj.length() != TAMANHO_PADRAO_DIGITOS_CNPJ) {
            throw new IllegalArgumentException("O CNPJ Deve conter 14 dígitos.");
        }
    }

    private static void verificaCnpjNumerosIguais(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") ||
            cnpj.equals("55555555555555") || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            throw new IllegalArgumentException("O CNPJ Não pode ser composto por números iguais.");
        }
    }

}
