package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Drawtools {

	//From http://arc.hatenablog.com/entry/20090504/java_abstract_frame
    /** 単なるウィンドウ */
    public abstract class AbstractFrame extends JFrame {
    	private static final long serialVersionUID = 1L;
    	private JComponent component;

    	/** 初期化処理 */
    	public void initialize(int width, int height) {

    		// パネルの初期化
    		component = new MainComponent();
    		getContentPane().add(component);

    		// メインウィンドウの初期化
    		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    		setResizable(false);
    		setVisible(true);
    		final Insets insets = getInsets();
    		setSize(width+insets.left+insets.right, height+insets.top+insets.bottom);
    	}

    	/** 終了処理 */
    	public void dispose() {
    		System.exit(0);
    	}

    	/** 描画処理 */
    	public abstract void paint2D(Graphics2D g);

    	/** 再描画の要請 */
    	public void requestRepaint() {
    		if (component != null)
    			component.repaint();
    	}

    	/** 描画領域 */
    	class MainComponent extends JComponent {
    		private static final long serialVersionUID = 1L;
    		public void paint(Graphics g) {
    			paint2D((Graphics2D) g);
    		}
    		public void update(Graphics g) { paint(g); }
    	}
    }

    //From http://arc.hatenablog.com/entry/20090602/1243945219
    /** 画素値を直接操作して描画するウィンドウ */
    public abstract class AbstractRawFrame extends AbstractFrame {
    	private BufferedImage image;
    	private int[] data;

    	@Override
    	public void initialize(int width, int height) {
    		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    		data = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    		super.initialize(width, height);
    	}

    	@Override
    	public void paint2D(Graphics2D g) {
    		updatePixels(data);
    		g.drawImage(image, 0, 0, null);
    	}

    	/** 画素配列に対する操作 */
    	public abstract void updatePixels(int[] pixels);

    }


}
