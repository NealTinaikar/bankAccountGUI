import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class Execute extends JFrame
{
	private ArrayList<BankAccount> accts = new ArrayList<BankAccount>();
	JFrame frame = this;
	public Execute()
	{
		JMenuBar mainMenu = new JMenuBar();
		
		JMenu account = new JMenu("Account");
		mainMenu.add(account);
		JMenuItem accountadd = new JMenuItem("Add Account");
		JMenuItem accountremove = new JMenuItem("Remove Account");
		JMenuItem accountaccess = new JMenuItem("Access Accounts");
		account.add(accountadd);
		account.add(accountremove);
		account.add(accountaccess);
		
		JMenu trans = new JMenu("Transactions");
		mainMenu.add(trans);
		JMenuItem deposit = new JMenuItem("Deposit");
		trans.add(deposit);
		JMenuItem withdraw = new JMenuItem("Withdraw");
		trans.add(withdraw);
		JMenuItem transfer = new JMenuItem("Transfer");
		trans.add(transfer);
		JMenuItem getB = new JMenuItem("Get Balance");
		trans.add(getB);
		
		JMenu back = new JMenu("Home");
		mainMenu.add(back);
		JMenuItem home = new JMenuItem("Return");
		back.add(home);
		frame.setJMenuBar(mainMenu);
		
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		this.add(overall);
		overall.setLayout(cl);	 
		overall.add(new BankJPanel(accts), "add");
		overall.add(new RemoveJPanel(accts), "remove");
		overall.add(new AccessJPanel(accts), "access");
		overall.add(new Welcome(accts), "welcome");
		overall.add(new DepositJPanel(accts), "deposit");
		overall.add(new WithdrawJPanel(accts), "withdraw");
		overall.add(new TransferJPanel(accts), "transfer");
		overall.add(new getBalance(accts), "getB");
		cl.show(overall, "welcome");
	
		accountadd.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						cl.show(overall, "add");
					}
				});
		accountremove.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						cl.show(overall, "remove");
					}
				});
		accountaccess.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "access");
			}
		});
		deposit.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
					cl.show(overall, "deposit");
					}
			
				});
		withdraw.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
			cl.show(overall, "withdraw");
			}
	
		});
		transfer.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
			cl.show(overall, "transfer");
			}
	
		});
		getB.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
			cl.show(overall, "getB");
			}
	
		});
		home.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
			cl.show(overall, "welcome");
			}
	
		});
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new Execute();
	}

}
