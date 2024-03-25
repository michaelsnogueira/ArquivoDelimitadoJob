package com.springbatch.arquivodelimitado.gateway.entity;


import com.springbatch.arquivodelimitado.dominio.Payload;
import com.springbatch.arquivodelimitado.dominio.SapGL;
import com.springbatch.arquivodelimitado.dominio.Transaction;

import javax.persistence.*;

@Entity
public class Pendencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(length = 10000)
    private String payload;
    @Column(length = 10000)
    private String sapGL;
    @Column(length = 10000)
    private String transaction;
    private String sinistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getSapGL() {
        return sapGL;
    }

    public void setSapGL(String sapGL) {
        this.sapGL = sapGL;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
    public static Pendencia from(Payload payload, SapGL sapGL, Transaction transaction) {
        Pendencia pendencia = new Pendencia();
        pendencia.setPayload(Payload.mountPayload(payload));
        pendencia.setSapGL(SapGL.mountInsertSAPGL(sapGL));
        pendencia.setTransaction(Transaction.mountTransaction(transaction));
        pendencia.setSinistro(payload.getNumSinistro());
        return pendencia;
    }

    public String getSinistro() {
        return sinistro;
    }

    public void setSinistro(String sinistro) {
        this.sinistro = sinistro;
    }
}
