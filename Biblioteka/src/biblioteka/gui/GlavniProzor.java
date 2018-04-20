package biblioteka.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import biblioteka.Knjiga;
import biblioteka.gui.kontroler.GUIKontroler;

public class GlavniProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmNew;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JMenu mnRecentFiles;
	private JMenuItem mntmHellojava;
	private JSeparator separator;
	private JSeparator separator_1;
	private JPopupMenu popupMenu;
	private JMenuItem mntmOpen_1;
	private JMenuItem mntmSave_1;
	
	
	private JScrollPane scrollPane;
	private JList list;
	private JPanel panel;
	private JButton btnDodajKnjigu;
	private JButton btnObrisiKnjigu;
	private JButton btnPronadjiKnjigu;
	
	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				izlaz();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/icons/bluej-84-toned.jpg")));
		setTitle("Biblioteka");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 538, 295);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		addPopup(contentPane, getPopupMenu());
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmNew());
			mnFile.add(getSeparator_1());
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMnRecentFiles());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmNew() {
		if (mntmNew == null) {
			mntmNew = new JMenuItem("New");
			mntmNew.setMnemonic(KeyEvent.VK_N);
			mntmNew.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		}
		return mntmNew;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ucitaj();
				}
			});
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvaj();
				}
			});
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					izlaz();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Aplikacija biblioteka, autor Bojan Tomic",
							"O programu",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmAbout;
	}
	private JMenu getMnRecentFiles() {
		if (mnRecentFiles == null) {
			mnRecentFiles = new JMenu("Recent files");
			mnRecentFiles.add(getMntmHellojava());
		}
		return mnRecentFiles;
	}
	private JMenuItem getMntmHellojava() {
		if (mntmHellojava == null) {
			mntmHellojava = new JMenuItem("Hello.java");
		}
		return mntmHellojava;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private void izlaz() {
		int opcija = 
			JOptionPane.showConfirmDialog(
				null, "Da li zelite da izadjete?",
				"Izlazak", JOptionPane.YES_NO_OPTION);
		
		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmOpen_1());
			popupMenu.add(getMntmSave_1());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmOpen_1() {
		if (mntmOpen_1 == null) {
			mntmOpen_1 = new JMenuItem("Open");
			mntmOpen_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ucitaj();
				}
			});
			mntmOpen_1.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		}
		return mntmOpen_1;
	}
	private JMenuItem getMntmSave_1() {
		if (mntmSave_1 == null) {
			mntmSave_1 = new JMenuItem("Save");
			mntmSave_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvaj();
				}
			});
			mntmSave_1.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		}
		return mntmSave_1;
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
			panel.setPreferredSize(new Dimension(140, 10));
			panel.add(getBtnDodajKnjigu());
			panel.add(getBtnObrisiKnjigu());
			panel.add(getBtnPronadjiKnjigu());
		}
		return panel;
	}
	private JButton getBtnDodajKnjigu() {
		if (btnDodajKnjigu == null) {
			btnDodajKnjigu = new JButton("Dodaj knjigu");
			btnDodajKnjigu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziDodajKnjiguProzor();
				}
			});
		}
		return btnDodajKnjigu;
	}
	private JButton getBtnObrisiKnjigu() {
		if (btnObrisiKnjigu == null) {
			btnObrisiKnjigu = new JButton("Obrisi knjigu");
			btnObrisiKnjigu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziObrisiKnjiguProzor((Knjiga)(list.getSelectedValue()));
				}
			});
		}
		return btnObrisiKnjigu;
	}
	private JButton getBtnPronadjiKnjigu() {
		if (btnPronadjiKnjigu == null) {
			btnPronadjiKnjigu = new JButton("Pronadji knjigu");
			btnPronadjiKnjigu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziPronadjiKnjiguProzor();
				}
			});
		}
		return btnPronadjiKnjigu;
	}
	
	public void prikaziSveKnjige(LinkedList<Knjiga> knjige) {
		list.setListData(knjige.toArray());
	}

	
	
	
}
