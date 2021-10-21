package view;

public class ArtistFinder {
    CMDInput cmdInput = new CMDInput();
    public String getArtist() {
        System.out.println("Enter artist:");
        return cmdInput.inputString();
    }
}
