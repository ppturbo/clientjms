/**
 * 
 */
package clientjms.jms;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import clientjms.model.Acao;
import clientjms.model.ClientModel;
import clientjms.model.Interesse;

/**
 * @author Guilherme, Paulo
 *
 */
public class ProduceMsg {

	public void ProdMSG(Interesse interesse, String topic) { // TOPIC VENDA ou
																// COMPRA
		try {
			// Create a ConnectionFactory
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

			// Create a Connection
			Connection connection = connectionFactory.createConnection();
			connection.start();

			// Create a Session
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Create the destination (Topic or Queue)
			Destination destination = session.createTopic(topic);

			// Create a MessageProducer from the Session to the Topic or Queue
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			// Create a messages
			String text = pack(interesse);
			TextMessage message = session.createTextMessage(text);

			// Tell the producer to send the message
			producer.send(message);

			// Clean up
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}
	}

	public void ProdMSGDelete(String interesse, String MSGID) {
		try {
			// Create a ConnectionFactory
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

			// Create a Connection
			Connection connection = connectionFactory.createConnection();
			connection.start();

			// Create a Session
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Create the destination (Topic or Queue)
			Destination destination = session.createTopic("Delete");

			// Create a MessageProducer from the Session to the Topic or Queue
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			// Create a messages
			String text = interesse + " " + MSGID;
			TextMessage message = session.createTextMessage(text);

			// Tell the producer to send the message
			producer.send(message);

			// Clean up
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}
	}

	public Interesse unpack(String str) throws UnknownHostException {
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

	public String pack(Interesse interesse) throws UnknownHostException {
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
