/**
 * 
 */
package clientjms.model;

import java.net.InetAddress;

/**
 * @author Guilherme, Paulo
 *
 */
public class ClientModel {
	private InetAddress IpClient;
	private int PortaClient;
	private String NomeClient;
	public InetAddress getIpClient() {
		return IpClient;
	}
	public void setIpClient(InetAddress ipClient) {
		IpClient = ipClient;
	}
	public int getPortaClient() {
		return PortaClient;
	}
	public void setPortaClient(int portaClient) {
		PortaClient = portaClient;
	}
	public String getNomeClient() {
		return NomeClient;
	}
	public void setNomeClient(String nomeClient) {
		NomeClient = nomeClient;
	}
}
