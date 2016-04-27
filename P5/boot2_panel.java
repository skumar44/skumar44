package P5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class boot2_panel {

	private JFrame frame;
	private JTextField txtScore;
	private JTextField txtTimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boot2_panel window = new boot2_panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public boot2_panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.EAST);
		
		txtScore = new JTextField();
		txtScore.setText("Score: ");
		splitPane.setLeftComponent(txtScore);
		txtScore.setColumns(10);
		
		txtTimer = new JTextField();
		txtTimer.setText("Timer: ");
		splitPane.setRightComponent(txtTimer);
		txtTimer.setColumns(10);
	}

}
