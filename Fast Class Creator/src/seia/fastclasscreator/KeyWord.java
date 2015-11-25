package seia.fastclasscreator;

public class KeyWord 
{
	public static final String _package = "package";
	public static final String _class = "class";
	public static final String _interface = "interface";
	public static final String _enum = "enum";
	
	public static final String _extends = "extends";
	public static final String _implements = "implements";
		
	public static final String _abstract = "abstract";
	public static final String _static = "static";
	public static final String _final = "final";
	
	public static final String _public = "public";
	public static final String _private = "private";
	public static final String _protected = "protected";

	public static final String _object = "Object";
	public static final String _int = "int";
	public static final String _double = "double";
	public static final String _float = "float";
	public static final String _byte = "byte";
	public static final String _String = "String";
	public static final String _char = "char";
	
	public static final String _array = "[]";
	public static final String TAB = "	";
	public static final String ENTER = "\n";
	
	public static String asArray(String s)
	{
		return s + _array;
	}
	
	public static String addTabs(int howManyTabs)
	{
		String tmp = "";
		for(int i = 0; i < howManyTabs; i++)
			tmp += TAB;
		return tmp;
	}
	
	public static String addTabsInFrontOf(String s, int howManyTabs)
	{
		return addTabs(howManyTabs) + s;
	}
}
