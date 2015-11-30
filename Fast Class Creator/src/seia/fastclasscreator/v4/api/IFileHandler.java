package seia.fastclasscreator.v4.api;

import java.util.List;

/**
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public interface IFileHandler 
{
	void addFile(IFile file);
	void deleteFile(IFile file);
	boolean isFileOnList(IFile file);
	void clearFileList();
	List<IFile> getFiles();
}
