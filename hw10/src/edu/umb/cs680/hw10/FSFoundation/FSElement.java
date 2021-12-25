package edu.umb.cs680.hw10.FSFoundation;
import java.time.LocalDateTime;




public abstract class FSElement {
  protected FSElement parent;
  protected String name;
  private int size;
  private LocalDateTime creationTime;

  protected FSElement(FSElement parent,
          String name,
          int size,
          LocalDateTime creationTime) {
  	
  	this.parent = parent;
  	this.name = name;
  	this.size = size;
  	this.creationTime = creationTime;
  }
  
	public String getName() {
		return this.name;
	}
	
  public FSElement getParent(){
  	return this.parent;
  }
  
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}
	
  public int getSize() {
  	return this.size;
  }
	
  public void setParent(FSElement parent) {
  	this.parent = parent;
  }
  
  public void setName(String name) {
  	this.name = name;
  }
  
  public void setSize(int size) {
  	this.size = size;
  }
  
  public void setCreationTime(LocalDateTime creationTime) {
  	this.creationTime = creationTime;
  }

  public abstract Boolean isDirectory(); 
  
  public abstract Boolean isFile();    

  public abstract Boolean isLink();  
  
  
  public static void main(String args[]) {

	}


  
}