package com.springbatch.arquivodelimitado.dominio;

public enum CodigoEvento {
    GWDI_02111("Reserva", "Correção Monetária"),
    GWDI_02112("Reserva", "Juros"),
    GWDI_02104("Pagamento", "Correção Monetária; Juros"),;

    private final String tipoTransacao;
    private final String categoriaCusto;

    CodigoEvento(String tipoTransacao, String categoriaCusto) {
        this.tipoTransacao = tipoTransacao;
        this.categoriaCusto = categoriaCusto;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }
    public String getCategoriaCusto() {
        return categoriaCusto;
    }

    public static CodigoEvento fromTipoTransacaoAndCategoriaCusto(String tipoTransacao, String categoriaCusto) {
        for (CodigoEvento codigoEvento : CodigoEvento.values()) {
            if (codigoEvento.getTipoTransacao().equals(tipoTransacao) && codigoEvento.getCategoriaCusto().equals(categoriaCusto)) {
                return codigoEvento;
            }
        }
        return CodigoEvento.GWDI_02104;
    }
}
