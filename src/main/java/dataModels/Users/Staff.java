package dataModels.Users;

import dataModels.Fingerprint;
import dataModels.Time.Date;
import lombok.Getter;

import java.util.ArrayList;

public class Staff {

    @Getter
    private String firstName, middleName, lastName;
    @Getter
    private String barcode;
    @Getter
    private Date dateOfBirth, dateOfIssue;
    @Getter
    private ArrayList<String> transactionID;
    @Getter
    private Fingerprint fingerprint;
    @Getter
    private boolean isRegistered, isValid;

    public Staff setFirstName(String firstName) {
        this.firstName = firstName.toLowerCase();
        return this;
    }

    public Staff setMiddleName(String middleName) {
        this.middleName = middleName.toLowerCase();
        return this;
    }

    public Staff setLastName(String lastName) {
        this.lastName = lastName.toLowerCase();
        return this;
    }

    public Staff setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public Staff setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Staff setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
        return this;
    }

    public Staff setTransactionID(ArrayList<String> transactionID) {
        this.transactionID = transactionID;
        return this;
    }

    public Staff setFingerprint(Fingerprint fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    public Staff setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
        return this;
    }

    public Staff setValid(boolean isValid) {
        this.isValid = isValid;
        return this;
    }
}