package blog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BlogGUI implements ActionListener {

	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	final int maxOfText = 140;
	
	public BlogGUI(){}
	
	public void setWindow(){
		mainFrame = new JFrame("Micro Blog Demo");
		postTextArea = new JTextArea();
		postContent = new JTextField();
		refresh = new JButton("Refresh");
		post = new JButton("Post");
		post.addActionListener(this);
		refresh.addActionListener(this);
		JPanel top = new JPanel();
		//top.setBorder(new  );
		top.setLayout(new BorderLayout());
		
		
		mainFrame.setSize(600, 600);
		mainFrame.setLayout(new GridLayout(0,1));
		
		JLabel textLabel = new JLabel("You can still input " + maxOfText + " Character");
		top.add(textLabel, BorderLayout.NORTH);
		//postTextArea.setSize(40, 40);
		top.add(postTextArea, BorderLayout.CENTER);
		
		JPanel hi = new JPanel();
		hi.setLayout(new GridLayout(0,2));
		hi.add(refresh);
		hi.add(post);
		
		top.add(hi, BorderLayout.SOUTH);
		
		

		
		mainFrame.add(top);
		
		mainFrame.add(postContent);
		mainFrame.setVisible(true);	
		
		
		
		
	}
	
	public static void main(String[] args){
		BlogGUI blogGUi = new BlogGUI();
		blogGUi.setWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == post){
			postContent.setText("Post");
		}
		if(e.getSource() == refresh)
			postContent.setText("Refresh");
		
	}
}
