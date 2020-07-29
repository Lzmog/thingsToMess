package LogomeFisher.ui;

import java.awt.*;

public class StatsPaint {
    private Stats stats;

    public StatsPaint(Stats stats) {
        this.stats = stats;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Sans serif", Font.BOLD, 13));

        int xAxis = 45, yAxis = 45, sp = 15;

        g2.drawString(String.format("Fishing level %d", stats.getFishLevel()), xAxis, yAxis);
        yAxis += sp;
        g2.drawString(String.format("Bank trips %d", stats.getBankTrips()), xAxis, yAxis);
        yAxis += sp;
        g2.drawString(String.format("Anchovies %d", stats.getAnchovies()), xAxis, yAxis );
        yAxis += sp;
        g2.drawString(String.format("Shrimp %d", stats.getShrimps()), xAxis, yAxis);
        yAxis += sp;
        g2.drawString(String.format("Running time %s", formatTime(stats.getStartTime())), xAxis, yAxis);
        yAxis += sp;
        g2.drawString(String.format("Status: %s", stats.getStatus()), xAxis, yAxis);
        yAxis += sp;
        g2.drawString(String.format("Total XP: %s", coolFormat((double) stats.getTotalXP(), 0)), xAxis, yAxis);
    }

    /**
     * Formats time from milliseconds to HH:MM:SS format
     * @param startTime long
     * @return String time
     */
    public String formatTime(long startTime) {
        // Taken from ShantayX all credits to author
        final long runTimeMilliseconds = System.currentTimeMillis() - startTime;
        final long secondsTotal = runTimeMilliseconds / 1000;
        final long minutesTotal = secondsTotal / 60;
        final long hoursTotal = minutesTotal / 60;
        int[] currentTimeHMS = new int[3];

        currentTimeHMS[2] = (int) (secondsTotal % 60);
        currentTimeHMS[1]  = (int) (minutesTotal % 60);
        currentTimeHMS[0] = (int) (hoursTotal % 500);

        return String.format("%02d:%02d:%02d", currentTimeHMS[0], currentTimeHMS[1], currentTimeHMS[2]);
    }



    /**
     * Recursive implementation, invokes itself for each factor of a thousand, increasing the class on each invokation.
     * From http://stackoverflow.com/questions/4753251/how-to-go-about-formatting-1200-to-1-2k-in-java
     * @param n the number to format
     * @param iteration in fact this is the class from the array c
     * @return a String representing the number n formatted in a cool looking way.
     */
    private String coolFormat(double n, int iteration) {
        char[] c = new char[]{'k', 'm', 'b', 't'};

        double d = ((long) n / 100) / 10.0;
        boolean isRound = (d * 10) %10 == 0;//true if the decimal part is equal to 0 (then it's trimmed anyway)
        return (d < 1000? //this determines the class, i.e. 'k', 'm' etc
                ((d > 99.9 || isRound || (!isRound && d > 9.99)? //this decides whether to trim the decimals
                        (int) d * 10 / 10 : d + "" // (int) d * 10 / 10 drops the decimal
                ) + "" + c[iteration])
                : coolFormat(d, iteration+1));
    }
}
