package seia.fastclasscreator.v3;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class ComponentCreator 
{
	private static String _fileName;
	private static String _package;
	private static File _file;
	private static List<String> _imports;
	private static List<String> _fileBody;
	private static String[] _mainComponentAccess;
	private static String _mainComponentType;
	
	public static String getCurrentFileName()
	{
		return _fileName;
	}
	
	public static String getCurrentPackage()
	{
		return _package;
	}
	
	public static File getCurrentFile()
	{
		return _file;
	}
	
	public static List<String> getCurrentImports()
	{
		return _imports;
	}
	
	public static List<String> getCurrentFileBody()
	{
		return _fileBody;
	}
	
	public static String[] getCurrentMainComponentAccess()
	{
		return _mainComponentAccess;
	}
	
	public static String getCurrentMainComponentType()
	{
		return _mainComponentType;
	}
	
	public static void initializeNewJavaFile(String path, String nazwaPliku) 
	{
		initializeNewFile(path, nazwaPliku, "java");
	}
	
	public static void initializeNewFile(String path, String nazwaPliku, String fileType) 
	{
		clearInfo();
		_file = new File(path + "\\" + nazwaPliku + "." + fileType);
		_fileName = nazwaPliku;
	}
	
	public static void setImportsAs(List<String> arrayList) 
	{
		_imports = arrayList;
	}

	public static String setPackage(String _packageName) 
	{
		_package = KeyWords._package + " " + _packageName + ";";
		return _package;
	}

	public static String addImport(String toImport) 
	{
		String imp = "import " + toImport + ";";
		_imports.add(imp);
		return imp;
	}

	public static void createMainComponent(String[] access, String type) 
	{
		_mainComponentAccess = access;
		_mainComponentType = type;
	}
	
	public static void setFileBodyAs(List<String> arrayList) 
	{
		_fileBody = arrayList;
	}

	public static String addConstructor(String accessibility, String[] constructorArgs,
			String[] constructorBody) 
	{
		String constructor = "";
		constructor += accessibility + " " + _fileName + "( ";
		for(int i = 0; i < constructorArgs.length - 1; i++)
			constructor += constructorArgs[i] + ", ";
		if(constructorArgs.length > 0)
			constructor += constructorArgs[constructorArgs.length - 1];
		constructor += ") ";
		constructor += KeyWords.FUNCTION_START;
		for(int i = 0; i < constructorBody.length; i++)
			constructor += constructorBody[i];
		constructor += KeyWords.FUNCTION_END;
		_fileBody.add(constructor);
		return constructor;
	}

	public static String addMethod(String[] methodAccess, String returnType, String methodName, 
			String[] methodArgs, String[] methodBody) 
	{
		String method = "";
		for(int i = 0; i < methodAccess.length; i++)
			method += methodAccess[i] + " ";
		method += returnType + " ";
		method += methodName + "(";
		for(int i = 0; i < methodArgs.length - 1; i++)
			method += methodArgs[i] + ", ";
		if(methodArgs.length > 0)
			method += methodArgs[methodArgs.length - 1];
		method += ")";
		method += KeyWords.FUNCTION_START;
		for(int i = 0; i < methodBody.length; i++)
			method += methodBody[i];
		method += KeyWords.FUNCTION_END;
		_fileBody.add(method);
		return method;
	}
	
	public static void addSpaceLine()
	{
		_fileBody.add("");
	}

	/**
	 * Final method that will construct the file on the Disk.
	 */
	public static void constructFile() 
	{
		try 
		{
			_file.createNewFile();
			PrintWriter pw = new PrintWriter(_file);
			pw.println(_package);
			pw.println();
			for(int i = 0; i < _imports.size(); i++)
				pw.println(_imports.get(i));
			pw.println();
			for(int i = 0; i < _mainComponentAccess.length; i++)
				pw.print(_mainComponentAccess[i] + " ");
			pw.print(_mainComponentType + " ");
			pw.print(_fileName + " ");
			pw.println();
			pw.println("{");
			for(int i = 0; i < _fileBody.size(); i++)
				pw.println(KeyWords.TAB + _fileBody.get(i));
			pw.println("}");
			pw.close();
			clearInfo();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void clearInfo()
	{
		_file = null;
		_fileName = "";
		_imports = null;
		_fileBody = null;
		_package = "";
		_mainComponentAccess = null;
		_mainComponentType = "";
	}
	
	
	/*
	 * ======================================================================================
	 *                                  Additional  Methods
	 * ======================================================================================
	 */
	
	
	public static String setCondition(String condition)
	{
		return "( " + condition + " )";
	}
	
	/**
	 * USE THIS ONLY FOR JAVA BUILD-IN TYPES <br>
	 * E.g. use: <br>
	 * declareNewVariable("int", "a", "100") <br>
	 * this will return: <br>
	 * "int a = 100;"
	 * @param type - e.g. int, float, Object, YourType
	 * @param variableName - a, b, goat
	 * @param value - 10, 56f, 67d, "asd", etc.
	 * @return
	 */
	public static String declareNewVariable(String type, String variableName, String value)
	{
		return type + " " + variableName + " = " + value + KeyWords.END_LINE;
	}
	
	public static String declareNewVariableWithoutInitialization(String type, String variableName)
	{
		return type + " " + variableName + ";";
	}
	
	public static String declareNewVariable(String[] access, String type, String variableName, String value)
	{
		String variable = "";
		for(int i = 0; i < access.length - 1; i++)
			variable += access[i] + ", ";
		if(access.length > 0)
			variable += access[access.length - 1] + " ";
		return variable + declareNewVariable(type, variableName, value);
	}
	
	public static String declareNewVariableWithoutInitialization(String[] access, String type, String variableName)
	{
		String variable = "";
		for(int i = 0; i < access.length - 1; i++)
			variable += access[i] + ", ";
		if(access.length > 0)
			variable += access[access.length - 1] + " ";
		return variable + declareNewVariableWithoutInitialization(type, variableName);
	}
	
	/**
	 * 
	 * @param type
	 * @param variableName
	 * @param params
	 * @return -> Type variableName = new Type(params);
	 */
	public static String declareNewObject(String type, String variableName, String[] params)
	{
		return declareNewVariable(type, variableName, createNewObject(type, params));
	}
	
	public static String declareNewObject(String[] access, String type, String variableName, String[] params)
	{
		String _object = "";
		for(int i = 0; i < access.length - 1; i++)
			_object += access[i] + ", ";
		if(access.length > 0)
			_object += access[access.length - 1] + " ";
		return _object + declareNewObject(type, variableName, params);
	}
	
	/**
	 * 
	 * @param type
	 * @param params
	 * @return -> new Type(params)
	 */
	public static String createNewObject(String type, String[] params)
	{
		String value = "new " + type + "(";
		for(int i = 0; i < params.length - 1; i++)
			value += params[i] + ", ";
		if(params.length > 0)
			value += params[params.length - 1];
		value += ")";
		return value;
	}
	
	/**
	 * if, while, for, etc.
	 * @param functionType
	 * @param condition
	 * @param functionBody
	 * @return
	 */
	public static String addFunction(String functionType, String condition, String functionBody)
	{
		String function = 
				KeyWords.TAB + functionType + "( " + condition + " )" +
				KeyWords.TAB + KeyWords.FUNCTION_START + 
				KeyWords.TAB + functionBody + 
				KeyWords.TAB + KeyWords.FUNCTION_END;
		return function;
	}
	
	public static String addFunction_IfElse(String condition, String functionBodyIf, String functionBodyElse)
	{
		String function = 
				KeyWords.TAB + KeyWords._if + "( " + condition + " )" +
				KeyWords.TAB + KeyWords.FUNCTION_START + 
				KeyWords.TAB + functionBodyIf + 
				KeyWords.TAB + KeyWords.FUNCTION_END +
				KeyWords.TAB + KeyWords._else + 
				KeyWords.TAB + KeyWords.FUNCTION_START + 
				KeyWords.TAB + functionBodyElse + 
				KeyWords.TAB + KeyWords.FUNCTION_END;
		return function;
	}
	
	public static String addFunction_IfElse_ShortVersion(String condition, String functionBodyIf, 
			String functionBodyElse)
	{
		String function = "(( " + condition + " ) ? ( " + functionBodyIf + " ) : ( " + functionBodyElse + " )) ";
		return function;
	}
}
