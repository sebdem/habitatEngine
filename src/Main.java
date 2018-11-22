import habitat.ExampleGame;
import habitat.IHabitatGameLogic;
import habitat.IHabitatWindow;
import habitat.data.HColor;
import habitat.util.Colors;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {

    // The windowHandle handle
    private long windowHandle;
    public IHabitatWindow window;

    public IHabitatGameLogic game = new ExampleGame();

    public void run() {
        // TODO startup logging (also, print out lwjgl Version.getVersion() )

        init();
        loop();

        // Free the windowHandle callbacks and destroy the windowHandle
        glfwFreeCallbacks(windowHandle);
        glfwDestroyWindow(windowHandle);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current windowHandle hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the windowHandle will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the windowHandle will be resizable

        // Create the windowHandle
        windowHandle = glfwCreateWindow(816, 624, "Hello World!", NULL, NULL);
        if ( windowHandle == NULL )
            throw new RuntimeException("Failed to create the GLFW windowHandle");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(windowHandle, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });

        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the windowHandle size passed to glfwCreateWindow
            glfwGetWindowSize(windowHandle, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the windowHandle
            glfwSetWindowPos(
                    windowHandle,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(windowHandle);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the windowHandle visible
        glfwShowWindow(windowHandle);
        try {
            this.game.init();
        } catch (Exception e) {
            // TODO log initialization error
            e.printStackTrace();
        }
    }

    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Run the rendering loop until the user has attempted to close
        // the windowHandle or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(windowHandle) ) {
            render();
            // Poll for windowHandle events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    private void render() {

        // Set the clear color
        HColor bgcolor = Colors.BACKGROUND_COLOR();
        glClearColor(bgcolor.getV1(), bgcolor.getV2(), bgcolor.getV3(), 0.0f);

        float[] verts = {
                -0.5f,  0.5f,
                -0.5f, -0.5f,
                0.5f, -0.5f
        };

        int vao = glGenVertexArrays();
        glBindVertexArray(vao);

        int vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, verts, GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(0, 2, GL_FLOAT, (GL_FALSE != 0), 0, 0);
        GL20.glEnableVertexAttribArray(0);

        glDrawArrays(GL_TRIANGLES, 0, 3);

        this.game.render(windowHandle);

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

        glfwSwapBuffers(windowHandle); // swap the color buffers
    }

    public static void main(String[] args) {
        new Main().run();
    }

}