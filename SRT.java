import java.util.Arrays;

public class SRT {
    // Function to perform Shortest Remaining Time (SRT) scheduling and calculate average waiting time.
    public static double srtScheduling(int[] arrivalTimes, int[] burstTimes) {
        int n = arrivalTimes.length; // Number of processes
        int currentTime = 0;
        int[] remainingTime = Arrays.copyOf(burstTimes, n);
        boolean[] completed = new boolean[n];
        int totalWaitingTime = 0;

        while (true) {
            int minTime = Integer.MAX_VALUE;
            int shortestJob = -1;

            // Find the process with the shortest remaining time.
            for (int i = 0; i < n; i++) {
                if (!completed[i] && arrivalTimes[i] <= currentTime && remainingTime[i] < minTime) {
                    minTime = remainingTime[i]; // Update the minimum remaining time
                    shortestJob = i; // Update the shortest job index
                }
            }

            if (minTime == Integer.MAX_VALUE) {
                break; // No runnable processes
            }

            // Execute the process for one time unit.
            remainingTime[shortestJob] -= 1;
            currentTime += 1;

            if (remainingTime[shortestJob] == 0) {
                completed[shortestJob] = true; // Mark the process as completed
                totalWaitingTime += currentTime - burstTimes[shortestJob];
            }
        }

        // Calculate and return the average waiting time.
        return (double) totalWaitingTime / n;
    }
}
