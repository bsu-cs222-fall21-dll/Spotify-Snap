package view;

public class UserInput {

    CMDInput cmdInput = new CMDInput();

    public String getArtist() {
        System.out.println("Enter artist:");
        return cmdInput.inputStringViaCommandLine();
    }

    public String getTypes() {
        System.out.println("""
                Valid Types are album, artist, playlist, track, show and episode

                Enter type:
                """);
        return cmdInput.inputStringViaCommandLine();
    }
}
