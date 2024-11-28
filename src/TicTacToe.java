import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//Final Product
public class TicTacToe implements ActionListener
{
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel btnPanel = new JPanel();
	JLabel txt = new JLabel();
	JButton[] btn = new JButton[9];
	boolean player1;

	

	TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);

		frame.getContentPane().setBackground(Color.gray);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		txt.setBackground(Color.black);
		txt.setForeground(Color.GREEN);

		txt.setFont(new Font(null,Font.BOLD,22));
		txt.setHorizontalAlignment(JLabel.CENTER);
		txt.setText("TicTacToe");
		txt.setOpaque(true);
		
		buttons();

		btnPanel.setLayout(new GridLayout(3,3));
		btnPanel.setBackground(Color.CYAN);

		panel.setLayout(new BorderLayout());
		panel.setBounds(0, 0, 0, 100);
		panel.add(txt);

		frame.add(panel, BorderLayout.NORTH);
		frame.add(btnPanel);

		firstTurn();
	}
	

	public JButton[] buttons()
	{
		for (int i = 0; i < 9;i++)
		{
			btn[i] = new JButton();
			btnPanel.add(btn[i]);
			btn[i].setFocusable(false);
			btn[i].setFont(new Font(null,Font.PLAIN, 100));
			btn[i].addActionListener(this);
		}
		return btn;
	}


	boolean[] xMarked = new boolean[9];  // Tracks "X" moves
	boolean[] oMarked = new boolean[9];  // Tracks "O" moves
	ImageIcon x = new ImageIcon(new ImageIcon("C:\\Users\\Virtual machine\\Pictures\\X1.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
	ImageIcon o = new ImageIcon(new ImageIcon("C:\\Users\\Virtual machine\\Pictures\\O1.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
	
	 

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++) 
		{
	        if (e.getSource() == btn[i]) 
	        {
	            //turn (X)
	            if (player1 && !xMarked[i] && !oMarked[i]) // If the button is empty
	            {  
	                xMarked[i] = true;  
	                btn[i].setIcon(x);  
	                txt.setText("O Turn");
	                player1 = false;
	                check();  
	            }
	            //turn (O)
	            else if (!player1 && !xMarked[i] && !oMarked[i]) 
	            {  
	                oMarked[i] = true;  
	                btn[i].setIcon(o);
	                txt.setText("X Turn");
	                player1 = true;  
	                check(); 
	            }
	        }
	    }
	}

	

	public void firstTurn()
	{
		try
		{
			Thread.sleep(1000);
		} 

		catch(InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(random.nextInt(2)==0)
		{
			player1 = true;
			txt.setText("X turn");
		}
		else
		{
			player1 = false;
			txt.setText("O turn");
		}
	}

	

	public void check()
	{
		
		 for (int i = 0; i < 3; i++) {
		        // Check rows
		        if (xMarked[i*3] && xMarked[i*3 + 1] && xMarked[i*3 + 2]) {
		            xWins(i*3, i*3 + 1, i*3 + 2);
		        }
		        if (oMarked[i*3] && oMarked[i*3 + 1] && oMarked[i*3 + 2]) {
		            oWins(i*3, i*3 + 1, i*3 + 2);
		        }

		        // Check columns
		        if (xMarked[i] && xMarked[i + 3] && xMarked[i + 6]) {
		            xWins(i, i + 3, i + 6);
		        }
		        if (oMarked[i] && oMarked[i + 3] && oMarked[i + 6]) {
		            oWins(i, i + 3, i + 6);
		        }
		    }

		    // Check diagonals
		    if (xMarked[0] && xMarked[4] && xMarked[8]) 
		    {
		        xWins(0, 4, 8);
		    }
		    if (xMarked[2] && xMarked[4] && xMarked[6]) 
		    {
		        xWins(2, 4, 6);
		    }

		    if (oMarked[0] && oMarked[4] && oMarked[8]) 
		    {
		        oWins(0, 4, 8);
		    }
		    if (oMarked[2] && oMarked[4] && oMarked[6]) 
		    {
		        oWins(2, 4, 6);
		    }
	}

	

	public void xWins(int x, int y, int z)
	{
		btn[x].setBackground(Color.green);
		btn[y].setBackground(Color.green);
		btn[z].setBackground(Color.green);
		
		for (int i = 0; i < 9; i++)
		{
			btn[i].setEnabled(false);
		}
		//txt.setText("X-won");
	}



	public void oWins(int x, int y, int z)
	{
	 btn[x].setBackground(Color.green);
	 btn[y].setBackground(Color.green);
	 btn[z].setBackground(Color.green);

		   
	 	for (int i = 0; i < 9; i++) 
		{
		btn[i].setEnabled(false);
		}
	 	//txt.setText("O-won");
	}
	
	public void WebSocket()
	{
		
	}
}