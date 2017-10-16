package dataModels.Users;

import dataModels.Fingerprint;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

public class Staff {

    @Getter
    @Setter
    private String firstName, middleName, lastName, barcode;
    @Getter
    @Setter
    private Date dateOfBirth;
    @Getter
    @Setter
    private ArrayList<String> transactionID;
    @Getter
    @Setter
    private Fingerprint fingerprint;
}
