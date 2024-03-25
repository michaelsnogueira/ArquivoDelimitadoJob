package com.springbatch.arquivodelimitado.dominio;

import java.util.regex.Matcher;

public class Transaction {

    private String tansactionId;
    private String createTime;

    private Transaction() {
    }

    public static class Builder {
        private final Transaction transaction;

        public Builder() {
            transaction = new Transaction();
        }

        public Builder tansactionId(String tansactionId) {
            transaction.tansactionId = tansactionId.replace("cc:", "");
            return this;
        }

        public Builder createTime(String createTime) {
            transaction.createTime = createTime + " 22:48:06.5210000";
            return this;
        }

        public Transaction build() {
            return transaction;
        }
    }

    public static String mountTransaction(Transaction t) {
        return """
                UPDATE CLAIMCENTER.DBO.CC_TRANSACTION SET CREATETIME = '%s', UPDATETIME = '%s' WHERE ID = %s;                 
                 """.formatted(t.createTime, t.createTime, t.tansactionId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tansactionId='" + tansactionId + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
