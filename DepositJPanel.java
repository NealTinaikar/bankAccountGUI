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

public class DepositJPanel extends JPanel 
{
	private ArrayList<BankAccount> accts;

	private double OVER_DRAFT_FEE = 15; 
	private double rate = 0.0025; 
	private double TRANSACTION_FEE = 1.5; 
	private double MIN_BAL = 300;
	private double MIN_BAL_FEE = 10;
	private int FREE_TRANSACTION = 10;
	
	public DepositJPanel(ArrayList<BankAccount> a)
	{
		accts = a;
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel accountSpecify = new JLabel("Write the account number that you would like to deposit to.");
		add(accountSpecify, gbc);
		gbc.gridy++;
		
		JTextField specifyField = new JTextField();
		specifyField.setPreferredSize(new Dimension(180, 30));
		add(specifyField,gbc);
		gbc.gridy++;
		
		JLabel monetarySpecify = new JLabel("Please specify how much money you would like to deposit.");
		add(monetarySpecify, gbc);
		gbc.gridy++;
		
		JTextField accountInput = new JTextField();
		accountInput.setPreferredSize(new Dimension(180, 30));
		add(accountInput, gbc);
		gbc.gridy++;
		
		JButton deposit = new JButton("Deposit");
		add(deposit,gbc);
		deposit.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						try {
							double cash = Double.parseDouble(accountInput.getText());
							int num = Integer.parseInt(specifyField.getText());
							int[]nums = new int[accts.size()];
							for(int i = 0; i < accts.size();i++)
							{
								nums[i] = accts.get(i).getNum();
								if(num == (nums[i]))
								{
									accts.get(i).deposit(cash);
									specifyField.setText("");
									accountInput.setText("");
									JOptionPane.showMessageDialog(null, "Deposit complete:" + accts.get(i).toString());
								}
							}
						}catch(IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null, "Please enter valid inputs");
						}
					}
				});
	}
}
