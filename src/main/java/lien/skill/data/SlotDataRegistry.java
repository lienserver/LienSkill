package lien.skill.data;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import lien.skill.CSKMain;

public class SlotDataRegistry 
{
	Map<UUID, SlotData> slotdata = new HashMap<UUID, SlotData>();
	public SlotData getPlayerData(Player p)
	{
		return getPlayerData(p.getUniqueId());
	}
	public SlotData getPlayerData(UUID p)
	{
		SlotData data = slotdata.get(p);
		return data == null ? loadData(p) : data;
	}
	public SlotData loadData(UUID p)
	{
		File file = new File(CSKMain.getPlugin().getDataFolder(),"userdata/"+p+".yml");
		SlotData data;
		if(file.exists())
			data = (SlotData) YamlConfiguration.loadConfiguration(file).get("slotdata",new SlotData());
		else
			data = new SlotData();
		slotdata.put(p, data);
		return data;
	}

}
