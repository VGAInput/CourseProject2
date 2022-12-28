package Ticket_17;

public class CheckIfPalindrome {
    public static void main(String[] args) {
        /*
        Написать программу, которая будет проверять,
        является ли слово из пяти букв, палиндромом
        (примеры: «комок», «ротор») и возвращает true/false.
        */

        isPalindrome("комок");
        isPalindrome("ёлка");
        isPalindrome("топот");
        isPalindrome("топор");
        isPalindrome("in girum imus nocte et consumimur igni");
        isPalindrome("а роза упала на лапу азора");

    }

    private static boolean isPalindrome(String string) {

        String checkString = string.replaceAll(" ", "");

        for (int i = 0; i <= checkString.length() / 2; i++) {
            if (checkString.charAt(i) == checkString.charAt(checkString.length() - (i + 1))) {
                if (i == (Math.abs(checkString.length())) / 2) {
                    System.out.println("Слово " + string + " является полиндромом.");
                    return true;
                }
            } else {
                break;
            }
        }
        System.out.println("Слово " + string + " не является полиндромом.");
        return false;
    }
}
