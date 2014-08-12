/**
 * 
 */
package clientjms.controller;

import java.util.ArrayList;
import java.util.List;

import clientjms.jms.ConsumeMsg;
import clientjms.model.Interesse;

/**
 * @author Guilherme, Paulo
 *
 */
public class AcoesController {
	private List<Interesse> interessesCompra;
	private List<Interesse> interessesVenda;
	/**
	 * Instância do singleton.
	 */
	private static AcoesController instance = null;

	private AcoesController() {
		ConsumeMsg.getInstance();
		interessesCompra=new ArrayList<>();
		interessesVenda=new ArrayList<>();
	}

	public static AcoesController getInstance() {
		if (instance == null) {
			instance = new AcoesController();
		}

		return instance;
	}

	public List<Interesse> getInteressesVenda() {
		
		return interessesVenda;
	}

	public void setInteressesVenda(List<Interesse> interessesVenda) {
		this.interessesVenda = interessesVenda;
	}

	public List<Interesse> getInteressesCompra() throws Exception {
		return interessesCompra;
	}

	public void setInteressesCompra(List<Interesse> interessesCompra) {
		this.interessesCompra = interessesCompra;
	}

	public void addInteressesCompra(Interesse interesse){
		System.out.println("interesse.");
		
		interessesCompra.add(interesse);
		System.out.println(interessesCompra.get(0).getMSGID());
		
	}

	public void addInteressesVenda(Interesse interesse){
		interessesVenda.add(interesse);
	}
	
	public void excluirInteresseCompra(String MSGID){//verificar para remover utilizando o iterator
		for(Interesse interesse : interessesCompra){
			if(interesse.getMSGID().equals(MSGID))
				interessesCompra.remove(interesse);
			break;
		}
	}
	//Iterator<String> it = list.iterator();

        //while(it.hasNext()){

            //if(it.next().equals("nove")){
            //    it.remove();
            //}
       // }
	

}
