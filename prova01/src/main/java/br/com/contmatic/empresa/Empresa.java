package br.com.contmatic.empresa;

public class Empresa {

    private static final int NUMERO_MAXIMO_DE_CASAS_PARA_NUMERO_FUNCIONARIOS = 6;

    private String cnpj;

    private String razaoSocial;

    private String nomeFantasia;

    private String areaAtuacao;

    private Telefone telefone;

    private String numeroFuncionarios;

    public Empresa(String cnpj, String razaoSocial, String nomeFantasia, String areaAtuacao, Telefone telefone, String numeroFuncionarios) {
        this.cnpj = setCnpj(cnpj);
        this.razaoSocial = setRazaoSocial(razaoSocial);
        this.nomeFantasia = setNomeFantasia(nomeFantasia);
        this.areaAtuacao = setAreaAtuacao(areaAtuacao);
        this.telefone = telefone;
        this.numeroFuncionarios = setNumeroFuncionarios(numeroFuncionarios);
    }

    public String getCnpj() {
        return cnpj;
    }

    public String setCnpj(String cnpj) {
        verificaCnpjInvalido(cnpj);
        verificaCnpjValido(cnpj);
        return this.cnpj = cnpj;
    }

    private void verificaCnpjValido(String cnpj) {
        ValidadorCpfCnpj.isCnpjValido(cnpj);
    }

    private void verificaCnpjInvalido(String cnpj) {
        if (!ValidadorCpfCnpj.isCnpjValido(cnpj)) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String setRazaoSocial(String razaoSocial) {
        verificaRazaoSocialNulaOuEmBranco(razaoSocial);
        return this.razaoSocial = razaoSocial;
    }

    private void verificaRazaoSocialNulaOuEmBranco(String razaoSocial) {
        if (razaoSocial == null || razaoSocial.isEmpty() || razaoSocial.equals(" ")) {
            throw new IllegalArgumentException("A Razão Social não deve ser nula ou vazia.");
        }
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String setNomeFantasia(String nomeFantasia) {
        verificaNomeFantasiaNuloOuEmBranco(nomeFantasia);
        return this.nomeFantasia = nomeFantasia;
    }

    private void verificaNomeFantasiaNuloOuEmBranco(String nomeFantasia) {
        if (nomeFantasia == null || nomeFantasia.isEmpty() || nomeFantasia.equals(" ")) {
            throw new IllegalArgumentException("O Nome Fantasia não deve ser nulo ou vazio.");
        }
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public String setAreaAtuacao(String areaAtuacao) {
        verificaAreaAtuacaoNulaOuEmBranco(areaAtuacao);
        return this.areaAtuacao = areaAtuacao;
    }

    private void verificaAreaAtuacaoNulaOuEmBranco(String areaAtuacao) {
        if (areaAtuacao == null || areaAtuacao.isEmpty() || areaAtuacao.equals(" ")) {
            throw new IllegalArgumentException("A Área de Atuação não deve ser nula ou vazia.");
        }
    }

    public String getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public String setNumeroFuncionarios(String numeroFuncionarios) {
        verificaNumeroFuncionariosVazioOuEmBranco(numeroFuncionarios);
        verificaNumeroFuncionariosApenasNumeros(numeroFuncionarios);
        verificaSeContemAoMenosUmFuncionario(numeroFuncionarios);
        verificaNumeroFuncionariosValido(numeroFuncionarios);
        return this.numeroFuncionarios = numeroFuncionarios;
    }

    private void verificaNumeroFuncionariosValido(String numeroFuncionarios) {
        if (numeroFuncionarios.length() > NUMERO_MAXIMO_DE_CASAS_PARA_NUMERO_FUNCIONARIOS) {
            throw new IllegalArgumentException("Número de funcionários inválido");
        }
    }

    private void verificaSeContemAoMenosUmFuncionario(String numeroFuncionarios) {
        if (numeroFuncionarios.equals("0") || numeroFuncionarios.equals("00") || numeroFuncionarios.equals("000") || numeroFuncionarios.equals("0000") || numeroFuncionarios.equals("00000") ||
            numeroFuncionarios.equals("000000")) {
            throw new IllegalArgumentException("Deve conter ao menos um funcionário.");
        }
    }

    private void verificaNumeroFuncionariosApenasNumeros(String numeroFuncionarios) {
        for(int i = 0 ; i < numeroFuncionarios.length() ; i++) {
            if (!Character.isDigit(numeroFuncionarios.charAt(i))) {
                throw new IllegalArgumentException("O Número de funcionários deve ser composto apenas por números.");
            }
        }
    }

    private void verificaNumeroFuncionariosVazioOuEmBranco(String numeroFuncionarios) {
        if (numeroFuncionarios == null || numeroFuncionarios.isEmpty() || numeroFuncionarios.equals(" ")) {
            throw new IllegalArgumentException("O Número de Funcionarios não deve ser nulo ou vazio.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Empresa other = (Empresa) obj;
        if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cnpj.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dados da Empresa: " + "\nCNPJ: " + cnpj + "\nRazão Social: " + razaoSocial + "\nNome Fantasia: " + nomeFantasia + "\nÁrea de Atuação: " + areaAtuacao + "\nTelefone: " + telefone +
            "\nNúmero de Funcionários: " + numeroFuncionarios;
    }

}
