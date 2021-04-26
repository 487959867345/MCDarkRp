package net.catchyaintit.darkrp.job;

public class JobBase {
    public int payCycle;
    public int pay;
    private JobType type;
    public int lastPayed = -1;
    public String Id;
    public JobBase(JobType type, int pay, int payCycle) {
        this.pay = pay;
        this.type = type;
        this.payCycle = payCycle;
    }

    public JobType getType() {
        return type;
    }

    public void setId(String Id) {
     this.Id = Id;
    }
    public String getId() {
        return Id;
    }
}
