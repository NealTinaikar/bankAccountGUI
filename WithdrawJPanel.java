import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class WithdrawJPanel extends JPanel
{
	private ArrayList<BankAccount> accts;

	private double OVER_DRAFT_FEE = 15; 
	private double rate = 0.0025; 
	private double TRANSACTION_FEE = 1.5; 
	private double MIN_BAL = 300;
	private double MIN_BAL_FEE = 10;
	private int FREE_TRANSACTION = 10;
	
	public WithdrawJPanel(ArrayList<BankAccount>a)
	{
		accts = a;
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel specify = new JLabel("What account would you like to withdraw from? Enter the number of the account below.");
		add(specify, gbc);
		gbc.gridy++;
	
		JTextField specifyField = new JTextField();
		specifyField.setPreferredSize(new Dimension(180, 30));
		add(specifyField,gbc);
		gbc.gridy++;
		
		JLabel amount = new JLabel("How much money would you like to withdraw?");
		add(amount,gbc);
		gbc.gridy++;
		
		JTextField amountField = new JTextField();
		amountField.setPreferredSize(new Dimension(180, 30));
		add(amountField,gbc);
		gbc.gridy++;
		
		JButton withdraw = new JButton("Withdraw money.");
		add(withdraw,gbc);
		withdraw.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						try {
							double cash = Double.parseDouble(amountField.getText());
							int num = Integer.parseInt(specifyField.getText());
							int[]nums = new int[accts.size()];
							for(int i = 0; i < accts.size();i++)
							{
								nums[i] = accts.get(i).getNum();
								if(num == (nums[i]))
								{
									accts.get(i).withdraw(cash);
									specifyField.setText("");
									amountField.setText("");
									JOptionPane.showMessageDialog(null, "Withdrawal complete:" + accts.get(i).toString());
								}
							}
						}catch(IllegalArgumentException a) {
							JOptionPane.showMessageDialog(null, "Please enter valid inputs.");
						}
					}
				});
	}
}
