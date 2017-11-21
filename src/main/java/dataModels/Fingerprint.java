package dataModels;

import lombok.Getter;
import lombok.Setter;

public class Fingerprint {

    private static final int NO_ROWS, NO_COLS;
    private static final double THRESHOLD;

    static {
        NO_ROWS = 28;
        NO_COLS = 28;
        THRESHOLD = 0.85;
    }

    @Getter
    @Setter
    private boolean[] booleanMap;

    public Fingerprint() {
        booleanMap = new boolean[NO_ROWS * NO_COLS];
    }

    public Fingerprint(boolean[] booleanMap) {
        this.booleanMap = booleanMap;
    }

    public double generateScore(Fingerprint fingerprint) {

        double matchScore = 0;
        /*Fingerprint maching code here*/

        return matchScore;
    }

    public boolean match(Fingerprint fingerprint) {
        return (generateScore(fingerprint) >= THRESHOLD);
    }
}
