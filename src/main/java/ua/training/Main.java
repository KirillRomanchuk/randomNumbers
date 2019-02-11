package ua.training;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        RandomNumberAction randomNumberAction = new RandomNumberAction();
        Controller controller = new Controller(model, view, randomNumberAction);
        controller.startTheGame();
    }
}
