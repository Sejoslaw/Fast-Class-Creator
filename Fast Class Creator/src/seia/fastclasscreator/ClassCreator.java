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
	
	public void createJavaFile(ObjectClass objectClass)
	{
	}
	
	public void compileJavaToClass(String path)
	{
	}
}
