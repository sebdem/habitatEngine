package habitat;

import static org.lwjgl.opengl.GL11.*;

public class ExampleGame implements IHabitatGameLogic {
    @Override
    public void init() throws Exception {

    }

    @Override
    public void input(long windowHandle) {

    }

    @Override
    public void update(float interval) {

    }

    @Override
    public void render(long windowHandle) {
        glColor3f(1, 1, 1);
        glBegin(GL_LINES);
        glVertex2f(0, 0);
        glVertex2f(1, 1);
        glEnd();
        glColor3f(1, 0, 0);
        glBegin(GL_LINES);
        glVertex2f(0, 0);
        glVertex2f(-1, -1);
        glEnd();
    }
}
