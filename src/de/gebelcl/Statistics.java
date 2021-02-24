package de.gebelcl;

public class Statistics {
    private int maxNumberOfDigits;
    private int numberOfDigits;
    private long leftDigitRow, rightDigitRow;
    private int digitPosition;

    public Statistics(int maxNumberOfDigits) {
        this.maxNumberOfDigits = maxNumberOfDigits;
    }


    public void printDigitRow() {
        if (maxNumberOfDigits > 63) {
            String leftDigitString = String.format("%63s", Long.toBinaryString(leftDigitRow)).replace(' ', '0');
            int beginIndex = 126 - maxNumberOfDigits;
            System.out.print(leftDigitString.substring(beginIndex));
            System.out.println(String.format("%63s", Long.toBinaryString(rightDigitRow)).replace(' ', '0'));
        } else  {
            String leftDigitString = String.format("%63s", Long.toBinaryString(rightDigitRow)).replace(' ', '0');
            int beginIndex = 63 - maxNumberOfDigits;
            System.out.print(leftDigitString.substring(beginIndex));
        }


    }

    public boolean setPosition(int digitPosition) {
        if (digitPosition > maxNumberOfDigits ||digitPosition > 126 || digitPosition < 0) {
            System.err.println("Error: digitPosition out of range.");
            System.exit(1);
        }

        if (digitPosition > 62) {
            // Put the 1 which has to be set on the position 'digitPosition'
            long binaryDigitPosition = 1L << (digitPosition - 63);
            // if the 1 is not already set, set it in the variable leftDigitRow
            if ((leftDigitRow & binaryDigitPosition) == 0) {
                leftDigitRow = leftDigitRow ^ binaryDigitPosition;
                return true;
            } else {

                return false;
            }
        } else {
            long binaryDigitPosition = 1L << digitPosition;
            // if the 1 is not already set, set it in the variable rightDigitRow
            if ((rightDigitRow & binaryDigitPosition) == 0) {
                rightDigitRow = rightDigitRow ^ binaryDigitPosition;
                return true;
            } else {
                return false;
            }
        }
    }

    public int getPosition() {
        return digitPosition;
    }
}
