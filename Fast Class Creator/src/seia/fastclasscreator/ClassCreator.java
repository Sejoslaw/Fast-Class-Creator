package seia.fastclasscreator;

import java.util.ArrayList;
import java.util.List;

public class ClassCreator 
{
	public List<String> list = new ArrayList<String>();
	public static final ClassCreator INSTANCE = new ClassCreator();
	
	private ClassCreator(){}
	
	public void clear()
	{
		list.clear();
	}
	
	public void addToList(String whatToAdd)
	{
		list.add(whatToAdd);
	}
	
	/**
	 * USE THIS ONLY FOR JAVA BUILD-IN TYPES <br>
	 * E.g. use: <br>
	 * declareValue("int", "a", "100") <br>
	 * this will return: <br>
	 * "int a = 100;"
	 * @param type - e.g. int, float, Object, YourType
	 * @param variableName - a, b, goat
	 * @param value - 10, 56f, 67d, "asd", etc.
	 * @return
	 */
	public String declareValue(String type, String variableName, String value)
	{
		return type + " " + variableName + " = " + value + KeyWords.END_LINE;
	}
	
	public String declareNewObject(String type, String variableName, String[] params)
	{
		return declareValue(type, variableName, createNewObject(type, params));
	}
	
	public String createNewObject(String type, String[] params)
	{
		String value = "new " + type + "(";
		for(int i = 0; i < params.length - 1; i++)
			value += params[i] + ", ";
		value += params[params.length - 1];
		value += ")";
		return value;
	}
	
	public String buildFunction_If(String functionBody)
	{
		String function = 
				KeyWords._if + 
				KeyWords.FUNCTION_START + 
				functionBody + 
				KeyWords.FUNCTION_END;
		return function;
	}
	
	public void createJavaFile(ObjectClass objectClass)
	{
	}
	
	public void compileJavaToClass(String path)
	{
	}
}
