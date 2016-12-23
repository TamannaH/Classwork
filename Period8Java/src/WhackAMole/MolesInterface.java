package WhackAMole;

import guiPackage.components.Action;
import guiPackage.components.Clickable;

public interface MolesInterface extends Clickable {

	int getAppearanceTime();

	void setAppearanceTime(int i);

	void setAction(Action action);

}
