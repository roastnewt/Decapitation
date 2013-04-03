package to.joe.decapitation.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ClearNameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players may use this command");
            return true;
        }
        Player player = (Player) sender;
        ItemStack i = player.getItemInHand();
        if (i.getType() == Material.SKULL_ITEM) {
            i.setItemMeta(null);
            player.setItemInHand(i);
            sender.sendMessage(ChatColor.GREEN + "Cleared name");
        } else {
            sender.sendMessage(ChatColor.RED + "That's not a head");
        }
        return true;
    }
}