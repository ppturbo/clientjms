package clientjms.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import clientjms.model.Acao;

public class VendaView extends JFrame {

	private JPanel contentPane;
	private JTextField campoPreco;

	/**
	 * Create the frame.
	 */
	public VendaView(List<Acao> acao) {
		setTitle("Venda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(10, 14, 70, 15);
		contentPane.add(lblEmpresa);

		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(10, 53, 70, 15);
		contentPane.add(lblPreco);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(10, 101, 105, 15);
		contentPane.add(lblQuantidade);

		JLabel lblPrazo = new JLabel("Prazo (em segundos)");
		lblPrazo.setBounds(10, 155, 181, 15);
		contentPane.add(lblPrazo);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Long(0), new Long(0), null, new Long(100)));
		spinner.setBounds(201, 152, 46, 20);
		contentPane.add(spinner);

		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fechar();
			}
		});
		button_1.setBounds(338, 184, 96, 25);
		contentPane.add(button_1);

		JLabel labelQuantidade = new JLabel("");
		labelQuantidade.setBounds(201, 102, 46, 14);
		contentPane.add(labelQuantidade);

		campoPreco = new JTextField();
		campoPreco.setBounds(201, 50, 46, 20);
		contentPane.add(campoPreco);
		campoPreco.setColumns(10);

		JComboBox BoxEmpresas = new JComboBox();
		BoxEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelQuantidade.setText(String.valueOf((acao.get(BoxEmpresas
						.getSelectedIndex()).getQuantidade())));
			}
		});
		BoxEmpresas.setBounds(201, 11, 96, 20);
		contentPane.add(BoxEmpresas);
		for (Acao assao : acao) {
			BoxEmpresas.addItem(assao.getEmpresa());
		}

		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Acao vender = acao.get(BoxEmpresas.getSelectedIndex());

				vender.setPreco(Integer.valueOf(campoPreco.getText()));
				vender.setPrazoCondicional(((long) spinner.getValue()) * 1000);

				try {
					//AcoesController.getInstance(null).vender(vender);
				} catch (Exception e) {
					// TODO Colocar mensagem de erro
					e.printStackTrace();
				}

				fechar();
			}
		});
		button.setBounds(256, 184, 70, 25);
		contentPane.add(button);
	}

	private void fechar() {
		this.setVisible(false);
	}
}
