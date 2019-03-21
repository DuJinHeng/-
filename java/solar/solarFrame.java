package solar;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class solarFrame	extends javax.swing.JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image backGround=GameUtil.getImage("images/bg.jpg");
	
	Star sun=new Star("images/sun.jpg", backGround.getWidth(null)/2, backGround.getHeight(null)/2);
	Star mercury=new Star("images/Mercury.jpg", 140, 70, 0.05, sun);//ˮ��
	Star venus=new Star("images/Venus.jpg",200,120,0.09,sun);//����
	Star earth=new Star("images/Earth.jpg", 290, 170,0.16,sun);
	Star mars=new Star("images/Mars.jpg", 350, 220,0.22,sun);//����
	Star jupiter=new Star("images/jupiter.jpg",490,300,0.3,sun);//ľ��
	Star saturn=new Star("images/Saturn.jpg", 550, 400, 0.42, sun);//����
	Star uranus=new Star("images/Uranus.jpg", 680, 520,0.53,sun);////������
	Star neptune=new Star("images/Neptune.jpg", 800, 600, 0.66, sun);//������
	Star moon=new Star("images/moon.jpg", 30, 30,0.1,earth);
	
	class PaintThread extends Thread{//�ػ��߳�

		@Override
		public void run()		{
			while(true) {
				repaint();
				try				{
					Thread.sleep(100);
				} catch (InterruptedException e)				{
					e.printStackTrace();
				}
			}
		}		
	}
	
	public void launchFrame() {//���������С
		setSize(backGround.getWidth(null), backGround.getWidth(null));//���ô��ڴ�С
		setLocation(200, 200);//����λ��
		setVisible(true);//�����������Ϊtrue Ĭ��Ϊfalse
		new PaintThread().start();//�����߳�
		
		addWindowListener(new WindowAdapter() {//��ӹرհ�ť��Ϣ
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});
	}
	
	@Override
	public void paint(Graphics g)	{//�����ػ溯��
		g.drawImage(backGround, 0,0, null);
		sun.draw(g);
		jupiter.draw(g);
		mars.draw(g);
		mercury.draw(g);
		neptune.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		venus.draw(g);
		earth.draw(g);
		moon.draw(g);
	}

	public static void main(String[] args)	{
		solarFrame s=new solarFrame();
		s.setResizable(false);//���ɵ��ڴ�С
		s.launchFrame();
	}
}
