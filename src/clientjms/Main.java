/**
 * 
 */
package clientjms;

import java.awt.EventQueue;

import clientjms.jms.ProduceMsg;
import clientjms.view.MainView;

/**
 * @author Guilherme, Paulo
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
