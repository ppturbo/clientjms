package clientjms.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import clientjms.controller.MainController;


public class ServicoClient {
	private Registry referenciaServicoNomes;
	private ClientImpl client;
	private String nomeClient;
	
	/**
	 * Inicia serviço de nomes do Java RMI.
	 * @throws RemoteException 
	 */
	public ServicoClient(){
		
	}
	public void init(String nome) throws RemoteException {
			
		referenciaServicoNomes = LocateRegistry.getRegistry();
		client = new ClientImpl();
			 //obtem ref do registro de nomes
			nomeClient=nome;
			try {
				referenciaServicoNomes.bind(nomeClient, client);//coloca o servidor no registro de nomes.
			} catch (AlreadyBoundException e) {
				MainController.getInstance().CriaNomeClient();
				//chama novamente o mainController para criar o nome.
			} 
			
			System.out.println("INFO: Servidor inicializado.");
	}

	/**
	 * Finaliza serviço de nomes do Java RMI.
	 */
	public void disconnect() {
		try {
			referenciaServicoNomes.unbind(nomeClient);
			System.out
					.println("INFO: Servidor desconectado pelo administrdor.");
		} catch (Exception e) {
			System.err.println("Erro: " + e.getLocalizedMessage());
		}
	}

	/**
	 * Fechar servidor
	 */
	public void finish() {
		System.out.println("INFO: Servidor será fechado em 3 segundos...");
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		
		System.exit(1);
	}

	/**
	 * 
	 * @return the server
	 */
	public ClientImpl getClient() {
		return client;
	}
}
