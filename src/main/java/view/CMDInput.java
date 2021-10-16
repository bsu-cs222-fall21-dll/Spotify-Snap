package view;

import java.util.Scanner;

public class CMDInput {

    public String inputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
