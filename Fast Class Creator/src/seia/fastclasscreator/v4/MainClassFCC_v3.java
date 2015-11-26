package seia.fastclasscreator.v4;

import java.util.ArrayList;

import seia.fastclasscreator.v4.component.Component;
import seia.fastclasscreator.v4.component.IComponent;

/**
 * Just for testing.
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public class MainClassFCC_v3 
{
	public static String PATH = "C:\\Users\\Krzysztof\\Desktop";
	
	public static void main(String[] args)
	{
		ComponentCreator.initializeNewJavaFile(PATH, "NazwaPliku");
		ComponentCreator.setPackage("seia.fastclasscreator.v3");
		ComponentCreator.setImportsAs(new ArrayList<String>());
		ComponentCreator.addImport(ComponentCreator.setNewImport("java.util.ArrayList"));
		ComponentCreator.createMainComponent(new String[]{"public", "abstract"}, "class");
		ComponentCreator.addWhatExtendsImplements("GoatBase", new String[]{"IGoatable"});
		ComponentCreator.setFileBodyAs(new ArrayList<String>());
		ComponentCreator.declareNewVariableWithoutInitialization(new String[]{"public"}, "int", "x");
		ComponentCreator.addToFileBody(ComponentCreator.addConstructor("public", 
				ComponentCreator.getCurrentFileName(),new String[]{}, new String[]{}));
		ComponentCreator.addSpaceLine();
		ComponentCreator.addToFileBody(ComponentCreator.addMethod(new String[]{"public"}, "int", "addXToX", 
				new String[]{"int x", "int x2"}, new String[]{"return x + x2;"}));
		ComponentCreator.addToFileBody(ComponentCreator.addMethod(new String[]{"public"}, "int", "getX", 
				new String[]{}, new String[]{"return x;"}));
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
								new String[]{"return jakiX;"}));
				ComponentCreator.addAdditionalComponent(comp);
			}
		}
		ComponentCreator.constructFile();
	}
}
