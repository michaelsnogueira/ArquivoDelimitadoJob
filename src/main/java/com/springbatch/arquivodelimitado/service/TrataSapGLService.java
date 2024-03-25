package com.springbatch.arquivodelimitado.service;

import com.springbatch.arquivodelimitado.dominio.Payload;
import com.springbatch.arquivodelimitado.dominio.SapGL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrataSapGLService {
    public SapGL trataSapGL(Payload payload) {
        String date = LocalDateTime.now().minusDays(1L).format(DateTimeFormatter.ISO_DATE);

        return new SapGL.Builder()
                .eventID(payload.getCodEvento())
                .publicId(payload.getCodIDLG())
                .payload(Payload.mountPayload(payload).trim())
                .proposalNumber(payload.getNumProposta())
                .policyNumber(payload.getCodVenda())
                .claimNumber(payload.getNumSinistro())
                .endorsementNumber("NULL")
                .installmentNumber("NULL")
                .taxID(payload.getNumCPFCNPJ())
                .updateTime(date)
                .createTime(date)
                .retired("0")
                .updateUser("sys")
                .createUser("sys")
                .messageID(payload.getCodIDLG())
                .gCSIDLG(payload.getCodIDLG())
                .evironName("prod")
                .build();
    }
}
