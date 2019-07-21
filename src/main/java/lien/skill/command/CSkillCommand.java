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
			sender.sendMessage("§c[Skill Plugin - for admin]");
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
		sender.sendMessage("§c쿠폰이 지급되었습니다");
	}
	@Command("/cskill help <int>!")
	public static void openSkillGUI(Player sender, Integer page)
	{
		if(page == null) page = 1;
		switch(page)
		{
		case 1:
			sender.sendMessage("§c[Skill Plugin]");
			sender.sendMessage(" /Cskill create <스킬이름> <레벨제한> <노드제한> <특수,일반> - §7도움말");
			sender.sendMessage(" /Cskill set <데이터로저장할이름> - §7손에든 스킬북을 저장");
			sender.sendMessage(" /Cskill get <데이터로저장한이름> - §7스킬북을 불러옵니다");
			sender.sendMessage(" /Cskill list <page>");
			sender.sendMessage(" /Cskill setting <인벤토리모드> - §7스킬 설정창을 엽니다");
			sender.sendMessage(" /Cskill change <인벤토리모드> - §7해당 인벤토리모드로 전환합니다");
			break;

		default:
			sender.sendMessage("Please enter a number between 1 and 1");
		}
	}
	@Command("/cskill create <string> <int> <string> <skillbooktype>")
	public static void createSkillBook(Player sender, Integer page, String permission, boolean specialized)
	{

	}
}
