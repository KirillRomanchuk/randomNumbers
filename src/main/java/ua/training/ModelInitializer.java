package ua.training;

import java.util.Random;

public class ModelInitializer {
    private Random randomNumber = new Random();

    public int generateRandomNumber(int minLimit, int maxLimit) {
        int bufferMaxLimit = maxLimit == 0 ? 100 : maxLimit;
        return Math.max(minLimit, randomNumber.nextInt(bufferMaxLimit + 1));
    }

    public void takeLimitForRandomNumber(Model model, View view) {
        model.setMinLimit(view.requestMinLimit());
        model.setMaxLimit(view.requestMaxLimit());
    }
}
