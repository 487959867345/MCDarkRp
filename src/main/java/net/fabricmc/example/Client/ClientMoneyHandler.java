package net.fabricmc.example.Client;

public class ClientMoneyHandler {
    static int Money = 0;

    public static int getMoney() {
        return Money;
    }

    public static void setMoney(int money) {
        Money = money;
    }
}
