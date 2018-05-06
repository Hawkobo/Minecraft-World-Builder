import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;

public class Basic3D 
{
    private Camera fp = new Camera(0f,0f,0f);
    private DisplayMode displayMode;
    public void start() 
    {
    try {
        createWindow();
        initGL();
        fp.gameLoop();//render();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    private void createWindow() throws Exception
    {
        Display.setFullscreen(false);
        DisplayMode d[] =
        Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
        if (d[i].getWidth() == 640
        && d[i].getHeight() == 480
        && d[i].getBitsPerPixel() == 32) {
        displayMode = d[i];
        break;
        }
        }
        Display.setDisplayMode(displayMode);
        Display.setTitle("THE NEW MINECRAFT");
        Display.create();
    }
    
    private void initGL() 
    {
        glEnable(GL_TEXTURE_2D);
        glEnableClientState(GL_TEXTURE_COORD_ARRAY);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(100.0f, (float)displayMode.getWidth()/(float)
        displayMode.getHeight(), 0.1f, 300.0f);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    }
}


