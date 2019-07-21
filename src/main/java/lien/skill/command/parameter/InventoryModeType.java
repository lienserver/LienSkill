package lien.skill.command.parameter;

import com.gnurung.gunucommandmodule.module.ParameterType;

import lien.skill.data.SlotData.InventoryMode;

public class InventoryModeType implements ParameterType
{
	public String getName() {
		return "invmode";
	}

	public Object getObject(Object sender, String s)
	{
		return InventoryMode.valueOf(s);
	}

	public String regex(Object sender, String s)
	{
		if(InventoryMode.valueOf(s) != null) return "["+s+"]";
		else return "($^)";
	}

}
