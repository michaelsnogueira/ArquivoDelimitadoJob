package com.springbatch.arquivodelimitado.writer;

import com.springbatch.arquivodelimitado.dominio.Payload;
import com.springbatch.arquivodelimitado.dominio.SapGL;
import com.springbatch.arquivodelimitado.dominio.Transaction;
import com.springbatch.arquivodelimitado.gateway.entity.Pendencia;
import com.springbatch.arquivodelimitado.gateway.repository.PendenciaRepository;
import com.springbatch.arquivodelimitado.service.TrataPayloadService;
import com.springbatch.arquivodelimitado.service.TrataSapGLService;
import com.springbatch.arquivodelimitado.service.TrataTransactionService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivodelimitado.dominio.Entrada;

@Configuration
public class LeituraArquivoDelimitadoWriterConfig {
	private final TrataPayloadService trataPayloadService;
	private final TrataSapGLService trataSapGLService;
	private final TrataTransactionService trataTransactionService;
	private final PendenciaRepository pendenciaRepository;

    public LeituraArquivoDelimitadoWriterConfig(TrataPayloadService trataPayloadService, TrataSapGLService trataSapGLService, TrataTransactionService trataTransactionService, PendenciaRepository pendenciaRepository) {
        this.trataPayloadService = trataPayloadService;
        this.trataSapGLService = trataSapGLService;
        this.trataTransactionService = trataTransactionService;
        this.pendenciaRepository = pendenciaRepository;
    }

    @Bean
	public ItemWriter<Entrada> leituraArquivoDelimitadoWriter() {
		return items -> items.forEach(entrada -> {
			Payload payload = trataPayloadService.trataPayload(entrada);
			SapGL sapGL = trataSapGLService.trataSapGL(payload);
			Transaction transaction = trataTransactionService.trataTransaction(sapGL);
			pendenciaRepository.save(Pendencia.from(payload, sapGL, transaction));
		});
	}
}
