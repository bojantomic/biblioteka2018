package biblioteka.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteka.Knjiga;
import biblioteka.gui.kontroler.GUIKontroler;

public class PronadjiKnjiguProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private GlavniProzor gp;
	private JScrollPane scrollPane;
	private JList list;
	private JPanel panel;
	private JLabel lblNaslov;
	private JTextField textFieldNaslov;
	private JButton btnPronadji;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public PronadjiKnjiguProzor() {
		setTitle("Pronadji knjigu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PronadjiKnjiguProzor.class.getResource("/icons/bluej-84-toned.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(gp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel.add(getLblNaslov());
			panel.add(getTextFieldNaslov());
			panel.add(getBtnPronadji());
			panel.add(getBtnOdustani());
		}
		return panel;
	}
	private JLabel getLblNaslov() {
		if (lblNaslov == null) {
			lblNaslov = new JLabel("Naslov");
		}
		return lblNaslov;
	}
	private JTextField getTextFieldNaslov() {
		if (textFieldNaslov == null) {
			textFieldNaslov = new JTextField();
			textFieldNaslov.setColumns(10);
		}
		return textFieldNaslov;
	}
	private JButton getBtnPronadji() {
		if (btnPronadji == null) {
			btnPronadji = new JButton("Pronadji");
			btnPronadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					prikaziKnjige(GUIKontroler.pronadjiKnjige(textFieldNaslov.getText()));
				}
			});
		}
		return btnPronadji;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
	
	public void prikaziKnjige(LinkedList<Knjiga> knjige) {
		list.setListData(knjige.toArray());
	}
}
