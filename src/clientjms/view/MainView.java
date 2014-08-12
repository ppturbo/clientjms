package clientjms.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientjms.controller.MainController;
import clientjms.model.Carteira;

public class MainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 124);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(374, 47, 62, 25);
		contentPane.add(btnSair);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 493, 21);
		contentPane.add(menuBar);
		
		JMenuItem mntmMonitorar = new JMenuItem("Monitorar");
		mntmMonitorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainController.getInstance().Monitoramento();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(mntmMonitorar);
		
		JMenuItem mntmVender = new JMenuItem("Vender");
		menuBar.add(mntmVender);
		
		JMenuItem mntmComprar = new JMenuItem("Comprar");
		mntmComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MainController.getInstance().registrarCompra();
			}
		});
		menuBar.add(mntmComprar);
		
		JMenuItem mntmConsultar = new JMenuItem("Carteira");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainController.getInstance().MostraCarteira();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(mntmConsultar);
		
		JMenuItem mntmAddAcao = new JMenuItem("AddAcao");
		mntmAddAcao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainController.getInstance().registrarAcao();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(mntmAddAcao);
				mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainController.getInstance().registrarVenda();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JLabel lblDinheiro = new JLabel("");
		lblDinheiro.setBounds(109, 58, 224, 14);
		contentPane.add(lblDinheiro);
		lblDinheiro.setText("Disponível: $"+Carteira.getInstance().getCapital());
		
		JButton Refresh = new JButton("Refresh");
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDinheiro.setText("Disponível: $"+Carteira.getInstance().getCapital());
			}
		});
		Refresh.setBounds(10, 52, 89, 23);
		contentPane.add(Refresh);
	}
}
