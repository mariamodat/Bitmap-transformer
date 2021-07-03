package main.java.Bitmap.transformer;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {

        Bitmap bitmap = new Bitmap(Paths.get(args[0]).toString(),args[1]);

        bitmap.pinkilizedBMP();

        switch (args[2]){
            case "grayscale":
                bitmap.grayscaleBMP();
                break;
            case "invert":
                bitmap.invertBMP();
                break;
            case "pinkilize":
                bitmap.pinkilizedBMP();
                break;
            case "blueralize":
                bitmap.blueralize();
        }

    }
}