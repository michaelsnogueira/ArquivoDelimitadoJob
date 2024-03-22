package com.springbatch.arquivodelimitado.dominio;

public class Entrada {
	private String policyNumber;
    private String tipoTransacao;
    private String categoriaCusto;
    private String transacaoId;
    private String numSinistro;
    private String numProposta;
    private String cpfCnpj;
    private String valorMovimento;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getCategoriaCusto() {
        return categoriaCusto;
    }

    public void setCategoriaCusto(String categoriaCusto) {
        this.categoriaCusto = categoriaCusto;
    }

    public String getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(String transacaoId) {
        this.transacaoId = transacaoId;
    }

    public String getNumSinistro() {
        return numSinistro;
    }

    public void setNumSinistro(String numSinistro) {
        this.numSinistro = numSinistro;
    }

    public String getNumProposta() {
        return numProposta;
    }

    public void setNumProposta(String numProposta) {
        this.numProposta = numProposta;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(String valorMovimento) {
        this.valorMovimento = valorMovimento;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "policyNumber='" + policyNumber + '\'' +
                ", tipoTransacao='" + tipoTransacao + '\'' +
                ", categoriaCusto='" + categoriaCusto + '\'' +
                ", transacaoId='" + transacaoId + '\'' +
                ", numSinistro='" + numSinistro + '\'' +
                ", numProposta='" + numProposta + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", valorMovimento='" + valorMovimento + '\'' +
                '}';
    }
}