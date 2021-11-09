package edu.umb.cs680.hw07;

import java.time.LocalDateTime;


public abstract class FSElement {

  protected Directory parent;
  private int size;
  private String name;
  private LocalDateTime creationTime;

  public FSElement(Directory parent,
          String name,
          int size,
          LocalDateTime creationTime) {
  	
  	this.parent = parent;
  	this.name = name;
  	this.size = size;
  	this.creationTime = creationTime;
  }
  
  public Directory getParent(){
	  	return this.parent;
	  }
  
  public int getSize() {
	  	return this.size;
	  }
  
  public String getName() {
		return this.name;
	}
  
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}
	
  public void setParent(Directory parent) {
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
   

  public static void main(String args[]) {}
  
}