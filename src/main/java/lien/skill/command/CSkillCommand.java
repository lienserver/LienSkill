package lien.skill.command;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gnurung.gunucommandmodule.Command;

import lien.skill.data.SlotData.InventoryMode;

public class CSkillCommand 
{

	@Command("/csk")
	public static void help(CommandSender sender)
	{
		help(sender,1);
	}
	@Command("/csk vi <int>!")
	public static void help(CommandSender sender, Integer page)
	{
		if(page == null) page = 1;
		switch(page)
		{
		case 1:
			sender.sendMessage("§c[Skill Plugin]");
			sender.sendMessage(" /CSK - 도움말");
			sender.sendMessage(" /CSK vi - 도움말");
			sender.sendMessage(" /CSK disable");
			sender.sendMessage(" /Csk cp <invmode> - 퀵슬롯이 구매가능한 쿠폰발급");
			break;

		default:
			sender.sendMessage("Please enter a number between 1 and 1");
		}
	}
	@Command("/csk cp <invmode>")
	public static void coupon(Player sender, final InventoryMode mode)
	{
		ItemStack item = new ItemStack(Material.PAPER);
		ItemMeta im = item.getItemMeta();
		im.setLore(new ArrayList<String>() {{add("§r§r§0coupon for "+mode.name());}});
		item.setItemMeta(im);
		sender.getInventory().addItem(item);
	}
	@Command("/CSkill ")
	public static void openSkillGUI(Player sender)
	{
		
	}
	
}
