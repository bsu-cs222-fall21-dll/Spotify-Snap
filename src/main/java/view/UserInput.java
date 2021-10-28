package view;

import java.util.Locale;

public class UserInput {

    CMDInput cmdInput = new CMDInput();

    public String getArtist() {
        System.out.println("Enter Artist Name: ");
        return cmdInput.inputStringViaCommandLine();
    }

    public String getTypes() {
        System.out.println("""
                Valid Search Types: 
                    1.) album 
                    2.) artist 
                    3.) playlist 
                    4.) track
                    5.) show and episode
                
                Enter search type:""");
        return cmdInput.inputStringViaCommandLine().toLowerCase(Locale.ROOT);
    }
}
