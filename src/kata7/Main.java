package kata7;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends JFrame {

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() throws IOException {
        WatchModel watchModel = new WatchModel();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {}
        WatchView watchView = new WatchView(img);
        WatchPresenter watchPresenter = new WatchPresenter(watchModel, watchView);
        this.init();
        this.add(watchView);
        this.setVisible(true);
    }
    
    private void init(){
        this.setTitle("Watch");
        this.setSize(400,400);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
