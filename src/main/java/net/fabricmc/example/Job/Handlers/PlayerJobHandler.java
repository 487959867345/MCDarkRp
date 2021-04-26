package net.fabricmc.example.Job.Handlers;

import net.fabricmc.example.Job.JobBase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class PlayerJobHandler {
    private static HashMap<UUID, JobBase> jobList = new HashMap();

    public static void addPlayerWithJob(UUID player,JobBase job) {
        jobList.put(player, job);
    }
    public static void changePlayerJob(UUID player,JobBase job) {
        removePlayerWithJob(player, job);
        addPlayerWithJob(player, job);
    }
    public static void removePlayerWithJob(UUID player,JobBase job) {
        jobList.remove(player);
    }
    public static HashMap<UUID, JobBase> getPlayerJobList() {
        return jobList;
    }
}
