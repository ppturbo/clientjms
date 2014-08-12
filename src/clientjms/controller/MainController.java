package clientjms.controller;

import java.awt.EventQueue;
import java.rmi.RemoteException;

import clientjms.model.Carteira;
import clientjms.rmi.ClientImpl;
import clientjms.rmi.ServicoClient;
import clientjms.view.AcaoAddView;
import clientjms.view.CarteiraView;
import clientjms.view.MainView;
import clientjms.view.MonitorarView;
import clientjms.view.NomeView;
import clientjms.view.VendaView;

public class MainController {

	/**
	 * Instância do singleton.
	 */
	private static MainController instance = null;
	private ServicoClient servClient;
	private ClientImpl client;

	public MainController() throws RemoteException {
		servClient = new ServicoClient();
		client = servClient.getClient();
		CriaNomeClient();
	}

	public static MainController getInstance() throws RemoteException {
		if (instance == null) {
			instance = new MainController();
		}

		return instance;
	}

	/**
	 * Inicializa a funcionalidade de venda.
	 */
	public void registrarVenda() {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					VendaView frame = new VendaView(Carteira.getInstance()
							.getAcoes());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializa a funcionalidade de Adicionar A��o.
	 */
	public void registrarAcao() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcaoAddView frame = new AcaoAddView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializa a funcionalidade de carteira.
	 */
	public void MostraCarteira() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarteiraView frame = new CarteiraView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Monitoramento() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonitorarView frame = new MonitorarView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void CriaNomeClient() {
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

	public void JanelaPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void RegistrarNome(String nome) throws RemoteException{
		servClient.init(nome);
	}
}
