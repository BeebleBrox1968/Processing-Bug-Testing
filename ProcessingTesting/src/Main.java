import processing.core.PApplet;
import processing.core.PConstants;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Main class that runs the PApplet
 * @author BeebleBrox1968
 */
public class Main {

    /**
     * Runs drawing surface and records version name
     * @param args
     */
    public static void main(String[] args) {
        String mode = PConstants.JAVA2D;//I manually changed this when I was testing
        System.out.println(System.getProperty("java.version"));
        System.out.println(mode);
        FileWriter writer = null;
        try {
            writer = new FileWriter("stats.txt", true);
            writer.write(System.getProperty("java.version") + " : " + mode + '\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DrawingSurface drawing = new DrawingSurface(mode);
        PApplet.runSketch(new String[]{""}, drawing);
    }
}
