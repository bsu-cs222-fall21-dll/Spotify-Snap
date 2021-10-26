import Controller.CMDController;
import model.SpotifyConnection;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CMDController controller = new CMDController();
        controller.run();
    }
}
