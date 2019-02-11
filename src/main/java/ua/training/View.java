package ua.training;

import java.util.Scanner;

public class View {
    private static final String REQUEST_MIN_LIMIT = "Please enter minimum barrier to generate a random number: ";
    private static final String REQUEST_MAX_LIMIT = "Please enter maximum barrier to generate a random number: ";
    private static final String REQUEST_USER_NUMBER = "Please enter your number: ";
    private static final String USER_NUMBER_BIGGER = "Sorry, your number is bigger than game guess. ";
    private static final String USER_NUMBER_SMALLER = "Sorry, your number is smaller than game guess.";
    private static final String ASK_USER_ABOUT_CONTINUE = "Do you want to continue the game ? (yes/no): ";
    private static final String USER_WIN = "We congratulate. You win the game.";
    private static final String USER_LOOSE = "You lose the game.";
    private Scanner scanner = new Scanner(System.in);

    public void viewMessageUserWin() {
        System.out.println(USER_WIN);
    }

    public void viewMessageUserLoose() {
        System.out.println(USER_LOOSE);
    }

    public void viewMessageIfNumberBigger() {
        System.out.print(USER_NUMBER_BIGGER);
    }

    public void viewMessageIfNumberSmaller() {
        System.out.print(USER_NUMBER_SMALLER);
    }

    private int requestNumberFromUser(String systemText) {
        System.out.println(systemText);
        return scanner.nextInt();
    }

    public int requestUserNumber() {
        return requestNumberFromUser(REQUEST_USER_NUMBER);
    }

    public int requestMinLimit() {
        return requestNumberFromUser(REQUEST_MIN_LIMIT);
    }

    public int requestMaxLimit() {
        return requestNumberFromUser(REQUEST_MAX_LIMIT);
    }

    private String requestTextFromUser(String systemText) {
        System.out.println(systemText);
        return scanner.nextLine();
    }

    public String requestContinueTheGame() {
        return requestTextFromUser(ASK_USER_ABOUT_CONTINUE);
    }

    public void showUserStat(boolean userWin, int lastUserNumber, int userTries, int randomNumber) {
        if (userWin) {
            viewMessageUserWin();
        } else {
            viewMessageUserLoose();
        }

        StringBuilder outText = new StringBuilder();
        outText.append("User last number: ");
        outText.append(lastUserNumber);
        outText.append("\n");
        outText.delete(0, outText.length());
        outText.append("User tries: ");
        outText.append(userTries);
        outText.append("\n");
        outText.delete(0, outText.length());
        outText.append("Random number: ");
        outText.append(randomNumber);
        outText.append("\n");
        outText.delete(0, outText.length());
        System.out.println(outText.toString());
    }
}
