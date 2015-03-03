package blog;

import base.*;

import java.util.ArrayList;
public class Blog {
	private User user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user){
		this.user = user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public void post(Post p){
		allPosts.add(p);
		System.out.println("succeed to add a post " + p.toString());
	}
	
	public void list(){
		for(int i = 0 ; i<allPosts.size();i++){
			System.out.println(allPosts.get(i).toString());
		}
	}
	
	public void delete (int index){
		if(index<0 || index>= allPosts.size()){
			System.out.println(" The index should be neither too high nor negative");
		}
		else{
			allPosts.remove(index);
		}
	}
	
	@Override
	public String toString(){
		String temp;
		temp = user.toString();
		for(int i =0; i<allPosts.size();i++){
			temp = temp + allPosts.get(i).toString();
		}
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
	
}
