/**
 * 
 */
package clientjms.model;

/**
 * @author Guilherme, Paulo
 *
 */
public class Interesse {
	private Acao acao;

	private String MSGID;
	
	private ClientModel cliente;
	
	private long timestampRegistro;

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public ClientModel getCliente() {
		return cliente;
	}

	public void setCliente(ClientModel cliente) {
		this.cliente = cliente;
	}

	public long getTimestampRegistro() {
		return timestampRegistro;
	}

	public void setTimestampRegistro(long timestampRegistro) {
		this.timestampRegistro = timestampRegistro;
	}

	public String getMSGID() {
		return MSGID;
	}

	public void setMSGID(String MSGID) {
		this.MSGID = MSGID;
	}
}
