public class FCFS {
    // Function to perform FCFS scheduling and calculate average waiting time.
    public static double fcfsScheduling(int[] burstTimes) {
        int n = burstTimes.length; // Number of processes
        int waitingTime = 0;
        int totalWaitingTime = 0;

        // Loop through the processes and calculate waiting times.
        for (int i = 0; i < n; i++) {
            waitingTime += burstTimes[i]; // Update waiting time for the next process
            totalWaitingTime += waitingTime; // Accumulate total waiting time
        }

        // Calculate and return the average waiting time.
        return (double) totalWaitingTime / n;
    }
}
