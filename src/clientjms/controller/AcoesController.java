/**
 * 
 */
package clientjms.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
		interessesCompra.add(interesse);
	}

	public void addInteressesVenda(Interesse interesse){
		interessesVenda.add(interesse);
	}
	
	public void excluirInteresseCompra(String MSGID){
		Iterator<Interesse> it = interessesCompra.iterator();

        while(it.hasNext()){
        	Interesse i=it.next();
            if(i.getMSGID().equals(MSGID)){
               it.remove();
            }
       }
	}
	
	public void excluirInteresseVenda(String MSGID){
		Iterator<Interesse> it = interessesVenda.iterator();

        while(it.hasNext()){
        	Interesse i=it.next();
            if(i.getMSGID().equals(MSGID)){
               it.remove();
            }
       }
	}
	//Iterator<String> it = list.iterator();

        //while(it.hasNext()){

            //if(it.next().equals("nove")){
            //    it.remove();
            //}
       // }
	

}
