package view.console;

import java.util.Scanner;

public class CMDInput {

    public String inputStringViaCommandLine(){

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String checkForMissingInput(String userInput) {

        if (userInput.isEmpty()) {
            System.err.println("Please input a value");
            return checkForMissingInput(inputStringViaCommandLine());
        } else {
            return userInput;
        }
    }
}
