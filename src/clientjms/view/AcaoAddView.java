package clientjms.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import clientjms.model.Acao;
import clientjms.model.Carteira;

public class AcaoAddView extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmpresa;

	/**
	 * Create the frame.
	 */
	public AcaoAddView() {
		setTitle("Adicionar Acao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(12, 0, 70, 15);
		contentPane.add(lblEmpresa);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(12, 26, 105, 15);
		contentPane.add(lblQuantidade);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(331, 56, 96, 25);
		contentPane.add(btnCancelar);

		tfEmpresa = new JTextField();
		tfEmpresa.setBounds(195, 0, 114, 19);
		contentPane.add(tfEmpresa);
		tfEmpresa.setColumns(10);

		JSpinner spQuantidade = new JSpinner();
		
		spQuantidade
				.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 10.0));
		spQuantidade.setBounds(195, 23, 46, 20);
		contentPane.add(spQuantidade);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acao acao = new Acao();
				acao.setEmpresa(tfEmpresa.getText());
				acao.setPrazoCondicional(0);
				acao.setPreco(0);
				acao.setQuantidade((double) spQuantidade.getValue());
				Carteira.getInstance().addAcao(acao); //adiciona a a��o na carteira.
				fechar();

			}});
		btnOk.setBounds(251, 56, 70, 25);
		contentPane.add(btnOk);
	}

	private void fechar() {
		this.setVisible(false);
	}
}
