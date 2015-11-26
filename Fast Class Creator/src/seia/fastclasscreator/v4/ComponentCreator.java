package seia.fastclasscreator.v4;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import seia.fastclasscreator.v4.component.IComponent;

public class ComponentCreator 
{
	private static String _fileName;
	private static String whatExtends;
	private static String _package;
	private static File _file;
	private static List<String> _imports;
	private static List<String> _fileBody;
	private static String[] _mainComponentAccess;
	private static String _mainComponentType;
	private static List<IComponent> _additionalComponents;
	
	public static String getCurrentFileName()
	{
		return _fileName;
	}
	
	public static String getCurrentExtends()
	{
		return whatExtends;
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
	
	public static List<IComponent> getAdditionalComponents()
	{
		return _additionalComponents;
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

	public static void addImport(String toImport) 
	{
		_imports.add(toImport);
	}
	
	public static String setNewImport(String newImport)
	{
		String imp = "import " + newImport + ";";
		return imp;
	}

	/**
	 * This method is used only for the Main Class name and class access.
	 * @param access
	 * @param type
	 */
	public static void createMainComponent(String[] access, String type) 
	{
		_mainComponentAccess = access;
		_mainComponentType = type;
	}
	
	public static void setAddtionalComponentsAs(List<IComponent> cl)
	{
		_additionalComponents = cl;
	}
	
	public static void addAdditionalComponent(IComponent component)
	{
		_additionalComponents.add(component);
	}
	
	public static void setFileBodyAs(List<String> arrayList) 
	{
		_fileBody = arrayList;
	}
	
	public static void addToFileBody(String whatToAdd)
	{
		_fileBody.add(whatToAdd);
	}

	public static String addConstructor(String accessibility, String constructorName, String[] constructorArgs,
			String[] constructorBody) 
	{
		String constructor = "";
		constructor += accessibility + " " + constructorName + "( ";
		for(int i = 0; i < constructorArgs.length - 1; i++)
			constructor += constructorArgs[i] + ", ";
		if(constructorArgs.length > 0)
			constructor += constructorArgs[constructorArgs.length - 1];
		constructor += ") ";
		constructor += KeyWords.FUNCTION_START;
		for(int i = 0; i < constructorBody.length; i++)
			constructor += constructorBody[i];
		constructor += KeyWords.FUNCTION_END;
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
		return method;
	}
	
	public static void addSpaceLine()
	{
		_fileBody.add("");
	}
	
	public static String addWhatExtendsImplements(String _extends, String[] _implements)
	{
		String s = " extends " + _extends + " ";
		if(_implements.length > 0)
		{
			s += "implements ";
			for(int i = 0; i < _implements.length - 1; i++)
				s += _implements[i] + ", ";
			s += _implements[_implements.length - 1];
		}
		whatExtends = s;
		return whatExtends;
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
			pw.print(_fileName + whatExtends);
			pw.println();
			pw.println("{");
			for(int i = 0; i < _fileBody.size(); i++)
				pw.println(KeyWords.TAB + _fileBody.get(i));
			for(int i = 0; i < _additionalComponents.size(); i++)
			{
				IComponent ic = _additionalComponents.get(i);
				for(int j = 0; j < ic.buildComponent().size(); j++)
					pw.println(KeyWords.TAB + ic.buildComponent().get(j));
			}
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
		whatExtends = "";
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
