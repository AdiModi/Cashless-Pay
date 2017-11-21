package dataModels.Users;

import lombok.Getter;

import java.util.ArrayList;

public class Vendor {

    @Getter
    private String name;
    @Getter
    private ArrayList<String> transactionID;
}
