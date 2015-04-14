package blog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.*;

import base.Post;
import base.User;


public class BlogGUI implements ActionListener {

	private JFrame mainFrame;
	private JTextArea postTextArea, postContent;
	//private JTextField postContent;
	private JButton refresh;
	private JButton post;
	private JLabel textLabel;
	private Blog myBlog = new Blog(new User(1, "COMP3021", "COMP3021@cse.ust.hk"));
	
	final int maxOfText = 140;
	
	public BlogGUI(){}
	
	class postListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			String content = postTextArea.getText();
			if(content == null){return;}
			if(content.length()>140){
				postContent.setText("The text is exceed 140");
				postTextArea.setText("");
				return;
			}
			Post post = new Post(new Date(), content);
			myBlog.post(post);
			postContent.setText("One post added");
			postTextArea.setText("");
//			String savefilepath="C:/"+myBlog.getUser().getUserName()+".blog";
//			myBlog.save(savefilepath);
			
		}

	}
	class refreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
//			String loadfilepath="C:/"+myBlog.getUser().getUserName()+".blog";
//			myBlog.load(loadfilepath);
			postContent.setText(myBlog.toString());
			
			
		}
	}
	class lengthListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			updateTextLength();
		}
		
	}
	public void setWindow(){
		mainFrame = new JFrame("Micro Blog Demo");
		postTextArea = new JTextArea(1,140);
		postTextArea.setBackground(new Color(255,255,204));
		postTextArea.setLineWrap(true);
		postTextArea.addKeyListener(new lengthListener());
		postContent = new JTextArea("This is my Blog");
		postContent.setBackground(new Color(240,240,240));
		postContent.setLineWrap(true);
		postContent.setEditable(false);
		refresh = new JButton("Refresh");
		refresh.setBackground(new Color(176, 196, 222));
		post = new JButton("Post");
		post.setBackground(new Color(135, 206, 250));
		post.addActionListener(new postListener());
		refresh.addActionListener(new refreshListener());
		JPanel top = new JPanel();
		//top.setBorder(new  );
		top.setLayout(new BorderLayout());
		
		
		mainFrame.setSize(600, 600);
		mainFrame.setLayout(new GridLayout(0,1));
		
		textLabel = new JLabel("You can still input " + maxOfText + " Character");
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
	
	
	public void updateTextLength() {
		int lengthOftext = postTextArea.getText().length();
		if(lengthOftext > 140){
			textLabel.setText("Your post length has exceeded 140 words!");
		}
		else{
			textLabel.setText("You can still input " +( maxOfText- lengthOftext) + " Character");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
