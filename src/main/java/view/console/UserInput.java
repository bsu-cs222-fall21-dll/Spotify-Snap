package view.console;

public class UserInput {

    CMDInput cmdInput = new CMDInput();

    public String getArtist() {

        System.out.println("Enter Artist Name: ");
        return cmdInput.inputStringViaCommandLine();
    }

}
