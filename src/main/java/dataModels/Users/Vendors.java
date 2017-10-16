package dataModels.Users;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Vendors {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private ArrayList<String> transactionID;
}
