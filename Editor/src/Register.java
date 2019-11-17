import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JPanel implements ActionListener {
	JLabel userL = new JLabel("Choose a Username");
	JTextField userTF = new JTextField();
	JLabel passL = new JLabel("Password");
	JPasswordField passTF = new JPasswordField();
	JLabel passLC = new JLabel("Confirm Password");
	JPasswordField passC = new JPasswordField();
	JButton register = new JButton("Register");
	JButton back = new JButton("Back");

	public Register() {
		JPanel loginP = new JPanel();
		loginP.setLayout(new GridLayout(4, 2));
		loginP.add(userL);
		loginP.add(userTF);
		loginP.add(passL);
		loginP.add(passTF);
		loginP.add(passLC);
		loginP.add(passC);
		loginP.add(register);
		loginP.add(back);
		register.addActionListener(this);
		back.addActionListener(this);
		add(loginP);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == register && passTF.getPassword().length > 0 && userTF.getText().length() > 0) {
			String pass = new String(passTF.getPassword());
			String confirm = new String(passC.getPassword());
			if (pass.equals(confirm)) {
				try {
					BufferedReader input = new BufferedReader(new FileReader("password.txt"));
					String line = input.readLine();
					while (line != null) {
						StringTokenizer st = new StringTokenizer(line);
						if (userTF.getText().equals(st.nextToken())) {
							System.out.println("User already exist");
							break;
						}
						line = input.readLine();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		if (e.getSource() == back) {
			Login login = (Login) getParent();
			login.cl.show(login, "login");
		}

	}
}
