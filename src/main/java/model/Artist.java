package model;

import net.minidev.json.JSONArray;

public class Artist {
    private String name;
    private String id;
    private String uri;
    private String followerCount;

    public Artist(JSONArray inputArray) {
        ArtistParser artistParser = new ArtistParser();
        this.name = artistParser.parseArtistName(inputArray);
        this.id = artistParser.parseArtistId(inputArray);
        this.uri = artistParser.parseArtistUri(inputArray);
        this.followerCount = artistParser.parseArtistFollowersTotal(inputArray);
    }
}
