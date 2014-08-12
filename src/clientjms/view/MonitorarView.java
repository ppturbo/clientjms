package clientjms.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clientjms.controller.AcoesController;
import clientjms.model.Acao;
import clientjms.model.Carteira;
import clientjms.model.Interesse;

public class MonitorarView extends JFrame {

	private JPanel contentPane;
	private JTable tableOfertaVenda;
	private JTable tableOfertaCompra;
	private DefaultTableModel modelo;

	/**
	 * Create the frame.
	 */
	public MonitorarView() {
		setBounds(100, 100, 636, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("Empresa"); //s[0]Empresa s[1]Quantidade s[2]Preco s[3]Prazo s[6]Nome
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preco");
		modelo.addColumn("Prazo");
		modelo.addColumn("Nome Cliente");

		tableOfertaVenda = new JTable(modelo);
		
		JScrollPane scrollPaneVenda = new JScrollPane(tableOfertaVenda);
		scrollPaneVenda.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneVenda.setBounds(10, 56, 293, 411);
		contentPane.add(scrollPaneVenda);
		
		tableOfertaCompra = new JTable(modelo);		
		JScrollPane scrollPaneCompra = new JScrollPane(tableOfertaCompra);
		scrollPaneCompra.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCompra.setBounds(317, 56, 293, 411);
		contentPane.add(scrollPaneCompra);
		

		
		JLabel lblOfertasDeVenda = new JLabel("Ofertas de Venda");
		lblOfertasDeVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfertasDeVenda.setBounds(109, 24, 97, 14);
		contentPane.add(lblOfertasDeVenda);
		
		JLabel lblOfertasDeCompra = new JLabel("Ofertas de Compra");
		lblOfertasDeCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfertasDeCompra.setBounds(404, 24, 110, 14);
		contentPane.add(lblOfertasDeCompra);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { //s[0]Empresa s[1]Quantidade s[2]Preco s[3]Prazo s[6]Nome
					for(Interesse interesse : AcoesController.getInstance().getInteressesCompra()){
						String[] o={interesse.getAcao().getEmpresa(), String.valueOf(interesse.getAcao().getQuantidade()), String.valueOf(interesse.getAcao().getPreco()), String.valueOf(interesse.getTimestampRegistro()), interesse.getCliente().getNomeClient()};
						modelo.addRow(o);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(265, 20, 89, 23);
		contentPane.add(btnRefresh);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(10, 478, 293, 23);
		contentPane.add(btnComprar);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(317, 478, 293, 23);
		contentPane.add(btnVender);
	}
}
