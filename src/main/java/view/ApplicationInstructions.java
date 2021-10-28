package view;

public class ApplicationInstructions {

    public void displayUsageOfApplication() {
        System.out.println(
                """
               *****************************Instructions****************************
               *   1.) Enter Client Credentials in command line to use application *
               *       - Go to Spotify API, login with Spotify Account             *
               *       - Create an app under dashboard                             *
               *       - Copy client credentials into command line to gain access  *
               *   2.) Enter desired search in command line                        *
               *********************************************************************
                """);
    }
}
