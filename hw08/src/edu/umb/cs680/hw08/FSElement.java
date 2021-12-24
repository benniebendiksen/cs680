package edu.umb.cs680.hw08;
import java.time.LocalDateTime;

public abstract class FSElement {

  protected Directory parent;
  private String name;
  private int size;
  private LocalDateTime creation;

  public FSElement(Directory parent,
          String name,
          int size,
          LocalDateTime creation) {
  	
  	this.parent = parent;
    this.creation = creation;
  	this.name = name;
  	this.size = size;
  }
  
	public String getName() {
		return this.name;
	}
	
  public int getSize() {
  	return this.size;
  }
  
  public Directory getParent(){
  	return this.parent;
  }
  
	public LocalDateTime getCreation() {
		return this.creation;
	}
	
  public void setParent(Directory parent) {
  	this.parent = parent;
  }
  
  public void setName(String name) {
  	this.name = name;
  }
  
  public void setCreationTime(LocalDateTime creation) {
  	this.creation = creation;
  }

  public void setSize(int size) {
  	this.size = size;
  }


  public abstract Boolean isDirectory(); 
  
  public abstract Boolean isFile();    

  public abstract Boolean isLink();  
  
  public static void main(String args[]) {}
  
}