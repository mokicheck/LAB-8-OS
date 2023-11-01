import java.util.Arrays;

public class Priority {
    // Function to perform Priority scheduling and calculate average waiting time.
    public static double priorityScheduling(int[] burstTimes, int[] priorities) {
        int n = burstTimes.length; // Number of processes
        Process[] processes = new Process[n];

        // Create an array of processes with burst times and priorities.
        for (int i = 0; i < n; i++) {
            processes[i] = new Process(burstTimes[i], priorities[i]);
        }

        Arrays.sort(processes); // Sort processes based on priority
        int waitingTime = 0;
        int totalWaitingTime = 0;

        // Loop through the sorted processes and calculate waiting times.
        for (Process process : processes) {
            waitingTime += process.burstTime; // Update waiting time for the next process
            totalWaitingTime += waitingTime; // Accumulate total waiting time
        }

        // Calculate and return the average waiting time.
        return (double) totalWaitingTime / n;
    }
}

class Process implements Comparable<Process> {
    int burstTime;
    int priority;

    public Process(int burstTime, int priority) {
        this.burstTime = burstTime;
        this.priority = priority;
    }

    @Override
    public int compareTo(Process other) {
        return this.priority - other.priority;
    }
}
