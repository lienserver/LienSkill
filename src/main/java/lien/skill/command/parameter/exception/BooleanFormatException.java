package lien.skill.command.parameter.exception;

import org.bukkit.command.CommandSender;import com.gnurung.gunucommandmodule.Command;

public class BooleanFormatException extends IllegalArgumentException
{
	private final Object sender;
	public BooleanFormatException(Object sender,String s) 
	{
		super(s);
		this.sender = sender;
	}
	static BooleanFormatException forInputString(Object sender, String s) 
	{
        return new BooleanFormatException(sender,"For input string: \"" + s + "\"");
    }
	@Override
	public void printStackTrace()
	{
		if(sender instanceof CommandSender) 
			((CommandSender)sender).sendMessage("For input string: \"" + getMessage() + "\"");
		super.printStackTrace();
	}
}
