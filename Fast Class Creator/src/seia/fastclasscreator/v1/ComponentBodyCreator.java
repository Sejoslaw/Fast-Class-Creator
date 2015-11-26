package seia.fastclasscreator.v1;

import java.util.List;

/**
 * Always remember to "addToList". <br>
 * Nothing will be added automatically. <br>
 * It is up to you, what you want to add.
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public class ComponentBodyCreator 
{
	public List<String> fileLines;

	public ComponentBodyCreator(List<String> list)
	{
		this.fileLines = list;
	}
	
	public void clear()
	{
		fileLines.clear();
	}
	
	public void addToList(String whatToAdd)
	{
		fileLines.add(whatToAdd);
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
	public String declareNewVariable(String type, String variableName, String value)
	{
		return type + " " + variableName + " = " + value + KeyWords.END_LINE;
	}
	
	public String declareNewVariable(String[] access, String type, String variableName, String value)
	{
		String variable = "";
		for(int i = 0; i < access.length - 1; i++)
			variable += access[i] + ", ";
		if(access.length > 0)
			variable += access[access.length - 1] + " ";
		return variable + declareNewVariable(type, variableName, value);
	}
	
	/**
	 * 
	 * @param type
	 * @param variableName
	 * @param params
	 * @return -> Type variableName = new Type(params);
	 */
	public String declareNewObject(String type, String variableName, String[] params)
	{
		return declareNewVariable(type, variableName, createNewObject(type, params));
	}
	
	public String declareNewObject(String[] access, String type, String variableName, String[] params)
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
	public String createNewObject(String type, String[] params)
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
	public String buildFunction(String functionType, String condition, String functionBody)
	{
		String function = 
				KeyWords.TAB + functionType + "( " + condition + " )" +
				KeyWords.TAB + KeyWords.FUNCTION_START + 
				KeyWords.TAB + functionBody + 
				KeyWords.TAB + KeyWords.FUNCTION_END;
		return function;
	}
	
	public String buildFunction_IfElse(String condition, String functionBodyIf, String functionBodyElse)
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
	
	public String buildFunction_IfElse_ShortVersion(String condition, String functionBodyIf, String functionBodyElse)
	{
		String function = "(( " + condition + " ) ? ( " + functionBodyIf + " ) : ( " + functionBodyElse + " )) ";
		return function;
	}
	
	/**
	 *  getSomething, setAnything, etc.
	 * @param methodAccess
	 * @param returnType
	 * @param methodName
	 * @param methodArgs
	 * @param methodBody
	 * @return
	 */
	public String buildMethod(String[] methodAccess, String returnType, String methodName, String[] methodArgs, 
			String[] methodBody)
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
	
	public String buildConstructor(String type, String constructorName, String[] constructorArgs, 
			String[] constructorBody)
	{
		String constructor = "";
		constructor += KeyWords.TAB + type + " " + constructorName + "( ";
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

	public String setCondition(String condition)
	{
		return "( " + condition + " )";
	}
	
	/**
	 * @param imports - This is just to tell the system which imports should we use while creating the file.
	 * @return
	 */
	public FileCreator createJavaFile(String _package, String[] componentAccess, String componentType, String componentName, List<String> imports)
	{
		return new FileCreator(_package, componentAccess, componentType, componentName, fileLines, new ImportHandler(imports), this);
	}
	
	public FileCreator createJavaFile(String _package, String[] componentAccess, String componentType, String componentName, ImportHandler ih)
	{
		return createJavaFile(_package, componentAccess, componentType, componentName, ih.importsList);
	}
	
	public String addPart(String part)
	{
		return part + " ";
	}
}