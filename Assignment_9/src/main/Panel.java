package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.Random;

public class Panel extends JPanel implements ActionListener{
	private BufferedImage backGround;
	static final int screenHeight = 768;
	static final int screenWidth =1366;
	static int border_x = 10;
	static int border_y = 10;
	JLabel music =  new JLabel("MUSIC FOR");
	JLabel animatedLabel = new JLabel("");
	Timer t ;
	double counter = 0;
	
	Random randomObj = new Random();
	int x = randomObj.nextInt((5 - 1)) + 2;
	public Panel(sidePanel d) {
		importBG(x);
		setPanelSize();
		setLayout(null);
		setComponentsParameter(d);
		addComponents(d);
		t = new Timer(300,this);
		t.start();
	}
	private void addComponents(sidePanel d) {
		add(d);
		add(music);
		add(animatedLabel);
	}
	private void setComponentsParameter(sidePanel d) {
		try {
		    music.setFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/LoverBrooks.otf").openStream()).deriveFont(Font.BOLD, 100f));
		    music.setBounds(screenWidth/3 +105,0,340,150);
			music.setForeground(Color.white);
			
			animatedLabel.setFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/LoverBrooks.otf").openStream()).deriveFont(Font.BOLD, 100f));
			animatedLabel.setForeground(new Color(255,222,62,255));
			animatedLabel.setBounds(screenWidth/3 +445,0,500,150);
		    } catch(IOException | FontFormatException e){
		    }
		d.setBounds(border_x, border_y,screenWidth/3-border_x, screenHeight-(2*border_y));
		
	}
	private void setPanelSize() {
		Dimension size = new Dimension(screenWidth,screenHeight);
		setPreferredSize(size);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backGround,0,0,screenWidth,screenHeight,null);
		
		g.setColor(new Color(10,10,10,190));
		int width = screenWidth/5 ;
		g.fillRoundRect(screenWidth*4/5-2*border_x,screenHeight*3/4,width,screenHeight/4-border_y,30,30);
		g.fillRoundRect(screenWidth*4/5-4*border_x - width,screenHeight*3/4,width,screenHeight/4-border_y,30,30);
		g.fillRoundRect(screenWidth*4/5-6*border_x - 2*width,screenHeight*3/4,width,screenHeight/4-border_y,30,30);
	}
	private void importBG(int number) {
		InputStream is = getClass().getResourceAsStream("/BG"+5+".jpg"); // TO be decided later
		try {
			backGround = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(counter<=1) {
			animatedLabel.setText(" |");
		}else if(1<counter&counter<=3) {
			animatedLabel.setText("");
		}else if(3<counter&counter<=5) {
			animatedLabel.setText(" |");
		}else if(5<counter&counter<=7) {
			animatedLabel.setText(" E|");
		}else if(7<counter&counter<=9) {
			animatedLabel.setText(" EV|");
		}else if(9<counter&counter<=11) {
			animatedLabel.setText(" EVE|");
		}else if(11<counter&counter<=13) {
			animatedLabel.setText(" EVER|");
		}else if(13<counter&counter<15) {
			animatedLabel.setText(" EVER|");
		}else if(15<=counter&counter<=17) {
			animatedLabel.setText(" EVERY|");
		}else if(17<counter&counter<=19) {
			animatedLabel.setText(" EVERYO|");
		}else if(19<counter&counter<=21) {
			animatedLabel.setText(" EVERYON|");
		}else if(21<counter&counter<=23) {
			animatedLabel.setText(" EVERYONE|");
		}else if(23<counter&counter<=27){
			animatedLabel.setText(" EVERYONE.");
			if(counter==27) {
				counter = -1;
			}
			
		}
		counter++;
		
		
	}
	
}
