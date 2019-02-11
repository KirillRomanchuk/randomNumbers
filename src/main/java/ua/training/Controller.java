package ua.training;

public class Controller {

    private Model model;
    private View view;
    private RandomNumberActions randomNumberActions;

    public Controller (Model model, View view, RandomNumberActions randomNumberActions){
        this.model = model;
        this.view = view;
        this.randomNumberActions = randomNumberActions;
    }

    public void startTheGame (){
        randomNumberActions.takeLimitForRandomNumber(model, view);
        int randomNumber = randomNumberActions.generateRandomNumber(model.getMinLimit(), model.getMaxLimit());
        model.setRandomNumber(randomNumber);
        int lastUserNumber = inputUserNumber();
        view.showUserStat(model.getUserGuessed(), lastUserNumber, model.getSumUserTry(), model.getRandomNumber());
    }

    public int inputUserNumber (){
        int userNumber;
        int randomNumber = model.getRandomNumber();
        while (true){
            model.addUserTry();
            userNumber = view.requestUserNumber();
            if (userNumber == randomNumber){
                model.changeUserGuessed(true);
                break;
            } else {
              if (userNumber < randomNumber){
                  view.viewMessageIfNumberSmaller();
              }
              if (userNumber > randomNumber){
                  view.viewMessageIfNumberBigger();
              }
              String answer = view.requestContinueTheGame();
              if (answer.equals("no")){
                  break;
              }
            }
        }
        return userNumber;
    }
}
