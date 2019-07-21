package lien.skill;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import com.gnurung.gunucommandmodule.module.CommandProcesser;

import lien.skill.command.CSkillCommand;
import lien.skill.command.parameter.InventoryModeType;
import lien.skill.data.SlotData;


public class CSKMain extends JavaPlugin {

    private static CSKMain csk = null;
    static {
        ConfigurationSerialization.registerClass(SlotData.class, "SlotData");
    }
    private CommandProcesser commandprocesser;
    
    @Override
    public void onEnable() 
    {
        csk = this;
        registerCommand();
    } 
    
    private void registerCommand()
    {
        commandprocesser = new CommandProcesser(CSKMain.class,CSkillCommand.class);
        commandprocesser.addParameter(new InventoryModeType());
    }

    @Override
    public void onDisable() {

    }

    public static CSKMain getPlugin()
    {
        return csk;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
    {
    	commandprocesser.onCommand(sender, label, args);
    	return super.onCommand(sender, command, label, args);
    }
}
