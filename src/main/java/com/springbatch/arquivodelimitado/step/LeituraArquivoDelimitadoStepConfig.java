package com.springbatch.arquivodelimitado.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivodelimitado.dominio.Entrada;

@Configuration
public class LeituraArquivoDelimitadoStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step leituraArquivoDelimitadoStep(ItemReader<Entrada> leituraArquivoDelimitadoReader,
			ItemWriter<Entrada> leituraArquivoDelimitadoWriter) {
		return stepBuilderFactory
				.get("leituraArquivoDelimitadoStep")
				.<Entrada, Entrada>chunk(1)
				.reader(leituraArquivoDelimitadoReader)
				.writer(leituraArquivoDelimitadoWriter)
				.build();
	}
}
