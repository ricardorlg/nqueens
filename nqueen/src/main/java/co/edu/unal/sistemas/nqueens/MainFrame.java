package co.edu.unal.sistemas.nqueens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -408394173625478034L;
	private JPanel contentPane;
	private JPanel contenederDrawer;
	private Agent agent;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public MainFrame(Agent agent) {
		this.agent = agent;
		setTitle("N-Queens Solver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);

		JLabel lblN = new JLabel("N = ");
		panel_2.add(lblN);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);

		JSeparator separator = new JSeparator();
		panel_2.add(separator);

		JButton btnSolve = new JButton("Solve");
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processAct();
			}
		});
		panel_2.add(btnSolve);

		contenederDrawer = new JPanel();
		contenederDrawer.setBorder(null);
		contenederDrawer.setBackground(Color.WHITE);
		contentPane.add(contenederDrawer, BorderLayout.CENTER);
		contenederDrawer.setLayout(new BoxLayout(contenederDrawer,
				BoxLayout.X_AXIS));
		textField.setText("8");
		setSize(600, 600);
	}

	public JPanel getContenederDrawer() {
		return contenederDrawer;
	}

	private void processAct() {
		if (!textField.getText().isEmpty()) {
			try {
				Integer n = Integer.parseInt(textField.getText());
				agent.setN(n);
			} catch (Exception e) {

			}

		}
		agent.reset();
		agent.solve();
	}

	public void addBoard(Board board) {
		// TODO Auto-generated method stub
		contenederDrawer.add(board.getView());
	}

}
