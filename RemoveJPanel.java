import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RemoveJPanel extends JPanel
{	
	private ArrayList<BankAccount> accts;

	public RemoveJPanel(ArrayList<BankAccount> a)
	{
		accts = a;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		JLabel specify = new JLabel("Write the number of the account you would like to remove.");
		add(specify, gbc);
		gbc.gridy++;
	
		JTextField specifyField = new JTextField();
		specifyField.setPreferredSize(new Dimension(180, 30));
		add(specifyField,gbc);
		gbc.gridy++;
		
		JButton delete = new JButton("Delete");
		add(delete,gbc);
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					int num = Integer.parseInt(specifyField.getText());
					int[]nums = new int[accts.size()];
					for(int i = 0; i < accts.size();i++)
					{
						nums[i] = accts.get(i).getNum();
						if(num == nums[i])
						{
							accts.remove(accts.get(i));
							specifyField.setText("");
							JOptionPane.showMessageDialog(null, "Account deleted.");
						}
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "No account exist yet.");
				}
			}
		});
		
	}
}
	