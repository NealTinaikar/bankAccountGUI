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

public class TransferJPanel extends JPanel 
{
	private ArrayList<BankAccount> accts;

	private double OVER_DRAFT_FEE = 15; 
	private double rate = 0.0025; 
	private double TRANSACTION_FEE = 1.5; 
	private double MIN_BAL = 300;
	private double MIN_BAL_FEE = 10;
	private int FREE_TRANSACTION = 10;
	
	public TransferJPanel(ArrayList<BankAccount> a)
	{
		accts = a;
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel firstAccountSpecify = new JLabel("WWrite the account number you would like to transfer to.");
		add(firstAccountSpecify, gbc);
		gbc.gridy++;
		
		JTextField specifyFieldFirst = new JTextField();
		specifyFieldFirst.setPreferredSize(new Dimension(180, 30));
		add(specifyFieldFirst,gbc);
		gbc.gridy++;
		
		JLabel secondAccountSpecify = new JLabel("Write the account number you would like to transfer from.");
		add(secondAccountSpecify, gbc);
		gbc.gridy++;
		
		JTextField specifyFieldSecond = new JTextField();
		specifyFieldSecond.setPreferredSize(new Dimension(180, 30));
		add(specifyFieldSecond,gbc);
		gbc.gridy++;
		
		JLabel amount = new JLabel("How much money would you like to transfer?");
		add(amount,gbc);
		gbc.gridy++;
		
		JTextField amountField = new JTextField();
		amountField.setPreferredSize(new Dimension(180, 30));
		add(amountField,gbc);
		gbc.gridy++;
		
		JButton transfer = new JButton("Transfer money.");
		add(transfer,gbc);
		transfer.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						try {
							double cash = Double.parseDouble(amountField.getText());
							int to = Integer.parseInt(specifyFieldFirst.getText());
							int from = Integer.parseInt(specifyFieldSecond.getText());
							int[]nums = new int[accts.size()];
							for(int i = 0; i < accts.size(); i++)
							{
								nums[i] = accts.get(i).getNum();
							}
							for(int i = 0; i < accts.size(); i++)
							{
								for(int j = 0; j < accts.size(); j++)
								{
									if(nums[i] == to && nums[j] == from)
									{
										accts.get(j).transfer(accts.get(i), cash);
										secondAccountSpecify.setText("");specifyFieldSecond.setText("");amountField.setText("");
										JOptionPane.showMessageDialog(null, "Transfer complete:" + accts.get(i).toString() + accts.get(j).toString());
									}
								}
							}
								
						}catch(IllegalArgumentException e) {
							JOptionPane.showMessageDialog(null, "Transfer failed.  Please make sure no invalid information has been entered.");
						}
						
					}
				});
	}
}