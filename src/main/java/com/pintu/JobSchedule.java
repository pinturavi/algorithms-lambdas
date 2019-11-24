package com.pintu;

import javax.print.attribute.standard.JobName;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JobSchedule {
    public static void main(String[] args) {
        final var jobs = List.of(new Job(5, 200), new Job(3, 180), new Job(3, 190), new Job(2, 300)
                , new Job(4, 120), new Job(2, 100));
        System.out.println(getSchedule(jobs, jobs.stream().max(Comparator.comparingInt(Job::getDeadline)).map(Job::getDeadline).get()));

    }

    private static String getSchedule(List<Job> jobs, int numberofslots) {
        Job[] scheduledJobs = new Job[numberofslots];
        final var sortedJobs = jobs.stream().sorted(Comparator.comparingInt(Job::getProfit).reversed()).collect(Collectors.toList());
        int scheduled = 0;
        for (var job: sortedJobs){
            if (scheduled == numberofslots) {
                break;
            }
            scheduleJob(job, scheduledJobs);
            ++scheduled;

        }

        return Arrays.toString(scheduledJobs);
    }

    private static void scheduleJob(Job job, Job[] scheduledJobs) {
        int i =job.getDeadline()-1;
        while(i >= 0){
            if (scheduledJobs[i] == null) {
                scheduledJobs[i] = job;
                return;
            }
            i--;
        }
    }
}

class Job{
    private int deadline;

    private int profit;

    public Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}
