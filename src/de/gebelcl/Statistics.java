package de.gebelcl;

public class Statistics {
    private int maxNumberOfDigits;
    private int numberOfDigits;
    private long digitRow;
    private int digitPosition;

    public Statistics(int maxNumberOfDigits) {
        this.maxNumberOfDigits = maxNumberOfDigits;
    }

    public void printDigitRow() {
        System.out.println(Long.toBinaryString(digitRow));
    }

    public void printBinaryNumber(long number) {
        System.out.println(String.format("%8s", Long.toBinaryString(number)).replace(' ', '0'));
    }

    public boolean setPosition(int digitPosition) {
        if (digitPosition > 62) {
            System.err.println("Error: the maximum for digitPosition is 62.");
            System.exit(1);
        }
        // Put the 1 which has to be set on the position 'digitPosition'
        long binaryDigitPosition = 1 << digitPosition;
        // if the 1 is not already set, set it in the variable digitRow
        if ((digitRow & binaryDigitPosition) == 0) {
            digitRow = digitRow ^ binaryDigitPosition;
            printBinaryNumber(digitRow);
            return true;
        } else {
            printBinaryNumber(digitRow);
            return false;
        }
    }

    public int getPosition() {
        return digitPosition;
    }

    // 0-62

}
