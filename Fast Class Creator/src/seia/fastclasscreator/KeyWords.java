package seia.fastclasscreator;

public class KeyWords
{
	public static final String _package = "package";
	public static final String _class = "class";
	public static final String _interface = "interface";
	public static final String _enum = "enum";
	public static final String _new = "new";
	public static final String _super = "super";
	public static final String _this = "this";
	
	public static final String _extends = "extends";
	public static final String _implements = "implements";
	public static final String _import = "import";
	public static final String _instanceof = "instanceof";
		
	public static final String _abstract = "abstract";
	public static final String _static = "static";
	public static final String _final = "final";
	public static final String _const = "const";
	public static final String _finally = "finally";
	public static final String _native = "native";
	public static final String _synchronized = "synchronized";
	public static final String _transient = "transient";
	public static final String _volatile = "volatile";
	
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
	public static final String _boolean = "boolean";
	public static final String _long = "long";
	public static final String _short = "short";
	public static final String _void = "void";

	public static final String _assert = "assert";
	public static final String _break = "break";
	public static final String _case = "case";
	public static final String _catch = "catch";
	public static final String _continue = "continue";
	public static final String _default = "default";
	public static final String _do = "do";
	public static final String _else = "else";
	public static final String _for = "for";
	public static final String _goto = "goto";
	public static final String _if = "if";
	public static final String _return = "return";
	public static final String _switch = "switch";
	public static final String _throw = "throw";
	public static final String _throws = "throws";
	public static final String _try = "try";
	public static final String _while = "while";
	
	public static final String _array = "[]";
	public static final String TAB = "	";
	public static final String ENTER = "\n";
	
	public static final String FUNCTION_START = "{";
	public static final String FUNCTION_END = "}";
	public static final String END_LINE = ";";
	
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
