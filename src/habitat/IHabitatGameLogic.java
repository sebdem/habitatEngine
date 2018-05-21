package habitat;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;

public interface IHabitatGameLogic {
    void init() throws Exception;
    void input(int windowHandle);
    void update(float interval);
    void render(int windowHandle);
}
