package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import base.Post;
import base.User;


public class BlogGUI implements ActionListener {

	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	private Blog myBlog = new Blog(new User(1,"2","3"));
	
	final int maxOfText = 140;
	
	public BlogGUI(){}
	
	class postListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			String content = postTextArea.getText();
			if(content == null){return;}
			if(content.length()>140){
				System.out.println("The text is exceed 140");
				return;
			}
			Post post = new Post(new Date(), content);
			myBlog.post(post);
			
		}

	}
	class refreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			//postContent.add(myBlog.list());
			
		}
	}
	public void setWindow(){
		mainFrame = new JFrame("Micro Blog Demo");
		postTextArea = new JTextArea();
		postContent = new JTextField();
		refresh = new JButton("Refresh");
		refresh.setBackground(new Color(176, 196, 222));
		post = new JButton("Post");
		post.setBackground(new Color(135, 206, 250));
		post.addActionListener(new postListener());
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
