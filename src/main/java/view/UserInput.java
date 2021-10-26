package view;

import java.util.Locale;

public class UserInput {

    CMDInput cmdInput = new CMDInput();

    public String getArtist() {
        System.out.println("Enter Artist Name:");
        return cmdInput.inputStringViaCommandLine();
    }

    public String getTypes() {
        System.out.println("""
                Valid Types are album, artist, playlist, track, show and episode
                Enter search type:""");
        return cmdInput.inputStringViaCommandLine().toLowerCase(Locale.ROOT);
    }
}
