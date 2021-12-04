package view.console;

public class UserInput {

    CMDInput cmdInput = new CMDInput();

    public String getArtist() {

        System.out.println("""
                ========================= Spotify Snap =========================
                
                Enter artist name:
                """);
        return cmdInput.inputStringViaCommandLine();
    }

    public String getAlbum(){
        System.out.println("Enter the index of the album you would like the songs of: ");
        String inputString = cmdInput.inputStringViaCommandLine();
        inputString = cmdInput.checkForMissingInput(inputString);
        return inputString;
    }

}
