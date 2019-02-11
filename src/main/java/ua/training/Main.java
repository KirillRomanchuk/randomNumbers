package ua.training;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        RandomNumberActions randomNumberActions = new RandomNumberActions();
        Controller controller = new Controller(model, view, randomNumberActions);
        controller.startTheGame();
    }
}
