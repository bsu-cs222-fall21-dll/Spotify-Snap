package view.console;

public class UserInput {

    CMDInput cmdInput = new CMDInput();

    public String getArtist() {

        System.out.println("Enter Artist Name: ");
        return cmdInput.inputStringViaCommandLine();
    }

    public String getAlbum(){
        System.out.println("Enter the index of the album you would like the songs of: ");
        return cmdInput.inputStringViaCommandLine();
    }

}
