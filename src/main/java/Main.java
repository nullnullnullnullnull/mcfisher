import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws AWTException, IOException, TesseractException, InterruptedException {
        Robot robot = new Robot();
        while(true){
            BufferedImage image = robot.createScreenCapture(new Rectangle(1350, 750, 550, 350));
            //TimeUnit.SECONDS.sleep(1);
            //ImageIO.write(image, "png", new File("screenshot.png"));

            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("./tessdata");
            tesseract.setLanguage("eng");
            //tesseract.setPageSegMode(1);
            //tesseract.setOcrEngineMode(1);
            String result = tesseract.doOCR(image);
            System.out.println(result);
            if (result.contains("Fishing Bobber")){
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

                TimeUnit.MICROSECONDS.sleep(600);

                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                //System.out.println(123123123);
                TimeUnit.SECONDS.sleep(3);
            }
        }

    }
}
