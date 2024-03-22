package com.springbatch.arquivodelimitado.writer;

import com.springbatch.arquivodelimitado.dominio.Payload;
import com.springbatch.arquivodelimitado.service.TrataPayloadService;
import com.springbatch.arquivodelimitado.service.TrataSapGLService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivodelimitado.dominio.Entrada;

@Configuration
public class LeituraArquivoDelimitadoWriterConfig {
	private final TrataPayloadService trataPayloadService;
	private final TrataSapGLService trataSapGLService;

    public LeituraArquivoDelimitadoWriterConfig(TrataPayloadService trataPayloadService, TrataSapGLService trataSapGLService) {
        this.trataPayloadService = trataPayloadService;
        this.trataSapGLService = trataSapGLService;
    }

    @Bean
	public ItemWriter<Entrada> leituraArquivoDelimitadoWriter() {
		return items -> items.forEach(entrada -> {
			Payload payload = trataPayloadService.trataPayload(entrada);
			System.out.println(trataSapGLService.trataSapGL(payload));
		});
	}
}
