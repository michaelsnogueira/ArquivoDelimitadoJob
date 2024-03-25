package com.springbatch.arquivodelimitado.dominio;

public class SapGL {
    private String eventID;
    private String publicId;
    private String payload;
    private String proposalNumber;
    private String policyNumber;
    private String claimNumber;
    private String endorsementNumber;
    private String installmentNumber;
    private String taxID;
    private String updateTime;
    private String createTime;
    private String retired;
    private String updateUser;
    private String createUser;
    private String messageID;
    private String gCSIDLG;
    private String evironName;

    private SapGL() {
    }

    public static class Builder {
        private final SapGL sapgl;

        public Builder() {
            sapgl = new SapGL();
        }
        public Builder eventID(String eventID) {
            sapgl.eventID = eventID;
            return this;
        }
        public Builder publicId(String publicId) {
            sapgl.publicId = publicId;
            return this;
        }
        public Builder payload(String payload) {
            sapgl.payload = payload;
            return this;
        }
        public Builder proposalNumber(String proposalNumber) {
            sapgl.proposalNumber = proposalNumber;
            return this;
        }
        public Builder policyNumber(String policyNumber) {
            sapgl.policyNumber = policyNumber;
            return this;
        }
        public Builder claimNumber(String claimNumber) {
            sapgl.claimNumber = claimNumber;
            return this;
        }
        public Builder endorsementNumber(String endorsementNumber) {
            sapgl.endorsementNumber = endorsementNumber;
            return this;
        }
        public Builder installmentNumber(String installmentNumber) {
            sapgl.installmentNumber = installmentNumber;
            return this;
        }
        public Builder taxID(String taxID) {
            sapgl.taxID = taxID;
            return this;
        }
        public Builder updateTime(String updateTime) {
            sapgl.updateTime = updateTime + " 22:48:06.5210000";
            return this;
        }
        public Builder createTime(String createTime) {
            sapgl.createTime = createTime + " 22:48:06.5210000";
            return this;
        }
        public Builder retired(String retired) {
            sapgl.retired = retired;
            return this;
        }
        public Builder updateUser(String updateUser) {
            sapgl.updateUser = updateUser;
            return this;
        }
        public Builder createUser(String createUser) {
            sapgl.createUser = createUser;
            return this;
        }
        public Builder messageID(String messageID) {
            sapgl.messageID = messageID;
            return this;
        }
        public Builder gCSIDLG(String gCSIDLG) {
            sapgl.gCSIDLG = gCSIDLG;
            return this;
        }
        public Builder evironName(String evironName) {
            sapgl.evironName = evironName;
            return this;
        }
        public SapGL build() {
            return sapgl;
        }
    }

    public String getPublicId() {
        return publicId;
    }

    public static String mountInsertSAPGL(SapGL s) {
        return """
                INSERT INTO IntegrationDataCenter.[dbo].[sapgl_log] ([EventID],[PublicId],[Payload],[ProposalNumber],[PolicyNumber],[ClaimNumber],[EndorsementNumber],[InstallmentNumber],[TaxID],[UpdateTime],[CreateTime],[Retired],[UpdateUser],[CreateUser],[MessageID],[GCSIDLG],[EvironName])
                          VALUES ('%s','%s', '%s', '%s', '%s', '%s', %s, %s, '%s', '%s', '%s', %s, '%s', '%s', '%s', '%s', '%s');
                """.formatted(s.eventID,
                s.publicId,
                s.payload,
                s.proposalNumber,
                s.policyNumber,
                s.claimNumber,
                s.endorsementNumber,
                s.installmentNumber,
                s.taxID,
                s.updateTime,
                s.createTime,
                s.retired,
                s.updateUser,
                s.createUser,
                s.messageID,
                s.gCSIDLG,
                s.evironName);

    }
}
