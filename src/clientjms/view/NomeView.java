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

import clientjms.controller.MainController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class NomeView extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	/**
	 * Create the frame.
	 */
	public NomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registro de Nome");
		setBounds(100, 100, 277, 105);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsiraUmNome = new JLabel("Insira um Nome");
		lblInsiraUmNome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInsiraUmNome, BorderLayout.NORTH);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MainController.getInstance().RegistrarNome(campoNome.getText());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		contentPane.add(btnOk, BorderLayout.SOUTH);
		
		campoNome = new JTextField();
		campoNome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(campoNome, BorderLayout.CENTER);
		campoNome.setColumns(10);
	}
}
