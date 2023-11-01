public class FCFS {
    public static double fcfsScheduling(int[] burstTimes) {
        int n = burstTimes.length;
        int waitingTime = 0;
        int totalWaitingTime = 0;

        // Loop through the processes and calculate waiting times.
        for (int i = 0; i < n; i++) {
            waitingTime += burstTimes[i];
            totalWaitingTime += waitingTime;
        }

        // Calculate and return the average waiting time.
        return (double) totalWaitingTime / n;
    }
}
