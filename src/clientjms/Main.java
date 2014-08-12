/**
 * 
 */
package clientjms;

import java.awt.EventQueue;
import java.rmi.RemoteException;

import clientjms.controller.MainController;
import clientjms.jms.ProduceMsg;
import clientjms.view.MainView;

/**
 * @author Guilherme, Paulo
 *
 */
public class Main {

	/**
	 * @param args
	 */
	private static MainController mainController;
	public static void main(String[] args) throws RemoteException {
		mainController = new MainController();
	}

}
