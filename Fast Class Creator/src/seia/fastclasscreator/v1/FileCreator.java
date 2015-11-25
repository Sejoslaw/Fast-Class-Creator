package seia.fastclasscreator.v1;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import seia.fastclasscreator.v2.utils.ImportsHandler;

/**
 * ObjectClass is used to create final class look.
 * Here are added packages, class itself, etc.
 * And in the end this class will create the java file and the file.
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public class FileCreator 
{
	public String _package;
	public String[] componentAccess;
	/** class, interface, enum, etc. */
	public String componentType;
	public String componentName;
	public ImportsHandler importsHandler;
	public List<String> classBody;
	public ComponentBodyCreator cbc;
	
	public FileCreator(String _package, String[] componentAccess, String componentType, String componentName, 
			List<String> list, ImportsHandler ih, ComponentBodyCreator cbc) 
	{
		this._package = _package;
		this.componentAccess = componentAccess;
		this.componentType = componentType;
		this.componentName = componentName;
		classBody = list;
		importsHandler = ih;
		this.cbc = cbc;
	}
	
	/**
	 * Final method to create file on disk. <br>
	 * E.g.: <br>
	 * "C:\Users\"
	 * @param whereToAdd - path
	 * @return
	 */
	public File create(String whereToAdd)
	{
		File file = new File(whereToAdd + componentName + ".java");
		try 
		{
			PrintWriter pw = new PrintWriter(file);
			pw.println(_package);
			pw.println();
			for(int i = 0; i < importsHandler.importsList.size(); i++)
				pw.println(importsHandler.importsList.get(i));
			pw.println();
			for(int i = 0; i < componentAccess.length; i++)
				pw.print(componentAccess[i] + " ");
			pw.print(componentType + " ");
			pw.print(componentName + " ");
			pw.println("{");
			for(int i = 0; i < cbc.fileLines.size(); i++)
				pw.println(KeyWords.TAB + cbc.fileLines.get(i));
			pw.println("}");
			pw.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return file;
	}
	
	public void compileJavaToClass(String pathToFile)
	{
	}
}
