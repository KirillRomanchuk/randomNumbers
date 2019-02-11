package ua.training;

import java.io.InputStream;
import java.util.Scanner;

public class InputScanner {
    private Scanner scanner;

    public InputScanner (InputStream inputStream){
        scanner = new Scanner(inputStream);
    }

    public int requestNuber() {
        return scanner.nextInt();
    }
}
