package clientjms.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PassouLimiteView extends JFrame {
	private JPanel contentPane;
	
	public PassouLimiteView(){
		setBounds(100, 100, 191, 146);
		setType(Type.UTILITY);
		getContentPane().setLayout(null);
		
		JLabel lblLimiteUltrapassado = new JLabel("Limite Ultrapassado!");
		lblLimiteUltrapassado.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimiteUltrapassado.setBounds(0, 40, 175, 14);
		getContentPane().add(lblLimiteUltrapassado);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(47, 65, 89, 23);
		getContentPane().add(btnNewButton);

	}
}
