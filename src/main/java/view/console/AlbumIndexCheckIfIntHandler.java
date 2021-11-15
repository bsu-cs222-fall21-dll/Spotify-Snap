package view.console;

import model.parser.hashtable.AlbumHashTable;

public class AlbumIndexCheckIfIntHandler {
    public String checkIfAlbumIndexOutOfRange(AlbumHashTable albumHashTableToBeSelectedFrom){
        UserInput userInput = new UserInput();
        String albumIndex =  userInput.getAlbum();
        try {
            Integer.parseInt(albumIndex);
            return albumIndex;
        } catch (NumberFormatException exception){
            System.out.println("Not a valid selection, returning default albums");
            return "0";
        }
    }
}
