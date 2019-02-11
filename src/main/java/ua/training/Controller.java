package ua.training;

public class Controller {

    private Model model;
    private View view;
    private ModelInitializer modelInitializer;

    public Controller(Model model, View view, ModelInitializer modelInitializer) {
        this.model = model;
        this.view = view;
        this.modelInitializer = modelInitializer;
    }

    public void startTheGame() {
        modelInitializer.takeLimitForRandomNumber(model, view);
        int randomNumber = modelInitializer.generateRandomNumber(model.getMinLimit(), model.getMaxLimit());
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
