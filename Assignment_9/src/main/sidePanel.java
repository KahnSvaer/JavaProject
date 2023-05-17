package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class sidePanel extends RoundJPanel {	
	
	
}
class RoundJPanel extends JPanel implements ActionListener {
    private Shape shape;
    
    JButton loginButton = new RoundJButton("Login");
    JTextField userIDField = new RoundJTextField(0);
	JPasswordField userPasswordField = new RoundJPasswordField(0);
	JLabel userIDLabel = new JLabel("User ID");
	JLabel userPasswordLabel = new JLabel("Password");
	JLabel messageLabel = new JLabel("");
	BufferedImage icon;
	Boolean verified;
    public RoundJPanel() {
    	
        super();
        importUserIcon();
        setLayout(null);
        setOpaque(false); // As suggested by @AVD in comment.
        setBackground(new Color(0,0,0,190));
        setPanelSize();
        setComponentsPreference();
        addComponents();
        
        
    }
    private void setComponentsPreference() {
		userIDField.setBounds( (Panel.screenWidth/3-Panel.border_x)/2 -150 ,(Panel.screenHeight-(2*Panel.border_y))/2+40, 300, 40);
		userIDField.setBackground(new Color(255,255,102,120));
		userIDField.setForeground(Color.WHITE);
		userIDField.setFont(new Font(null,Font.PLAIN,19));
		
		
		userPasswordField.setBounds( (Panel.screenWidth/3-Panel.border_x)/2 -150 ,(Panel.screenHeight-(2*Panel.border_y))/2+120, 300, 40);
		userPasswordField.setBackground(new Color(255,255,102,120));
		userPasswordField.setForeground(Color.WHITE);
		userPasswordField.setFont(new Font(null,Font.PLAIN,19));
		
		userIDLabel.setFont(new Font(null,Font.BOLD,25));
		userIDLabel.setForeground(Color.WHITE);
		userPasswordLabel.setFont(new Font(null,Font.BOLD,25));
		userPasswordLabel.setForeground(Color.WHITE);
		messageLabel.setFont(new Font(null,Font.BOLD,25));
		messageLabel.setForeground(new Color(255,222,62,255));
		
		
		
		messageLabel.setBounds((Panel.screenWidth/3-Panel.border_x)/2 -170 ,(Panel.screenHeight-(2*Panel.border_y))/2+210,340,100);
		userIDLabel.setBounds((Panel.screenWidth/3-Panel.border_x)/2 -150 ,(Panel.screenHeight-(2*Panel.border_y))/2-30,200,100);
		userPasswordLabel.setBounds((Panel.screenWidth/3-Panel.border_x)/2 -150 ,(Panel.screenHeight-(2*Panel.border_y))/2+50,200,100);
		
	
		loginButton.setBounds( (Panel.screenWidth/3-Panel.border_x)/2 -150 ,(Panel.screenHeight-(2*Panel.border_y))/2+ 170, 300, 40);
		loginButton.setBackground(new Color(255,255,102));
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
	}
	private void addComponents() {
		add(userIDField);
		add(userPasswordField);
		add(userIDLabel);
		add(userPasswordLabel);
		add(loginButton);
		add(messageLabel);
		
	}
	public class RoundJTextField extends JTextField {
	    private Shape shape;
	    public RoundJTextField(int size) {
	        super(size);
	        setOpaque(false); // As suggested by @AVD in comment.
	        
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(getForeground());
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         }
	         return shape.contains(x, y);
	    }
	    
	    
	 }
	public class RoundJButton extends JButton implements ButtonModel {
	    private Shape shape;
	    public RoundJButton(String txt) {
	        super(txt);
	        setOpaque(false); // As suggested by @AVD in comment.
	        setContentAreaFilled(false);
	        getModel().addChangeListener(new ChangeListener() {

	            @Override
	            public void stateChanged(ChangeEvent e) {
	                ButtonModel model = (ButtonModel) e.getSource();

	                if (model.isRollover()) {
	                    setBackground(new Color(255,255,102).brighter());
	                } else {
	                    setBackground(new Color(255,255,102));
	                }
	            }

				
	        });
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(getForeground());
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         }
	         return shape.contains(x, y);
	    }
		@Override
		public boolean isArmed() {
			return false;
		}
		
		@Override
		public boolean isRollover() {
			return false;
		}
		@Override
		public void setArmed(boolean b) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setPressed(boolean b) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setRollover(boolean b) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setGroup(ButtonGroup group) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean isPressed() {
			// TODO Auto-generated method stub
			return false;
		}
	    
	    
	 }
	public class RoundJPasswordField extends JPasswordField {
	    private Shape shape;
	    public RoundJPasswordField(int size) {
	        super(size);
	        setOpaque(false); // As suggested by @AVD in comment.
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(getForeground());
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         }
	         return shape.contains(x, y);
	    }
    }
	
	private void importUserIcon() {
		InputStream is = getClass().getResourceAsStream("/user.png"); 
		try {
			icon = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	private void setPanelSize() {
		Dimension size = new Dimension(Panel.screenWidth/3-Panel.border_x,Panel.screenHeight-(2*Panel.border_y));
		setPreferredSize(size);
		
	}
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         g.drawImage(icon,(Panel.screenWidth/3-Panel.border_x)/2 -128 ,40,256,256,null);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         }
         return shape.contains(x, y);
    }
    public Boolean check(String name,String pass, String filePath) {
    	File file = new File(filePath);
    	String st;
        BufferedReader br = null;
        try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			
        	st = br.readLine();
			while (st != null) {
				String[] parts = st.split(",");
				String user = parts[0].trim();
				String password = parts[1].trim();
				if(user.equals(name)&password.equals(pass)) {
					return true;
				}
			    st = br.readLine();
			}
			
        }catch (IOException e) {
				e.printStackTrace();
			}
		return false;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			String UserID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			String filepath ="LoginDetails/LoginDetails.csv";
			verified = check(UserID,password,filepath);
			if(!verified) {
				messageLabel.setText("Invalid Login ID Or Password");
			}
		}
		
		
	}
    
    
 }