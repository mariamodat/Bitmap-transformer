package Bitmap.transformer;

import java.util.Arrays;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
public class App {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        Bitmap newBitmap = new Bitmap(args[0], args[1]);
        newBitmap.changeColor();
        newBitmap.pinkilizedBMP();

        newBitmap.writeNewImg();
    }
}