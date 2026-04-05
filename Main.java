package rtp;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Player;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;

import java.util.Random;

public class Main extends PluginBase {

    private final Random random = new Random();

    @Override
    public void onEnable() {
        getLogger().info("RTP включен!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!command.getName().equalsIgnoreCase("rtp")) return false;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Только для игроков");
            return true;
        }

        Player player = (Player) sender;
        Level level = player.getLevel();

        int x = random.nextInt(3000) - 1500;
        int z = random.nextInt(3000) - 1500;

        int y = level.getHighestBlockAt(x, z);

        Position pos = new Position(x + 0.5, y + 2, z + 0.5, level);

        player.teleport(pos);
        player.sendMessage("§aТы рандомно телепортирован!");

        return true;
    }
}