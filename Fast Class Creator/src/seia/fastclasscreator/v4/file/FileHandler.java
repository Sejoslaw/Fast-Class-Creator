package seia.fastclasscreator.v4.file;

import java.util.ArrayList;
import java.util.List;

import seia.fastclasscreator.v4.api.IFile;
import seia.fastclasscreator.v4.api.IFileHandler;

public class FileHandler implements IFileHandler
{
	public List<IFile> fileList;
	
	public FileHandler()
	{
		fileList = new ArrayList<IFile>();
	}
	
	public FileHandler(List<IFile> list)
	{
		fileList = list;
	}

	@Override
	public void addFile(IFile file) 
	{
		fileList.add(file);
	}
	
	@Override
	public void deleteFile(IFile file)
	{
		int index = -1;
		for(int i = 0; i < fileList.size(); i++)
			if(fileList.get(i).getFileName().toLowerCase().equals(file.getFileName().toLowerCase()))
				index = i;
		try
		{
			fileList.remove(index);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isFileOnList(IFile file)
	{
		boolean is = false;
		for(int i = 0; i < fileList.size(); i++)
			if(fileList.get(i).getFileName().toLowerCase().equals(file.getFileName().toLowerCase()))
				is = true;
		return is;
	}
	
	@Override
	public void clearFileList()
	{
		fileList.clear();
	}

	@Override
	public List<IFile> getFiles() 
	{
		return fileList;
	}
}
