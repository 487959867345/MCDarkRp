package net.catchyaintit.darkrp.economy.handlers;

import java.util.HashMap;
import java.util.UUID;

public class MoneyHandler {
    static HashMap<UUID, Integer> moneyMap = new HashMap<>();


    public static void pay(UUID player, int amount) {
        moneyMap.replace(player, moneyMap.get(player) + amount);
    }
    public static void createDefault(UUID player) {
        moneyMap.put(player, 0);
    }

    public static Integer getBalance(UUID uuid) {
        return moneyMap.get(uuid);
    }

}
