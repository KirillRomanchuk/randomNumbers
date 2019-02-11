package ua.training;

public class Model {
    private int randomNumber;
    private int minLimit, maxLimit, sumUserTry;
    private boolean userGuessed;

    public int getRandomNumber(){
        return randomNumber;
    }

    public void setRandomNumber(int number){
        randomNumber = number;
    }

    public int getMinLimit (){
        return minLimit;
    }

    public void setMinLimit (int number){
        minLimit = number;
    }

    public int getMaxLimit (){
        return maxLimit;
    }

    public void setMaxLimit (int number){
        maxLimit = number;
    }

    public int getSumUserTry(){
        return sumUserTry;
    }

    public void addUserTry(){
        sumUserTry = ++sumUserTry;
    }

    public void changeUserGuessed(boolean flag){
        userGuessed = flag;
    }

    public boolean getUserGuessed(){
        return userGuessed;
    }

}
