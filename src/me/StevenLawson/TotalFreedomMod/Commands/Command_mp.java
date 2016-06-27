package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Convert;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Purge all mobs in all worlds.", usage = "/<command>")
public class Command_mp extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.RED + "Purging all mobs...");
        sender.sendMessage(ChatColor.GREEN + TFM_Convert.toString(purgeMobs()) + " mobs removed.");
        return true;
    }

    public static int purgeMobs()
    {
        int removed = 0;
        for (World world : Bukkit.getWorlds())
        {
            for (Entity ent : world.getLivingEntities())
            {
                if (ent instanceof Creature || ent instanceof Ghast || ent instanceof Slime || ent instanceof EnderDragon || ent instanceof Ambient)
                {
                    ent.remove();
                    removed++;
                }
            }
        }

        return removed;
    }
}
