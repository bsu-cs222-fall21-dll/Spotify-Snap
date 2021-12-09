package view.console;

import model.parser.hashtable.AlbumHashTable;

public class AlbumIndexCheckIfIntHandler {

    private AlbumHashTable albumHashTableToBeSelectedFrom;

    public String checkIfAlbumIndexOutOfRange(AlbumHashTable albumHashTableToBeSelectedFrom, String userInput){

        this.albumHashTableToBeSelectedFrom = albumHashTableToBeSelectedFrom;
        try {
            return checkIfValueInSizeOfHashMap(userInput);

        } catch (NumberFormatException exception){
            return "1";
        }
    }

    private String checkIfValueInSizeOfHashMap(String albumIndex){

        int albumIndexAsInt = Integer.parseInt(albumIndex);
        if(albumHashTableToBeSelectedFrom.size()-1>=albumIndexAsInt && albumIndexAsInt > 0 ){
            return albumIndex;
        }  else {
            return "1";
        }
    }
}
