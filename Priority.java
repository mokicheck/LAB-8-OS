import java.util.Arrays;

public class Priority {
    public static double priorityScheduling(int[] burstTimes, int[] priorities) {
        int n = burstTimes.length;
        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            processes[i] = new Process(burstTimes[i], priorities[i]);
        }

        Arrays.sort(processes);
        int waitingTime = 0;
        int totalWaitingTime = 0;

        // Loop through the sorted processes and calculate waiting times.
        for (Process process : processes) {
            waitingTime += process.burstTime;
            totalWaitingTime += waitingTime;
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
