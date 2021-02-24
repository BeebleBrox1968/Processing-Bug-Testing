import processing.core.PApplet;
import processing.core.PImage;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Draws the images with the specified renderer
 * @author BeebleBrox1968
 */
public class DrawingSurface extends PApplet {
    private String mode;
    private PImage[] images;
    private float frameSum;

    /**
     * Creates a Drawing surface with the specified mode
     * @param mode
     */
    public DrawingSurface(String mode) {
        this.mode = mode;
        images = new PImage[7];
        frameSum = 0;
    }

    /**
     * Sets the size and renderer.
     */
    public void settings() {
        size(2000, 1400, mode);
    }

    /**
     * Initializes and resizes the images.
     */
    public void setup() {
        frameRate(60);
        images[0] = loadImage("res/iu-5.jpeg");
        images[1] = loadImage("res/iu-6.jpeg");
        images[2] = loadImage("res/iu-7.jpeg");
        images[3] = loadImage("res/iu-8.jpeg");
        images[4] = loadImage("res/iu-9.jpeg");
        images[5] = loadImage("res/iu-10.jpeg");
        images[6] = loadImage("res/iu-11.jpeg");
        for (PImage image : images) {
            image.resize(2000, 200);
        }
    }

    /**
     * Draws each image 100 times and records the results for the average frame rate.
     */
    public void draw() {
        if (frameCount == 100) {
            System.out.println(frameSum / frameCount);
            try {
                FileWriter writer = new FileWriter("stats.txt", true);
                writer.write(Float.toString(frameSum / frameCount) + "\n\n\n\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            exit();
        }

        for (int i = 0; i < images.length; i++) {
            image(images[i], 0, i * 200);

        }
        frameSum += frameRate;
    }
}
