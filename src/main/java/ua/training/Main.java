package ua.training;

public class Main {
    public static void main(String[] args) {
        View view = new View(System.in);
        ModelInitializer modelInitializer = new ModelInitializer(view);
        Controller controller = new Controller(view, modelInitializer);
        controller.startTheGame();
    }
}
