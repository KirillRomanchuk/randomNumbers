package ua.training;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private int randomNumber;
    private int minLimit;
    private int maxLimit;
    private boolean userGuessed;
    private List<Integer> userTries = new ArrayList<>();

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int number) {
        randomNumber = number;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(int number) {
        minLimit = number;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int number) {
        maxLimit = number;
    }

    public List<Integer> getUserTries() {
        return userTries;
    }

    public void addUserTry(int userNumber) {
        userTries.add(userNumber);
    }

    public void changeUserGuessed(boolean flag) {
        userGuessed = flag;
    }

    public boolean getUserGuessed() {
        return userGuessed;
    }

    public void changeLimits(int userNumber) {
        if (userNumber > randomNumber) {
            maxLimit = userNumber;
        } else {
            minLimit = userNumber;
        }
    }

    /*public checkUserNumber (int userNumber){

    }*/
}
