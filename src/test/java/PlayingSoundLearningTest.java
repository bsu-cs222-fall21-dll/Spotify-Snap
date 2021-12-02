import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayingSoundLearningTest {


    public void playAudioTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //inspired by this thread https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/test/resources/ouverture.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(1);
    }
}
