import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Welcome extends JPanel
{
	private ArrayList<BankAccount> accts;
	
	public Welcome(ArrayList<BankAccount> a)
	{
		accts = a;
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		BufferedImage bank = null;
		try
		{
			bank = ImageIO.read(new File("bankjpg.jpg"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
		JLabel lblHome = new JLabel(new ImageIcon(bank));
		add(lblHome,gbc);
		gbc.gridy++;
		
		JLabel lblHomeText = new JLabel("Welcome to the greatest bank ever created homies.");
		add(lblHomeText,gbc);	
		gbc.gridy++;
		
	}
}
