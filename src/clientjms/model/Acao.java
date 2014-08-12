/**
 * 
 */
package clientjms.model;

/**
 * @author Guilherme, Paulo
 *
 */
public class Acao {
	private String empresa;
	
	private double quantidade;
	
	private double preco;
	
	private long prazoCondicional;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public long getPrazoCondicional() {
		return prazoCondicional;
	}

	public void setPrazoCondicional(long prazoCondicional) {
		this.prazoCondicional = prazoCondicional;
	}

}
