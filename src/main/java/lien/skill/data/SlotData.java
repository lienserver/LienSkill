package lien.skill.data;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class SlotData implements ConfigurationSerializable{

    private Map<InventoryMode, ItemStack[]> inventories = new HashMap<SlotData.InventoryMode, ItemStack[]>();

    private InventoryMode current = null;

    public SlotData() {}
    public SlotData(Map<String,Object> serial)
    {
    	this.inventories = (Map<InventoryMode, ItemStack[]>) serial.get("inventories");
    }

    public void changeInventoryMode(InventoryMode mode)
    {
    	this.current = mode;
    }
    public ItemStack[] getInventoryMode(InventoryMode mode)
    {
        return inventories.get(mode);
    }

    public InventoryMode getCurrentMode()
    {
        return current;
    }
   
	public static SlotData deserialize(Map<String, Object> args)
	{
		return new SlotData(args);
	}
	public enum InventoryMode
	{
		Battle
	}
	public Map<String, Object> serialize()
	{
		return new HashMap<String, Object>(){{put("inventories",inventories);}};
	}
}
