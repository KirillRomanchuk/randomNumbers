package ua.training;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final String REQUEST_MIN_LIMIT = "Please enter minimum barrier to generate a random number: ";
    private static final String REQUEST_MAX_LIMIT = "Please enter maximum barrier to generate a random number: ";
    private static final String REQUEST_USER_NUMBER = "Please enter your number: ";
    private static final String USER_NUMBER_BIGGER = "Sorry, your number is bigger than game guess. ";
    private static final String USER_NUMBER_SMALLER = "Sorry, your number is smaller than game guess.";
    private static final String ASK_USER_ABOUT_CONTINUE = "Do you want to continue the game ? (1 - Yes/2 or other - No): ";
    private static final String USER_WIN = "We congratulate you. You win the game.";
    private static final String USER_LOOSE = "You lose the game.";
    private static final String SHOW_USER_STORY = "User last number: %s\nUser tries: %s\nRandom number: %s\n";
    private static final String RANDOM_BARRIER = "Current range: ]%s to %s[";
    private static final String WRONG_NUMBER = "Input value outside the specified range!";
    private final Scanner scanner;

    public View(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    private void viewMessage(String messageText) {
        System.out.println(messageText);
    }

    public void massageAboutWrong() {
        viewMessage(WRONG_NUMBER);
    }

    public void showNewBarrier(int minLimit, int maxLimtit) {
        viewMessage(String.format(RANDOM_BARRIER, minLimit, maxLimtit));
    }

    public void viewMessageUserWin() {
        viewMessage(USER_WIN);
    }

    public void viewMessageUserLoose() {
        viewMessage(USER_LOOSE);
    }

    public void viewMessageIfNumberBigger() {
        viewMessage(USER_NUMBER_BIGGER);
    }

    public void viewMessageIfNumberSmaller() {
        viewMessage(USER_NUMBER_SMALLER);
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

    public int requestContinueTheGame() {
        return requestNumberFromUser(ASK_USER_ABOUT_CONTINUE);
    }

    public void showUserStat(boolean userWin, List<Integer> userTries, int randomNumber) {
        if (userWin) {
            viewMessageUserWin();
        } else {
            viewMessageUserLoose();
        }

        System.out.println(String.format(SHOW_USER_STORY, userWin, userTries.toString(), randomNumber));
    }
}
