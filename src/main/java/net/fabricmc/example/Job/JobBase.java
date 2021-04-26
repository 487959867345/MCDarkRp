package net.fabricmc.example.Job;

import java.util.UUID;

public class JobBase {
    public int payCycle;
    public int pay;
    private JobType type;
    public int lastPayed = -1;
    public JobBase(JobType type, int pay, int payCycle) {
        this.pay = pay;
        this.type = type;
        this.payCycle = payCycle;
    }

    public JobType getType() {
        return type;
    }
}
