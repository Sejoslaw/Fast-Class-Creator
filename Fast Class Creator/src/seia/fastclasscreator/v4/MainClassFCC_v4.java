package seia.fastclasscreator.v4;

import java.util.ArrayList;

import seia.fastclasscreator.v4.api.IComponent;
import seia.fastclasscreator.v4.api.IFile;
import seia.fastclasscreator.v4.component.Component;
import seia.fastclasscreator.v4.file.FileHandler;

/**
 * Just for testing.
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public class MainClassFCC_v4 
{
	//public static String PATH = "C:\\Users\\Krzysztof\\Desktop";
	public static String PATH = "C:\\Users\\Krzysztof\\git\\FastClassCreator\\" +
						 	    "Fast Class Creator\\src\\seia\\fastclasscreator\\v4\\test";
	
	public static void main(String[] args)
	{
		ComponentCreator.initializeNewJavaFile(PATH, "Test");
		ComponentCreator.setFileHandler(new FileHandler(new ArrayList<IFile>()));
		ComponentCreator.setPackage("seia.fastclasscreator.v4.test");
		ComponentCreator.setImportsAs(new ArrayList<String>());
		ComponentCreator.addImport(ComponentCreator.setNewImport("java.util.ArrayList"));
		ComponentCreator.createMainComponent(new String[]{"public"}, "class");
		//ComponentCreator.addWhatExtendsImplements("GoatBase", new String[]{"IGoatable"});
		ComponentCreator.setFileBodyAs(new ArrayList<String>());
		ComponentCreator.declareNewVariableWithoutInitialization(new String[]{"public"}, "int", "x");
		ComponentCreator.addToFileBody(ComponentCreator.addConstructor("public", 
				ComponentCreator.getCurrentFileName(),new String[]{}, new String[]{}));
		ComponentCreator.addSpaceLine();
		ComponentCreator.addToFileBody(ComponentCreator.addMethod(new String[]{"public"}, "int", "addXToX", 
				new String[]{"int x", "int x2"}, new String[]{"return x + x2;"}));
		ComponentCreator.addToFileBody(ComponentCreator.addMethod(new String[]{"public"}, "int", "getX", 
				new String[]{}, new String[]{"return 10;"}));
		{
			ComponentCreator.setAddtionalComponentsAs(new ArrayList<IComponent>());
			{
				Component comp = new Component(new String[]{}, "class", "Klasa1", new ArrayList<String>());
				comp.addToComponentBody(ComponentCreator.
						declareNewVariableWithoutInitialization(new String[]{"public"}, "int", "jakisX"));
				comp.addToComponentBody(ComponentCreator.
						addConstructor("public", comp.getComponentName(), 
								new String[]{"int x"}, new String[]{"jakisX = x;"}));
				comp.addToComponentBody(ComponentCreator.
						addMethod(new String[]{"public"}, "int", "getX", new String[]{}, 
								new String[]{"return jakisX;"}));
				ComponentCreator.addAdditionalComponent(comp);
			}
		}
		ComponentCreator.constructFile();
	}
}
