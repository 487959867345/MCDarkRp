package net.catchyaintit.darkrp.client;

import net.catchyaintit.darkrp.job.JobBase;

public class ClientProfileHandler {
    static int money = 0;
    static JobBase job;
    static String jobIdTranslated;

    public static String getJobIdTranslated() {
        return jobIdTranslated;
    }

    public static void setJobIdTranslated(String jobIdTranslated) {
        ClientProfileHandler.jobIdTranslated = jobIdTranslated;
    }

    public static JobBase getJob() {
        return job;
    }

    public static void setJob(JobBase job) {
        ClientProfileHandler.job = job;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        money = money;
    }
}
