package dataModels;

import dataModels.Time.Timestamp;
import lombok.Getter;

public class Transaction {

    @Getter
    private String transactionID;
    @Getter
    private String beneficiary;
    @Getter
    private String benefactor;
    @Getter
    private Timestamp timestamp;

    public Transaction setTransactionID(String transactionID) {
        this.transactionID = transactionID;
        return this;
    }

    public Transaction setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
        return this;
    }

    public Transaction setBenefactor(String benefactor) {
        this.benefactor = benefactor;
        return this;
    }

    public Transaction setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
