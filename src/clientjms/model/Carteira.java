/**
 * 
 */
package clientjms.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guilherme, Paulo
 *
 */
public class Carteira {
	private static Carteira instance = null;

	private List<Acao> acoes;
	
	private double capital;

	private Carteira() {
		acoes = new ArrayList<>();
		capital = 500;
	}

	public static Carteira getInstance() {
		if (instance == null) {
			instance = new Carteira();
		}

		return instance;
	}

	/**
	 * Adiciona ação à carteira.
	 * 
	 * @param acao
	 */
	public void addAcao(Acao acao) {
		acoes.add(acao);
	}

	/**
	 * Retorna ações da carteira.
	 * 
	 * @return acoes.
	 */
	public List<Acao> getAcoes() {
		return acoes;
	}

	/**
	 * @return the capital
	 */
	public double getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(double capital) {
		this.capital = capital;
	}
	
	
}
