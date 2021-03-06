package CowKiller.ui;

import java.awt.*;

import static java.util.concurrent.TimeUnit.*;

public class CowhideSummaryUi {
    private static final String SUMMARY_TITLE = "Cowhide Picker";
    private static final Color TRANS_GREY = new Color(119, 136, 153, 175);

    /**
     * Shows the summary of the statistics for the chicken feather picker.
     * @param graphics graphics to draw on
     * @param version script version
     * @param startTime start time of the script
     * @param totalCowHidesFeathersPickedUp total chicken feathers picked up successfully
     */
    public static void ShowStatisticsSummary(Graphics graphics, String version, long startTime, int totalCowHidesFeathersPickedUp) {
        int cowhidesPerHr = 0;
        long runningTime = System.currentTimeMillis() - startTime;
        if (runningTime > HOURS.toMillis(1)) {
            cowhidesPerHr = (int)(totalCowHidesFeathersPickedUp / (MILLISECONDS.toHours(runningTime)));
        }

        // Background
        graphics.setColor( new Color(0, 0, 0, 150));
        graphics.drawRect(0, 35, 180, 110);
        graphics.fillRect(0, 35, 180, 110);

        // Title
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 14));
        graphics.drawString(SUMMARY_TITLE, 10, 50);

        // Version
        graphics.setFont(new Font("Arial", Font.PLAIN, 10));
        graphics.setColor(Color.WHITE);
        graphics.drawString("(" + version + ")", 10, 60);

        graphics.setFont(new Font("Arial", Font.PLAIN, 13));

        // Total picked up feathers
        graphics.setColor(Color.WHITE);
        graphics.drawString("Total Cowhides: " + totalCowHidesFeathersPickedUp, 10, 85);

        // Total picked up feathers per hour
        graphics.setColor(Color.WHITE);
        graphics.drawString("Cowhides/hr: " + cowhidesPerHr, 10, 100);

        // Running time
        int runtime = Integer.parseInt("" + runningTime);
        graphics.drawString("Run time: " + FormatTime(runtime), 10, 140);
    }

    /**
     * Format the duration into a readable string.
     * @param duration milliseconds to format time
     * @return human readable string of the duration
     */
    private static String FormatTime(long duration) {
        long days = MILLISECONDS.toDays(duration);
        long hours = MILLISECONDS.toHours(duration) - DAYS.toHours(MILLISECONDS.toDays(duration));
        long minutes = MILLISECONDS.toMinutes(duration) - HOURS.toMinutes(MILLISECONDS.toHours(duration));
        long seconds = MILLISECONDS.toSeconds(duration) - MINUTES.toSeconds(MILLISECONDS.toMinutes(duration));

        if (days == 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }

        return String.format("%02d:%02d:%02d:%02d", days, hours, minutes, seconds);
    }
}
