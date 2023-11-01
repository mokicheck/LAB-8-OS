import java.util.Arrays;

public class SJN {
    public static double sjnScheduling(int[] burstTimes) {
        int n = burstTimes.length;
        int[] sortedBurstTimes = Arrays.copyOf(burstTimes, n);
        Arrays.sort(sortedBurstTimes);
        int waitingTime = 0;
        int totalWaitingTime = 0;

        // Loop through the sorted processes and calculate waiting times.
        for (int i = 0; i < n; i++) {
            waitingTime += sortedBurstTimes[i];
            totalWaitingTime += waitingTime;
        }

        // Calculate and return the average waiting time.
        return (double) totalWaitingTime / n;
    }
}
