package clientjms.controller;

import java.awt.EventQueue;

import clientjms.model.Carteira;
import clientjms.view.*;

public class MainController {
	
		/**
		 * Instância do singleton.
		 */
		private static MainController instance = null;

		private MainController() {

		}

		public static MainController getInstance() {
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
				
				// TODO Chamar outra view com dropdown mostrando as acoes da carteira
				public void run() {
					try {
						VendaView frame = new VendaView(Carteira.getInstance().getAcoes());
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
	
	public void Monitoramento(){
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

}
