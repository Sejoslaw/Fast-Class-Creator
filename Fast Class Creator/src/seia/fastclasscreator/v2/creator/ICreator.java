package seia.fastclasscreator.v2.creator;

import seia.fastclasscreator.v2.component.IComponent;
import seia.fastclasscreator.v2.utils.ImportHandler;

public interface ICreator<T extends IComponent>
{
	String getPackage();
	ImportHandler getImports();
	T getComponent();
	void buildFile();
}
