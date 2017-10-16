package dataModels;

import lombok.Getter;
import lombok.Setter;

public class Transaction {

    @Getter
    @Setter
    private String transactionID;
    @Getter
    @Setter
    private String vendorName;
    @Getter
    @Setter
    private String clientName;
}
