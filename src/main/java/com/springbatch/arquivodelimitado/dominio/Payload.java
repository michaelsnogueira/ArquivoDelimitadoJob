package com.springbatch.arquivodelimitado.dominio;

public class Payload {

    private final String codOrigem = "Y005";
    private final String numLote = "GWSINISTGL20240201000001";
    private String codVenda;
    private String codEvento;
    private final String codEmpresa = "C000";
    private String codIDLG;
    private String dtaDocumento;
    private String dtaLancamento;
    private String codRamo;
    private String numEndosso;
    private String numSinistro;
    private String nomCanalVenda;
    private String codProduto;
    private String codFonte;
    private String numProposta;
    private String numCPFCNPJ;
    private final String codAtribuicao = "GWDI_TER23335";
    private String vlrSinistro;

    private Payload() {
    }
    public String getCodVenda() {
        return codVenda;
    }

    public String getCodEvento() {
        return codEvento;
    }

    public String getCodIDLG() {
        return codIDLG;
    }

    public String getNumSinistro() {
        return numSinistro;
    }

    public String getNumProposta() {
        return numProposta;
    }

    public String getNumCPFCNPJ() {
        return numCPFCNPJ;
    }

    public static class Builder {
        private final Payload payload;

        public Builder() {
            payload = new Payload();
        }

        public Builder codVenda(String codVenda) {
            payload.codVenda = codVenda;
            return this;
        }

        public Builder codEvento(String codEvento) {
            payload.codEvento = codEvento;
            return this;
        }

        public Builder codIDLG(String codIDLG) {
            payload.codIDLG = "cc:" + codIDLG;
            return this;
        }

        public Builder dtaDocumento(String dtaDocumento) {
            payload.dtaDocumento = dtaDocumento;
            return this;
        }

        public Builder dtaLancamento(String dtaLancamento) {
            payload.dtaLancamento = dtaLancamento;
            return this;
        }

        public Builder codRamo(String policyNumber) {
            payload.codRamo = policyNumber.contains("61014") ? "0114" : "0118";
            return this;
        }

        public Builder numEndosso(String numEndosso) {
            payload.numEndosso = numEndosso;
            return this;
        }

        public Builder numSinistro(String numSinistro) {
            payload.numSinistro = numSinistro;
            return this;
        }

        public Builder nomCanalVenda(String nomCanalVenda) {
            payload.nomCanalVenda = nomCanalVenda;
            return this;
        }

        public Builder codProduto(String numero) {
            payload.codProduto = numero.contains("61014") ? "L0001403" : "L0001804";
            return this;
        }

        public Builder codFonte(String codFonte) {
            payload.codFonte = codFonte;
            return this;
        }

        public Builder numProposta(String numProposta) {
            payload.numProposta = numProposta;
            return this;
        }

        public Builder numCPFCNPJ(String numCPFCNPJ) {
            payload.numCPFCNPJ = numCPFCNPJ;
            return this;
        }

        public Builder vlrSinistro(String vlrSinistro) {
            payload.vlrSinistro = vlrSinistro;
            return this;
        }

        public Payload build() {
            return payload;
        }
    }

    public static String mountPayload(Payload p) {
        return """
                    <?xml version="1.0"?>
                    <Q1:evento xmlns:Q1="http://ge.caixaseguradora.com.br/EventoContabil/v1.4">
                      <codOrigem>%s</codOrigem>
                      <numLote>%s</numLote>
                      <codVenda>%s</codVenda>
                      <codEvento>%s</codEvento>
                      <codEmpresa>%s</codEmpresa>
                      <codIDLG>%s</codIDLG>
                      <dtaDocumento>%s</dtaDocumento>
                      <dtaLancamento>%s</dtaLancamento>
                      <codRamo>%s</codRamo>
                      <numEndosso>%s</numEndosso>
                      <numSinistro>%s</numSinistro>
                      <nomCanalVenda>%s</nomCanalVenda>
                      <codProduto>%s</codProduto>
                      <codFonte>%s</codFonte>
                      <numProposta>%s</numProposta>
                      <numCPFCNPJ>%s</numCPFCNPJ>
                      <codAtribuicao>%s</codAtribuicao>
                      <vlrSinistro>%s</vlrSinistro>
                    </Q1:evento>
                """.formatted(p.codOrigem,
                p.numLote,
                p.codVenda,
                p.codEvento,
                p.codEmpresa,
                p.codIDLG,
                p.dtaDocumento,
                p.dtaLancamento,
                p.codRamo,
                p.numEndosso,
                p.numSinistro,
                p.nomCanalVenda,
                p.codProduto,
                p.codFonte,
                p.numProposta,
                p.numCPFCNPJ,
                p.codAtribuicao,
                p.vlrSinistro);
    }

    @Override
    public String toString() {
        return "Payload{" +
                "codOrigem='" + codOrigem + '\'' +
                ", numLote='" + numLote + '\'' +
                ", codVenda='" + codVenda + '\'' +
                ", codEvento='" + codEvento + '\'' +
                ", codEmpresa='" + codEmpresa + '\'' +
                ", codIDLG='" + codIDLG + '\'' +
                ", dtaDocumento='" + dtaDocumento + '\'' +
                ", dtaLancamento='" + dtaLancamento + '\'' +
                ", codRamo='" + codRamo + '\'' +
                ", numEndosso='" + numEndosso + '\'' +
                ", numSinistro='" + numSinistro + '\'' +
                ", nomCanalVenda='" + nomCanalVenda + '\'' +
                ", codProduto='" + codProduto + '\'' +
                ", codFonte='" + codFonte + '\'' +
                ", numProposta='" + numProposta + '\'' +
                ", numCPFCNPJ='" + numCPFCNPJ + '\'' +
                ", codAtribuicao='" + codAtribuicao + '\'' +
                ", vlrSinistro='" + vlrSinistro + '\'' +
                '}';
    }
}
