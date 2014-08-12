/**
 * 
 */
package clientjms.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import clientjms.model.Interesse;

/**
 * @author Guilherme, Paulo
 *
 */
public class ClientImpl extends UnicastRemoteObject implements Client{
	
	protected ClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean vender(Interesse interesse) throws RemoteException{
		return false;
	}
	
	public boolean comprar(Interesse interesse) throws RemoteException{
		return false;
	}
}
