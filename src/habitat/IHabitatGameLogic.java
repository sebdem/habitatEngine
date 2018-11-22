package habitat;

public interface IHabitatGameLogic {
    void init() throws Exception;
    void input(long windowHandle);
    void update(float interval);
    void render(long windowHandle);
}
