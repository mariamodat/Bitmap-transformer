package main.java.Bitmap.transformer;
import java.util.Arrays;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.awt.Graphics2D;
public class Bitmap {
    // data about the image
    private String inputName;
    private String outputName;
    private BufferedImage image;
    // constructor
    public Bitmap(String inputName, String outputName) {
        this.inputName = inputName;
        this.outputName = outputName;
        this.createImage(inputName);
    }
    // method to create object
    private void createImage(String inputName) {
        try {
            File bmpFile = new File("src/main/resources/" + inputName);
            this.image = ImageIO.read(bmpFile);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    public void changeColor(){
        BufferedImage img = null;
        File inputPath = null;
        //read image
        try{
            inputPath = new File("src/main/resources/" + inputName);
            img = ImageIO.read(inputPath);
        }catch(IOException e){
            System.err.println(e);
        }
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        //convert to negative
        for(int row = 0; row < height; row++){
            for(int column = 0; column < width; column++){
                int RGB = img.getRGB(column,row);
                int a = (RGB>>24)&0xff;
                int r = (RGB>>16)&0xff;
                int g = (RGB>>8)&0xff;
                int b = RGB&0xff;
                //subtract RGB from 255
                r = 5 + r;
                g = 20 + g;
                b = 120 + b;
                //set new RGB value
                RGB = (a<<24) | (r<<16) | (g<<8) | b;
                img.setRGB(column, row, RGB);
            }
        }
        //write image
        try{
            inputPath = new File("src/main/resources/test1.bmp");
            ImageIO.write(img, "bmp", inputPath);
        }catch(IOException e){
            System.err.println(e);
        }
    };
    //take img and write to a new file.
    public void writeNewImg(){
        try{
            ImageIO.write(this.image, "bmp", new File("src/main/resources/" + outputName));
        } catch(IOException e){
            System.out.println(e);
        }
    }
}