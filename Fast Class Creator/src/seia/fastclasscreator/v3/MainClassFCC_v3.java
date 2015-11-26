package seia.fastclasscreator.v3;

import java.util.ArrayList;

/**
 * Just for testing.
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public class MainClassFCC_v3 
{
	public static String PATH = "C:\\Users\\Krzysztof\\Desktop";
	
	public static void main(String[] args)
	{
		/*
		ComponentCreator.initializeNewJavaFile(PATH, "NazwaPliku");
		ComponentCreator.setPackage("seia.fastclasscreator.v3");
		ComponentCreator.setImportsAs(new ArrayList<String>());
		ComponentCreator.addImport("java.util.ArrayList");
		ComponentCreator.createMainComponent(new String[]{"public", "abstract"}, "class");
		ComponentCreator.setFileBodyAs(new ArrayList<String>());
		ComponentCreator.createConstructor("public", new String[]{}, new String[]{});
		ComponentCreator.addSpaceLine();
		ComponentCreator.addMethod(new String[]{"public"}, "int", "addXToX", new String[]{"int x", "int x2"}, 
				new String[]{"return x + x2;"});
		ComponentCreator.constructFile();
		*/
		
		ComponentCreator.initializeNewJavaFile(PATH, "NazwaPliku");
		ComponentCreator.setPackage("seia.fastclasscreator.v3");
		ComponentCreator.setImportsAs(new ArrayList<String>());
		ComponentCreator.addImport("java.util.ArrayList");
		ComponentCreator.createMainComponent(new String[]{"public", "abstract"}, "class");
		ComponentCreator.setFileBodyAs(new ArrayList<String>());
		ComponentCreator.declareNewVariableWithoutInitialization(new String[]{"public"}, "int", "x");
		ComponentCreator.addConstructor("public", new String[]{}, new String[]{});
		ComponentCreator.addSpaceLine();
		ComponentCreator.addMethod(new String[]{"public"}, "int", "addXToX", new String[]{"int x", "int x2"}, 
				new String[]{"return x + x2;"});
		ComponentCreator.addMethod(new String[]{"public"}, "int", "getX", new String[]{}, 
				new String[]{"return x;"});
		ComponentCreator.constructFile();
	}
}
