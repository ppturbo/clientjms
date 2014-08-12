package clientjms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;

public class NomeView extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NomeView frame = new NomeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NomeView() {
		setTitle("Registro de Nome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 105);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsiraUmNome = new JLabel("Insira um Nome");
		lblInsiraUmNome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInsiraUmNome, BorderLayout.NORTH);
		
		JButton btnOk = new JButton("OK");
		contentPane.add(btnOk, BorderLayout.SOUTH);
		
		campoNome = new JTextField();
		campoNome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(campoNome, BorderLayout.CENTER);
		campoNome.setColumns(10);
	}
}
