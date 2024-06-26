package com.springbatch.arquivodelimitado.config;

import com.springbatch.arquivodelimitado.service.TrataPayloadService;
import com.springbatch.arquivodelimitado.service.TrataSapGLService;
import com.springbatch.arquivodelimitado.service.TrataTransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InicializaBeansConfig {

    @Bean
    public TrataPayloadService trataPayloadService() {
        return new TrataPayloadService();
    }

    @Bean
    public TrataSapGLService trataSapGLService() {
        return new TrataSapGLService();
    }

    @Bean
    public TrataTransactionService trataTransactionService() {
        return new TrataTransactionService();
    }
}
