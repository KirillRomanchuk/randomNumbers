package ua.training;

public class Controller {

    private Model model;
    private View view;
    private RandomNumberAction randomNumberAction;

    public Controller(Model model, View view, RandomNumberAction randomNumberAction) {
        this.model = model;
        this.view = view;
        this.randomNumberAction = randomNumberAction;
    }

    public void startTheGame() {
        randomNumberAction.takeLimitForRandomNumber(model, view);
        int randomNumber = randomNumberAction.generateRandomNumber(model.getMinLimit(), model.getMaxLimit());
        model.setRandomNumber(randomNumber);
        int lastUserNumber = inputUserNumber();
        view.showUserStat(model.getUserGuessed(), lastUserNumber, model.getSumUserTry(), model.getRandomNumber());
    }

    public int inputUserNumber() {
        int userNumber;
        int randomNumber = model.getRandomNumber();
        while (true) {
            model.addUserTry();
            userNumber = view.requestUserNumber();
            if (userNumber == randomNumber) {
                model.changeUserGuessed(true);
                break;
            } else {
                if (userNumber < randomNumber) {
                    view.viewMessageIfNumberSmaller();
                }
                if (userNumber > randomNumber) {
                    view.viewMessageIfNumberBigger();
                }
            }
        }
        return userNumber;
    }
}
