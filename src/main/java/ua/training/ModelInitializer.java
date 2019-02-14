package ua.training;

import java.util.Random;

public class ModelInitializer {
    private View view;
    private Random randomNumber = new Random();

    public ModelInitializer (View view) {
        this.view = view;
    }

    public Model initializeModel (){
        Model model = new Model();
        takeLimitForRandomNumber(model);
        int rn = generateRandomNumber(model.getMinLimit(),model.getMaxLimit());
        System.out.println(rn);
        model.setRandomNumber(rn);
        return model;
    }

    private int generateRandomNumber(int minLimit, int maxLimit) {
        int bufferMaxLimit = maxLimit == 0 ? 100 : maxLimit;
        return Math.max(minLimit + 1, randomNumber.nextInt(bufferMaxLimit));
    }

    private void takeLimitForRandomNumber(Model model) {
        model.setMinLimit(view.requestMinLimit());
        model.setMaxLimit(view.requestMaxLimit());
    }
}
