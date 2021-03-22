package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        char[] c = s.toCharArray();
        int sumOfLetters = 0;
        int sumOfDigits = 0;
        for (char c1 : c) {
            if (Character.isLetter(c1)) {
                sumOfLetters++;
            }
            if (Character.isDigit(c1)) {
                sumOfDigits++;
            }
        }
        return sumOfDigits > sumOfLetters;
    }

}

