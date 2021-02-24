package de.gebelcl;

public class Main {

    public static void main(String[] args) {
        System.out.println("Dice simulator\n");
        System.out.println("Each roll may occur only once:");

        Statistics s = new Statistics(6);

        int randomNumber;
        while (s.getSetDigits() < 6) {
            randomNumber = (int) (Math.random() * 6); // range: 0 - 5
            if (s.setPosition(randomNumber)) { // if a digit could be set, setPosition returns true
                System.out.print(randomNumber + 1 + ": ");
                s.printDigitRow();
            }
        }
    }
}
