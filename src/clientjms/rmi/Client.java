package clientjms.rmi;



import java.rmi.Remote;
import java.rmi.RemoteException;

import clientjms.model.Interesse;

/**
 * @author Guilherme, Paulo
 *
 */
public interface Client extends Remote{
	public boolean vender(Interesse interesse) throws RemoteException;
	
	public boolean comprar(Interesse interesse) throws RemoteException;
}
