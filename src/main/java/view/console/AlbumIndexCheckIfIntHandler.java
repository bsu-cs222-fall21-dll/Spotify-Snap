package view.console;

import model.parser.hashtable.AlbumHashTable;

public class AlbumIndexCheckIfIntHandler {
    private AlbumHashTable albumHashTableToBeSelectedFrom;

    public String checkIfAlbumIndexOutOfRange(AlbumHashTable albumHashTableToBeSelectedFrom, String userInput){
        this.albumHashTableToBeSelectedFrom = albumHashTableToBeSelectedFrom;
//        UserInput userInput = new UserInput();
//        String albumIndex =  userInput.getAlbum();
        try {
            return checkIfValueInSizeOfHashMap(userInput);

        } catch (NumberFormatException exception){
            System.out.println("Not a valid selection, returning default album");
            return "1";
        }
    }

    private String checkIfValueInSizeOfHashMap(String albumIndex){
        int albumIndexAsInt = Integer.parseInt(albumIndex);
        if(albumHashTableToBeSelectedFrom.size()-1>=albumIndexAsInt){
            return albumIndex;
        } else {
            System.out.println("Not a valid selection, returning default album");
            return "1";
        }
    }
}
