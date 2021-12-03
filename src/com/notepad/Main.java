package com.notepad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends JFrame implements ActionListener{
	
	JTextArea area;
	JScrollPane scroll;
	JMenuItem NEW;
	JMenuItem NEW_W;
	JMenuItem save;
	JMenuItem open;
	JMenuItem saveAs;
	JMenuItem exit;
	JMenuItem print;
	JMenuItem copy;
	JMenuItem cut;
	JMenuItem paste;
	JMenuItem selectall;
	JMenuItem viewhelp;
	JMenuItem feedback;
	JMenuItem wordwrap;
	JMenuItem font;
	JMenuItem about;
	String text1;
	ImageIcon image = new ImageIcon("src//notepad.png");
	Font font1 = new Font("MV Boli",Font.PLAIN,20);
	
	Main(){
		
		this.setSize(1600,850);
		this.setTitle("Notepad");
		this.setIconImage(image.getImage());
		//this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		JMenu file = new JMenu("file");
		file.setFont(font1);
		
		 NEW = new JMenuItem("New");
		NEW.setAccelerator(KeyStroke.getKeyStroke('N',ActionEvent.CTRL_MASK));
		NEW.addActionListener(this);
		
		file.add(NEW);
		
		 NEW_W = new JMenuItem("New Window");
		NEW_W.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		NEW_W.addActionListener(this);
		
		file.add(NEW_W);
		
		 open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke('O',ActionEvent.CTRL_MASK));
		open.addActionListener(this);
		
		file.add(open);
		
		
		 save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke('S',ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		
		file.add(save);
		
		
		 saveAs = new JMenuItem("Save as");
		saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		saveAs.addActionListener(this);
		
		file.add(saveAs);
		
		JMenuItem print = new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		print.addActionListener(this);
		
		file.add(print);
		
		 exit = new JMenuItem("Exit");
		//exit.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_ESCAPE));
		exit.addActionListener(this);
		
		file.add(exit);
		
		////////////////////////////////////////////////////////////////////////////////////
		JMenu edit = new JMenu("edit");
		edit.setFont(font1);
		
		 copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		copy.addActionListener(this);
		
		edit.add(copy);
		
		 cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		cut.addActionListener(this);
		
		edit.add(cut);
		
		 paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		paste.addActionListener(this);
		
		edit.add(paste);
		
		 selectall = new JMenuItem("Select all");
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		selectall.addActionListener(this);
		
		edit.add(selectall);
		
		/////////////////////////////////////////////////////////////////////////////////////////
		JMenu format = new JMenu("format");
		format.setFont(font1);
		
		 wordwrap = new JMenuItem("Word Wrap");
		//wordwrap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
		format.add(wordwrap);
		
		 font = new JMenuItem("Font");
		//font.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
		format.add(font);
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		//JMenu view = new JMenu("view");
		
		//////////////////////////////////////////////////////////////////////////////////////
		JMenu help = new JMenu("help");
		help.setFont(font1);
		
		 viewhelp = new JMenuItem("view Help");
		 viewhelp.addActionListener(this);
		//wordwrap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
		help.add(viewhelp);
		
		 feedback = new JMenuItem("Send Feedback");
		 feedback.addActionListener(this);
		//feedback.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
		help.add(feedback);
		
		 about = new JMenuItem("About notepad");
		 about.addActionListener(this);
		
		help.add(about); 
		/////////////////////////////////////////////////////////////////////////////////////
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		//menuBar.add(view);
		menuBar.add(help);
		
		this.setJMenuBar(menuBar);
		
		
		area = new JTextArea();
		area.setFont(new Font("MV Boli",Font.PLAIN,20));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		scroll = new JScrollPane(area);
		
		this.add(scroll, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main().setVisible(true);;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == NEW) {
			area.setText("");
		}
		else if(e.getSource() == save) {
			JFileChooser savefile = new JFileChooser();
			int res = savefile.showOpenDialog(this);
			if(res != JFileChooser.APPROVE_OPTION) {
				return;
			}
			
			File file = new File(savefile.getSelectedFile() + ".txt");
			BufferedWriter outFile;
			try {
				outFile = new BufferedWriter(new FileWriter(file));
				area.write(outFile);
			}
			catch(Exception err) {
				
			}
			
		}
		else if(e.getSource() == open){
			JFileChooser chooser = new JFileChooser(); 
			chooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("only txt file","txt");
			chooser.addChoosableFileFilter(restrict);
			
			int res = chooser.showOpenDialog(this);
			if(res != JFileChooser.APPROVE_OPTION) {
				return;
			}
			File file = chooser.getSelectedFile();
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				area.read(reader,null);
			}
			catch(Exception err) {
				
			}
		}
		else if(e.getSource()==print) {
			try {
				area.print();
			}
			catch(Exception err) {
				System.out.println("print error");
			}
		}
		else if(e.getSource()==exit) {
			System.exit(0);
		}
		
		else if(e.getSource()==copy) {
			text1 = area.getSelectedText();
			
		}
		else if(e.getSource()==paste) {
			area.insert(text1, area.getCaretPosition());
		}
		else if(e.getSource() == cut) {
			 text1 = area.getSelectedText();
			 area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
		}
		else if(e.getSource() == selectall) {
			area.selectAll();
		}
		else if(e.getSource() == viewhelp) {
			try {
				Desktop.getDesktop().browse(new URI("https://www.bing.com/search?q=get+help+with+notepad+in+windows&filters=guid:%224466414-en-dia%22%20lang:%22en%22&form=T00032&ocid=HelpPane-BingIA"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==about) {
			new aboutNotepad();
		}
		else {}
	}

}
