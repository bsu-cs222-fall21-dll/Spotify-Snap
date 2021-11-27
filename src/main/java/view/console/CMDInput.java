package view.console;

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
            System.err.println("Please input a value");
            inputStringViaCommandLine();
        }
    }
}
