package Lab_6;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ColorShapes {

    private static final String LOG_FILE = "log3.txt";

    private static class LogWriter {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        private static boolean sessionOpened;

        private static void log(String message) {
            ensureSessionOpened();
            write(message);
        }

        private static void close() {
            if (sessionOpened) {
                write("--- Log Session Ended: " + LocalDateTime.now().format(FORMATTER) + " ---");
                sessionOpened = false;
            }
        }

        private static void ensureSessionOpened() {
            if (!sessionOpened) {
                write("\n--- Log Session Started: " + LocalDateTime.now().format(FORMATTER) + " ---");
                sessionOpened = true;
            }
        }

        private static void write(String message) {
            try (FileWriter fw = new FileWriter(LOG_FILE, true); PrintWriter writer = new PrintWriter(fw)) {
                writer.println(message);
            } catch (IOException e) {
                System.err.println("CRITICAL ERROR: Unable to write to log3.txt. " + e.getMessage());
            }
        }
    }

    private static void logAndPrint(String message) {
        System.out.println(message);
        LogWriter.log(message);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple"};

        Shape[] shapes = new Shape[3];

        shapes[0] = new Rectangle(10, 5);
        shapes[1] = new Triangle(8, 4);
        shapes[2] = new Circle(3);

        try {
            logAndPrint("\n--- Shape Details ---");
            for (Shape s : shapes) {
                double area = s.area();
                logAndPrint("Shape:" + s.getClass().getSimpleName() + " area:" + area);
                String colorMessage = ((Colorable) s).colorDescription(colors[rand.nextInt(colors.length)]);
                logAndPrint(colorMessage);
                logAndPrint("");
            }
        } finally {
            LogWriter.close();
        }
    }
}