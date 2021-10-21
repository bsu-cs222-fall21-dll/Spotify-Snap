package view;

import java.util.Scanner;

public class CMDInput {

    public String inputStringViaCommandLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
