package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import common.File_Reader;
import common.ISong;

import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.function.Predicate;

public class MusicGenie extends JFrame {
	private JTextArea taSource;
	private JTextField tfBand;
	private JComboBox<String> cbGenre;
	private JTextField tfRelease;
	private JTextField tfSongName;
	private JButton btnSearch;
	private JMenuItem mntmAbout;
	public SearchResults searchresult;
	private JMenuItem mntmExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		File_Reader.ReadSongs();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicGenie frame = new MusicGenie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MusicGenie() {
		initComponents();
		EventHandler();
	}

	private void initComponents() {

		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusicGenie.class.getResource("/resources/lamp.png")));
		setTitle("Music Genie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 692);

		JMenuBar MenBar_Genie = new JMenuBar();
		setJMenuBar(MenBar_Genie);

		JMenu mnFile = new JMenu("File");
		MenBar_Genie.add(mnFile);

		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		MenBar_Genie.add(mnEdit);

		JMenu mnEditSource = new JMenu("Source");
		mnEdit.add(mnEditSource);

		JMenu mnAbout = new JMenu("Help");
		MenBar_Genie.add(mnAbout);

		mntmAbout = new JMenuItem("About");

		mnAbout.add(mntmAbout);

		JScrollPane scrollPane_List = new JScrollPane();

		JLabel lbl_List = new JLabel("List from Source: ");
		lbl_List.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel pnlSearch = new JPanel();
		pnlSearch.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JLabel lblWelcome = new JLabel("Welcome to Music Genie. In the List from Source below you will find contents of a txt file or cvs file that contains music information. As the user you may search through the contents to find out more detials.");

		JLabel version_Label = new JLabel("Version 0.1");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(19)
								.addComponent(lbl_List)
								.addGap(18)
								.addComponent(scrollPane_List, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(pnlSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(92))
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(39)
								.addComponent(lblWelcome)
								.addContainerGap(39, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(version_Label)
								.addContainerGap(1019, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(39)
								.addComponent(lblWelcome)
								.addGap(12)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(81)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(lbl_List, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
														.addComponent(scrollPane_List, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(74)
												.addComponent(pnlSearch, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
								.addComponent(version_Label))
		);

		JLabel lblSearchBand = new JLabel("Search by Band or Artist");

		JLabel lblSearchGenre = new JLabel("Search by Genre");

		JLabel lblSearchByRelease = new JLabel("Search by Release date");

		JLabel lblSearchSongname = new JLabel("Search by Song name");

		tfBand = new JTextField();
		tfBand.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		// Define an array of predefined genres

		cbGenre = new JComboBox<>();
		String[] predefinedGenres = {"Rock", "Djent", "Hip-Hop", "Jazz", "Electronic", "Classical"};

		// Populate the combo box with the predefined genres
		for (String genre : predefinedGenres) {
			cbGenre.addItem(genre);
		}
		cbGenre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		tfRelease = new JTextField();
		tfRelease.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		tfSongName = new JTextField();
		tfSongName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSearch = new JButton("Search");

		GroupLayout gl_pnlSearch = new GroupLayout(pnlSearch);
		gl_pnlSearch.setHorizontalGroup(
				gl_pnlSearch.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlSearch.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_pnlSearch.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblSearchByRelease, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSearchSongname, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSearchGenre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSearchBand, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pnlSearch.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSearch)
										.addComponent(tfBand, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbGenre, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfRelease, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfSongName, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_pnlSearch.setVerticalGroup(
				gl_pnlSearch.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlSearch.createSequentialGroup()
								.addGap(35)
								.addGroup(gl_pnlSearch.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSearchBand)
										.addComponent(tfBand, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_pnlSearch.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSearchGenre)
										.addComponent(cbGenre, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_pnlSearch.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSearchByRelease)
										.addComponent(tfRelease, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_pnlSearch.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSearchSongname)
										.addComponent(tfSongName, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnSearch)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlSearch.setLayout(gl_pnlSearch);

		taSource = new JTextArea();
		taSource.setEditable(false);
		scrollPane_List.setViewportView(taSource);
		getContentPane().setLayout(groupLayout);

	}


	private void EventHandler() {

		//Populates the TextAreaSource with SongList//
		for(ISong a : File_Reader.SongList){
			taSource.append(a + "\n");
		}

// Event starts when the user hits the search button
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchresult = new SearchResults();

				// If user types in nothing
				if (tfBand.getText().isEmpty() && cbGenre.getSelectedItem() != null && tfRelease.getText().isEmpty() && tfSongName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must enter something to search.\nPlease try again..");
					System.out.println("Search for nothing");
					return;
				}

				// Prepare the predicates based on user input
				ArrayList<Predicate<ISong>> predicates = new ArrayList<>();
				if (!tfBand.getText().isEmpty()) {
					String band = tfBand.getText();
					predicates.add(song -> song.getBand().equals(band));
					System.out.println("Search for band");
				}
				if (cbGenre.getSelectedItem() != null) {
					String genre = cbGenre.getSelectedItem().toString();
					predicates.add(song -> song.getGenre().equals(genre));
					System.out.println("Search for genre");
				}
				if (!tfRelease.getText().isEmpty()) {
					String releaseDate = tfRelease.getText();
					predicates.add(song -> song.getRlsDate().equals(releaseDate));
					System.out.println("Search for release date");
				}

				// Perform search
				if (!predicates.isEmpty()) {
					File_Reader.SearchSongs(searchresult, predicates.toArray(new Predicate[0]));
				}

				searchresult.setModal(true);
				searchresult.setVisible(true);
			}
		});



		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setModal(true);
				about.setVisible(true);
			}
		});


		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
	}
}