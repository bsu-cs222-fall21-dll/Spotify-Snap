package view;

import java.util.Scanner;

public class CMDInput {

    public String inputStringViaCommandLine(){

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        checkForMissingInput(userInput);
        return userInput;
    }

    public void checkForMissingInput(String userInput) {

        if (userInput.isEmpty()) {
            System.err.println("Missing Input: Error Code 1");
            System.exit(1);
        }
    }
}
