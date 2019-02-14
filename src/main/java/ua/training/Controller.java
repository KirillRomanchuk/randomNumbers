package ua.training;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private View view;
    private ModelInitializer modelInitializer;
    private List <Model> gameStory = new ArrayList<>();

    public Controller(View view, ModelInitializer modelInitializer) {
        this.view = view;
        this.modelInitializer = modelInitializer;
    }

    public void startTheGame() {
        boolean gameGo = true;

        while (gameGo){
            Model model = modelInitializer.initializeModel();
            inputUserNumber(model);
            view.showUserStat(model.getUserGuessed(), model.getSumUserTry(), model.getRandomNumber());
            int answer = view.requestContinueTheGame();
            gameStory.add(model);
            gameGo = answer == 1;
        }
    }

    private void inputUserNumber(Model model) {
        boolean requestNumber = true;
        int userNumber = 0;
        int randomNumber = model.getRandomNumber();

        while (requestNumber) {
            model.addUserTry();
            userNumber = view.requestUserNumber();

            while (userNumber < model.getMinLimit() || userNumber > model.getMaxLimit()) {
                view.massageAboutWrong();
                userNumber = view.requestUserNumber();
            }

            if (userNumber == randomNumber) {
                model.changeUserGuessed(true);
                requestNumber = false;
            } else {
                if (userNumber < randomNumber) {
                    view.viewMessageIfNumberSmaller();
                }
                if (userNumber > randomNumber) {
                    view.viewMessageIfNumberBigger();
                }
                model.changeLimits(userNumber);
                view.showNewBarrier(model.getMinLimit(), model.getMaxLimit());
            }
        }
    }
}
