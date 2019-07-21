package lien.skill.command.parameter;

import java.util.regex.Pattern;

import com.gnurung.gunucommandmodule.module.ParameterType;

import lien.skill.command.parameter.exception.BooleanFormatException;

public class SimpleBooleanType implements ParameterType
{
	final String name;
	String tru;
	String fal;
	public SimpleBooleanType(String name, String tru,String fal) 
	{
		this.name = name;
		this.tru = tru;
		this.fal = fal;
	}
	public SimpleBooleanType() {this("bool","t\\w*","f\\w*");}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getObject(Object arg0, String arg1) 
	{
		if(Pattern.matches(tru, arg1)) return true;
		else if(Pattern.matches(fal, arg1)) return false;
		else throw new BooleanFormatException(arg0, arg1);
	}

	@Override
	public String regex(Object arg0, String arg1) 
	{
		return "(("+tru+")|("+fal+"))";
	}

}
