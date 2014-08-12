/**
 * 
 */
package clientjms.jms;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQDestination;

import clientjms.controller.AcoesController;
import clientjms.model.Acao;
import clientjms.model.ClientModel;
import clientjms.model.Interesse;

/**
 * @author Guilherme, Paulo
 *
 */
public class ConsumeMsg {
	private static ConsumeMsg instance = null;

	public static ConsumeMsg getInstance() {
		if (instance == null) {
			instance = new ConsumeMsg();
		}

		return instance;
	}

	public ConsumeMsg() {
		ReadCompras readCompras = new ReadCompras();
	}

	public class ReadCompras implements MessageListener {
		private int ackMode;
		private String messageTopicName;
		private String messageBrokerUrl;

		private Session session;
		private boolean transacted = false;
		private MessageProducer replyProducer;

		public ReadCompras() {
			try {
				// This message broker is embedded
				messageBrokerUrl = "tcp://localhost:61616";
				messageTopicName = "Compra";
				ackMode = Session.AUTO_ACKNOWLEDGE;
				BrokerService broker = new BrokerService();
				broker.setPersistent(false);
				broker.setUseJmx(false);
				broker.addConnector(messageBrokerUrl);
				broker.start();
			} catch (Exception e) {
			}
			this.setupMessageTopicConsumer();
		}

		private void setupMessageTopicConsumer() {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					messageBrokerUrl);
			Connection connection;
			try {
				connection = connectionFactory.createConnection();
				connection.start();
				this.session = connection.createSession(this.transacted,
						ackMode);
				Destination adminQueue = this.session
						.createTopic(messageTopicName);

				// Set up a consumer to consume messages off of the admin queue
				MessageConsumer consumer = this.session.createConsumer(adminQueue);
				consumer.setMessageListener(this);
			} catch (JMSException e) {
				// Handle the exception appropriately
			}
		}

		public void onMessage(Message message) {
			try {
				if (message instanceof TextMessage) {
					TextMessage txtMsg = (TextMessage) message;
					String messageText = txtMsg.getText();
					Interesse interesse = unpack(messageText);
					AcoesController.getInstance()
							.addInteressesCompra(interesse);
				}
			} catch (JMSException | UnknownHostException e) {
				// Handle the exception appropriately
			}
		}

	}

	public static Interesse unpack(final String str)
			throws UnknownHostException {
		// formato da string: s[0]Empresa s[1]Quantidade s[2]Pre�o s[3]Prazo
		// s[4]IP s[5]Porta s[6]Nome s[7]MSGID s[8]TempoRegistro
		Interesse interesse = new Interesse();
		Acao acao = new Acao();
		ClientModel client = new ClientModel();
		String s[] = str.split(" ");
		acao.setEmpresa(s[0]);
		acao.setQuantidade(Double.parseDouble(s[1]));
		acao.setPreco(Double.parseDouble(s[2]));
		acao.setPrazoCondicional(Long.parseLong(s[3]));
		client.setIpClient(InetAddress.getByName(s[4]));
		client.setPortaClient(Integer.parseInt(s[5]));
		client.setNomeClient(s[6]);
		interesse.setAcao(acao);
		interesse.setCliente(client);
		interesse.setMSGID(s[7]);
		interesse.setTimestampRegistro(Long.parseLong(s[8]));

		return interesse;
	}

	public String pack(final Interesse interesse) throws UnknownHostException {
		// formato da string: s[0]Empresa s[1]Quantidade s[2]Pre�o s[3]Prazo
		// s[4]IP s[5]Porta s[6]Nome s[7]MSGID s[8]TempoRegistro
		String s = new String();
		s = interesse.getAcao().getEmpresa() + " "
				+ Double.toString(interesse.getAcao().getQuantidade()) + " "
				+ Double.toString(interesse.getAcao().getPreco()) + " "
				+ Long.toString(interesse.getAcao().getPrazoCondicional())
				+ " " + interesse.getCliente().getIpClient().toString() + " "
				+ Integer.toString(interesse.getCliente().getPortaClient())
				+ " " + interesse.getCliente().getNomeClient() + " "
				+ interesse.getMSGID() + " " + interesse.getTimestampRegistro();

		return s;
	}

}
