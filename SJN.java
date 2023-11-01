import java.util.Arrays;

public class SJN {
    // Function to perform SJN (Shortest Job Next) scheduling and calculate average waiting time.
    public static double sjnScheduling(int[] burstTimes) {
        int n = burstTimes.length; // Number of processes
        int[] sortedBurstTimes = Arrays.copyOf(burstTimes, n);
        Arrays.sort(sortedBurstTimes); // Sort burst times in ascending order
        int waitingTime = 0;
        int totalWaitingTime = 0;

        // Loop through the sorted processes and calculate waiting times.
        for (int i = 0; i < n; i++) {
            waitingTime += sortedBurstTimes[i]; // Update waiting time for the next process
            totalWaitingTime += waitingTime; // Accumulate total waiting time
        }

        // Calculate and return the average waiting time.
        return (double) totalWaitingTime / n;
    }
}
