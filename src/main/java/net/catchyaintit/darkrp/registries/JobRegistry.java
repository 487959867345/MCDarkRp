package net.catchyaintit.darkrp.registries;

import net.catchyaintit.darkrp.job.JobBase;
import net.catchyaintit.darkrp.job.JobType;

import java.util.HashMap;
import java.util.Map;

public class JobRegistry {
    static HashMap<String, JobBase> jobMap = new HashMap<String, JobBase>();

    public static void register(String id, JobBase job) throws Exception {
        if (jobMap.containsKey(id)) {
            throw new Exception("Existing Job Error" + id);
        }else {
            jobMap.put(id, job);
            job.setId(id);
        }
    }

    public static HashMap<String, JobBase> getCriminalJobs() {
        HashMap<String, JobBase> temp = new HashMap<String, JobBase>();

        for (Map.Entry<String, JobBase> job : jobMap.entrySet()) {
            if (job.getValue().getType() == JobType.CRIMINAL) {
                temp.put(job.getKey(), job.getValue());
            }
        }
        return temp;
    }

    public static HashMap<String, JobBase> getJobs() {
        return jobMap;
    }
}
