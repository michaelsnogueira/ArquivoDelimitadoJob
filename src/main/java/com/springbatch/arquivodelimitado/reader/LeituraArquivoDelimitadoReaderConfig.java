package com.springbatch.arquivodelimitado.reader;

import com.springbatch.arquivodelimitado.dominio.Entrada;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoDelimitadoReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<Entrada> leituraArquivoDelimitadoReader(
			@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes
	) {
		return new FlatFileItemReaderBuilder<Entrada>()
				.name("leituraArquivoDelimitadoReader")
				.resource(arquivoClientes)
				.delimited()
				.names("policyNumber", "tipoTransacao", "categoriaCusto", "transacaoId", "numSinistro", "numProposta", "cpfCnpj", "valorMovimento")
				.targetType(Entrada.class)
				.build();

    }
}
