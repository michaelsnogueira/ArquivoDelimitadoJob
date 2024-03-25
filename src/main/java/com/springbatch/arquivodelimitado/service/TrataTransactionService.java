package com.springbatch.arquivodelimitado.service;

import com.springbatch.arquivodelimitado.dominio.SapGL;
import com.springbatch.arquivodelimitado.dominio.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrataTransactionService {
    public Transaction trataTransaction(SapGL sapGL) {
        String date = LocalDateTime.now().minusDays(1L).format(DateTimeFormatter.ISO_DATE);

        return new Transaction.Builder()
                .tansactionId(sapGL.getPublicId())
                .createTime(date)
                .build();
    }
}
