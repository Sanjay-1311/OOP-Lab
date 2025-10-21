package Lab_9;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LastModified {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\notsa\\OOPS-lab\\OOP-Lab\\Lab_9\\Example.txt");
        try {
            if (file.exists()) {
                Instant lastModifiedInstant = Instant.ofEpochMilli(file.lastModified());
                LocalDateTime lastModified = LocalDateTime.ofInstant(lastModifiedInstant, ZoneId.systemDefault());
                String formattedTimestamp = lastModified.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                Duration sinceModified = Duration.between(lastModifiedInstant, Instant.now());
                String elapsed = formatDuration(sinceModified);

                System.out.println("Last modified on: " + formattedTimestamp);
                System.out.println("Time since last modification: " + elapsed);
            } else {
                System.out.println("File not found. Please check the file path: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static String formatDuration(Duration duration) {
        long days = duration.toDays();
        duration = duration.minusDays(days);
        long hours = duration.toHours();
        duration = duration.minusHours(hours);
        long minutes = duration.toMinutes();
        duration = duration.minusMinutes(minutes);
        long seconds = duration.getSeconds();

        StringBuilder builder = new StringBuilder();
        if (days > 0) {
            builder.append(days).append(days == 1 ? " day " : " days ");
        }
        if (hours > 0) {
            builder.append(hours).append(hours == 1 ? " hour " : " hours ");
        }
        if (minutes > 0) {
            builder.append(minutes).append(minutes == 1 ? " minute " : " minutes ");
        }
        if (seconds > 0 || builder.length() == 0) {
            builder.append(seconds).append(seconds == 1 ? " second" : " seconds");
        }
        return builder.toString().trim();
    }
}
