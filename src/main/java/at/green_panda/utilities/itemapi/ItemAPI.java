package at.green_panda.utilities.itemapi;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Green_Panda
 * Class create at 18.07.2021 09:53
 */

public class ItemAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        int pluginId = 12093;
        Metrics metrics = new Metrics(this, pluginId);

        System.out.println("ItemAPI > Thanks for using ItemAPI (by Green_Panda)");
    }
}
