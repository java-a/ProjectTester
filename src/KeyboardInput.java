import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lifengshuang on 13/11/2016.
 */
public class KeyboardInput {
    public static void main(String[] args) throws FileNotFoundException, AWTException, InterruptedException {
        Robot robot = new Robot();
        int delay = 200;

        File[] files = (new File("input")).listFiles();
        for (File file : files) {
            System.out.println("Test: " + file.getName());
            System.out.println("Test will begin in 5s");
            robot.delay(5000);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                for (byte a : input.getBytes()) {
                    System.out.println(a);
                    if (a < 0) {
                        break;
                    }
                    if (Character.isLetter(a)) {
                        a -= 32;
                    }
                    robot.keyPress(a);
                    robot.keyRelease(a);
                    robot.delay(delay);
                }
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.delay(delay);
            }
            System.out.println("Enter anything to run next test.");
            (new Scanner(System.in)).next();
        }
    }
}
