package jokoa;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class AsmatuZenbakia extends JFrame {
	JLabel jLabel1 = new JLabel();
	JTextField jTextField1 = new JTextField();
	JLabel mezua = new JLabel();
	JButton jButton1 = new JButton();
	JPanel jPanela = new JPanel();
	JPanel jPanela2 = new JPanel();

	int rd;

	public AsmatuZenbakia() {
		setTitle("Asmatu!");

		jLabel1.setText("Sartu zenbakia: ");
		jTextField1.setColumns(4);
		getContentPane().add(jTextField1);
		getContentPane().add(jLabel1);
		jButton1.setText("Konprobatu");
		jButton1.setActionCommand("testua");
	}

	public static void main(String[] args) {
		AsmatuZenbakia proba = new AsmatuZenbakia();
		proba.hasi();
		proba.setListeners();
	}

	private void hasi() {
		rd = new Random().nextInt(100);
		jPanela.add(jLabel1);
		jPanela.add(jTextField1);
		this.getContentPane().add(jPanela, BorderLayout.NORTH);
		jPanela2.add(jButton1);
		this.getContentPane().add(jPanela2, BorderLayout.SOUTH);
		this.getContentPane().add(mezua, BorderLayout.CENTER);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);

	}

	public void setListeners() {

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				zenbakiaKonparatu();
			}
		});

		jTextField1.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					zenbakiaKonparatu();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}

			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
	}

	private void zenbakiaKonparatu() {
		try {
			int zenbakia = Integer.parseInt(jTextField1.getText());
			if (rd == zenbakia) {
				int reply = JOptionPane.showConfirmDialog(null, "Asmatu duzu, berriro jokatu nahi?", "bukatu nahi?",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.NO_OPTION) {
					System.exit(0);
				} else {
					dispose();
					hasi();
					setListeners();
				}
			} else if (rd > zenbakia) {
				mezua.setText("Erantzuna zenbaki handiago bat da.");
				jTextField1.setText("");
			} else if (rd < zenbakia) {
				mezua.setText("Erantzuna zenbaki txikiago bat da.");
				jTextField1.setText("");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ez da zenbaki bat", "Error", JOptionPane.ERROR_MESSAGE);
			jTextField1.setText("");
		}
	}

}
