package blog;

import base.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
public class Blog implements Serializable{
	private User user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user){
		this.user = user;
		allPosts = new ArrayList<Post>();
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public void setPosts(ArrayList<Post> p ){
		allPosts = p;
	}
	public void post(Post p){
		
		//System.out.println(this.allPosts.size());
		this.allPosts.add(p);
		System.out.println("A new Post: "+'\n' + p.toString());
	}
	
	public void list(){
		System.out.println("Current posts: " +'\n');
		for(int i = 0 ; i<allPosts.size();i++){
			System.out.println("Post["+ (i+1) +"]: "+ allPosts.get(i).toString());
		}
	}
	
	public void delete (int index){
		if(index<=0 || index> allPosts.size()){
			System.out.println("Illegal deletion.");
		}
		else{
			allPosts.remove(index-1);
		}
	}
	
	@Override
	public String toString(){
		String temp;
		temp = user.toString() + '\n';
		for(int i =0; i<allPosts.size();i++){
			temp = temp + allPosts.get(i).toString() + '\n';
		}
		temp  = temp + '\n';
		return temp;
	}
	
	@Override
	public int hashCode(){
		int hashCode = 1;
		int prime = 11;
		
		hashCode = hashCode * prime + user.hashCode();
//		for(int i =0; i<allPosts.size();i++){
//			hashCode = hashCode * prime + allPosts.get(i).hashCode();
//		}
//		
		
		return hashCode;
	}
	
	@Override
	public boolean equals(Object o){
		boolean ans = true;
		
		if(o==null || !(this.getClass().equals(o.getClass()))){
			return false;
		}
		Blog blog = (Blog) o;
		if(this.user != blog.user){
			ans = false;
		}
		return ans;
		//		for(int i =0; i<allPosts.size();i++){
		//			allPosts.equals(o);
		//		}
	}
	
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		
		for(Post p:allPosts){
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			
			if((month-1) == postMonth){
				if(p.contains(someone)){
					System.out.println(p.toString());
				}
			}
		}
	}
	
	public void save(String filepath){
		
			ObjectOutputStream os;
			try {
				os = new ObjectOutputStream(new FileOutputStream(filepath));
				os.writeObject(this);
				os.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	

		
	}
	
	public void load(String filepath){
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(filepath));
			try {
				Blog blog = (Blog) is.readObject();
				this.allPosts = blog.allPosts;
				this.user = blog.user;
				is.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				is.close();
			}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Wait! There is something wrong. I cannot find the file..");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
}
