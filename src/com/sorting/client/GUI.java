package com.sorting.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	
	public String sourceFileName = "";
	public String targetFileName = "";
	public String sortMethod = "";
	private JTextField outputTextField;
	private JTextField sourceTextFile;
	private SortMethod method = new SortMethod();
	private Utility fileOpener = new Utility();
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//SOurce Text File
		sourceTextFile = new JTextField();
		sourceTextFile.setEditable(false);
		sourceTextFile.setBounds(145, 52, 276, 26);
		contentPane.add(sourceTextFile);
		sourceTextFile.setColumns(10);
		
		//Button to open JFileChooser
		JButton OpenFileBtn = new JButton("Open File ...");
		OpenFileBtn.setBounds(25, 52, 119, 29);
		OpenFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT (*.txt, *.text)","txt", "text");
				jFileChooser.setFileFilter(filter);
				jFileChooser.setDialogTitle("Select file");
				int result = jFileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					sourceFileName = file.getAbsolutePath();
					sourceTextFile.setText(sourceFileName);
				}
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(OpenFileBtn);
		
		outputTextField = new JTextField();
		outputTextField.setEditable(false);
		outputTextField.setBounds(145, 177, 276, 26);
		contentPane.add(outputTextField);
		outputTextField.setColumns(10);
		

		JButton btnSaveAs = new JButton("Save As");
		btnSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT (*.txt, *.text)","txt", "text");
				jFileChooser.setFileFilter(filter);
				jFileChooser.setDialogTitle("Save File");
				int result = jFileChooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					targetFileName = file.getAbsolutePath();
					targetFileName+= ".txt";
					outputTextField.setText(targetFileName);
				}
				
			}
		});
		btnSaveAs.setBounds(25, 177, 117, 29);
		contentPane.add(btnSaveAs);
		
		//Button to trigger the sort
		JButton SortBtn = new JButton("Sort");
		SortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!sortMethod.equals("")) {
					method.setMethod(sortMethod);
				}
				
				
				List<Integer> numbers = new ArrayList<Integer>();
				try {
					numbers = fileOpener.ReadFile(sourceFileName);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				method.sortArray(numbers);
				String path = outputTextField.getText();
				
				fileOpener.WriteFile(numbers, path);
			}
		});
		SortBtn.setBounds(25, 220, 119, 29);
		contentPane.add(SortBtn);
		
		JList list = new JList();
		list.setBounds(68, 182, 1, 1);
		contentPane.add(list);
		
		//Radio button for choosing MERGE or QUICK sort
		JRadioButton mergeBtn = new JRadioButton("Merge Sort");
		mergeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortMethod = "MERGE";
			}
		});
		mergeBtn.setBounds(25, 98, 141, 23);
		contentPane.add(mergeBtn);
		
		JRadioButton quickBtn = new JRadioButton("Quick Sort");
		quickBtn.setSelected(true);
		quickBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortMethod = "QUICK";
			}
		});
		quickBtn.setBounds(25, 133, 141, 23);
		contentPane.add(quickBtn);
		
		//Add Radio button to the group so that only 1 option can be selected at a time
		ButtonGroup group = new ButtonGroup();
		group.add(quickBtn);
		group.add(mergeBtn);
		
		
		
		
		
		
		
		
	}
}
