import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankJPanel extends JPanel
{
	private ArrayList<BankAccount> accts;
	
	private double OVER_DRAFT_FEE = 15; 
	private double rate = 0.0025; 
	private double TRANSACTION_FEE = 1.5; 
	private double MIN_BAL = 300;
	private double MIN_BAL_FEE = 10;
	private int FREE_TRANSACTION = 10;
	
	public BankJPanel(ArrayList<BankAccount> a)
	{
		accts = a;
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel newBankHeader = new JLabel("What would you like the name of the account to be?");
		add(newBankHeader,gbc);
		gbc.gridy++;
		JTextField name = new JTextField();
		name.setPreferredSize(new Dimension(180,30));
		add(name,gbc);
		gbc.gridy++;
		
		JLabel newBalance = new JLabel("How much money would you like to deposit to open the account?");
		add(newBalance, gbc);
		gbc.gridy++;
		JTextField balance = new JTextField();
		balance.setPreferredSize(new Dimension(100,30));
		add(balance,gbc);
		gbc.gridy++;
		
		JLabel newAcc = new JLabel("Would you like to make a checking or savings account?");
		add(newAcc, gbc);
		gbc.gridy++;
		gbc.gridx--;
		JButton checking = new JButton("Checking");
		add(checking, gbc);
		gbc.gridx+=2;
		checking.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						try {
							String stringBal = balance.getText();
							double bal = Double.parseDouble(stringBal);
							BankAccount newChecking = new CheckingAccount(name.getText(),bal,OVER_DRAFT_FEE,TRANSACTION_FEE,FREE_TRANSACTION);
							accts.add(newChecking);
							name.setText("");balance.setText("");
							JOptionPane.showMessageDialog(null, "Account created: " + newChecking.toString());
						}catch(IllegalArgumentException e){
							JOptionPane.showMessageDialog(null, "Please enter valid inputs");
						}
					}
				});
		JButton savings = new JButton("Savings");
		add(savings, gbc);
		savings.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						try {
							String stringBal = balance.getText();
							double bal = Double.parseDouble(stringBal);
							BankAccount newSavings = new SavingsAccount(name.getText(),bal,rate,MIN_BAL,MIN_BAL_FEE);
							accts.add(newSavings);
							name.setText("");balance.setText("");
							JOptionPane.showMessageDialog(null, "Account created: " + newSavings.toString());
						}catch(IllegalArgumentException a){
							JOptionPane.showMessageDialog(null, "Please enter valid inputs");
						}
						
					}
				});
	}
}
