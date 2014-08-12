package clientjms.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clientjms.model.Acao;
import clientjms.model.Carteira;

public class CarteiraView extends JFrame {
	private DefaultTableModel modelo;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public CarteiraView() {
		
		setType(Type.UTILITY);
		setTitle("Carteira");
		getContentPane().setLayout(new BorderLayout());
		setBounds(200, 200, 400, 500);
		modelo=new DefaultTableModel();
		modelo.addColumn("Empresa");
		modelo.addColumn("Quantidade");
		for(Acao assao : Carteira.getInstance().getAcoes()){
			String[] o={assao.getEmpresa(), String.valueOf(assao.getQuantidade())};
			modelo.addRow(o);
		}
		table = new JTable(modelo);
		table.setFont(new Font("Calibri", Font.PLAIN, 15));
		JScrollPane scroll =  new JScrollPane(table); 
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add("Center", scroll);
	}
}
