package seia.fastclasscreator.v2.creator;

import seia.fastclasscreator.v2.component.IComponent;
import seia.fastclasscreator.v2.utils.ImportsHandler;

public interface ICreator<T extends IComponent>
{
	String getPackage();
	ImportsHandler getImports();
	T getComponent();
	void buildFile();
}
