package com.springbatch.arquivodelimitado.service;

import com.springbatch.arquivodelimitado.dominio.CodigoEvento;
import com.springbatch.arquivodelimitado.dominio.Entrada;
import com.springbatch.arquivodelimitado.dominio.Payload;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrataPayloadService {

    public Payload trataPayload(Entrada entrada) {
        String date = LocalDateTime.now().minusDays(1L).format(DateTimeFormatter.ISO_DATE);
        return new Payload.Builder()
                .codVenda(entrada.getPolicyNumber())
                .codEvento(CodigoEvento.fromTipoTransacaoAndCategoriaCusto(entrada.getTipoTransacao(), entrada.getCategoriaCusto()).name())
                .codIDLG(entrada.getTransacaoId())
                .dtaDocumento(date)
                .dtaLancamento(date)
                .codRamo(entrada.getNumSinistro())
                .numEndosso("0")
                .numSinistro(entrada.getNumSinistro())
                .nomCanalVenda("08")
                .codProduto(entrada.getNumSinistro())
                .codFonte("19")
                .numProposta(entrada.getNumProposta())
                .numCPFCNPJ(entrada.getCpfCnpj())
                .vlrSinistro(entrada.getValorMovimento())
                .build();



    }
}
