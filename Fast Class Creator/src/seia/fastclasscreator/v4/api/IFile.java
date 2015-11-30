package seia.fastclasscreator.v4.api;

import java.io.File;
import java.util.List;

/**
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public interface IFile
{
	String getFileName();
	String getWhatExtends();
	String getPackage();
	File getFile();
	List<String> getImports();
	List<String> getFileBody();
	String[] getMainComponentAccess();
	String getMainComponentType();
	List<IComponent> getAdditionalComponents();
}
