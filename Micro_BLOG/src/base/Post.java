package base;

import java.util.Date;
import java.lang.Object;
public class Post {
	private Date date;
	private String content;
	
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String toString(){
		String temp;
		temp = this.date.toString();
		temp = temp + ' ' + content;
		return temp;
	}
	
	public boolean equals(Object o){
		boolean ans = true;
		
		if(!this.equals(o)){
			ans = false;
		}
		if(o==null || !(this.getClass().equals(o.getClass()))){
			return false;
		}
		
		
		Post post = (Post) o;
		if(!this.getContent().equals(post.getContent())||!this.date.equals(post.date)){
			ans = false;
		}
		return ans;	
	}
	
	public int hashCode(){
		int hashCode = 1;
		int prime = 7;
		hashCode = hashCode * prime + date.hashCode();
		
		hashCode = hashCode * prime + content.hashCode();
		
		return hashCode;
		
		
	}
	public boolean contains(String keyword){
		
		return  ;
		
	}
}
