package com.notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aboutNotepad extends JFrame implements ActionListener{

	ImageIcon image = new ImageIcon("src//notepad.png");
	JPanel panel1;
	JButton b1;
	
	aboutNotepad(){
		this.setSize(700,600);
		this.setTitle("About Notepad");
		this.setIconImage(image.getImage());
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(null);
		
		ImageIcon i1 = new ImageIcon("src//window.png");
		Image i2 = i1.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		panel1 = new JPanel();
		panel1.setBounds(10,10,580,100);
		panel1.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel(i3);
		
		
		JLabel label2 = new JLabel("Windows 10");
		label2.setBounds(10,10,350,100);
		label2.setFont(new Font("MV Boli",Font.PLAIN,50));
		
		panel1.add(label1);
		panel1.add(label2);
		
		JLabel l3 = new JLabel("<html>Code for Interview<br>Youtube Channel Version 2021<br>2021 Code for Interview. All rights reserved<br><br>Notepad is a word processing program, <br>which allows changing of text in a computer file.<br>Notepad is a simple text editor for basic text-editing program<br> which enables computer users to create documents. </html>");
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        l3.setBounds(150, 130, 500, 300);
        
        
        b1 = new JButton("OK");
        b1.setBounds(580, 500, 80, 25);
        b1.addActionListener(this);
        
		
		this.add(panel1);
		this.add(l3);	
		this.add(b1);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1) {
			this.setVisible(false);
		}
	}
	
}
