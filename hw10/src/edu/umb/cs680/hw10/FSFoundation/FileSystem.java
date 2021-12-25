package edu.umb.cs680.hw10.FSFoundation;
import java.util.LinkedList;


public abstract class FileSystem {
	protected static String name;
	protected static int capacity;
	protected static int id;
	

	protected LinkedList<FSElement> rootDirs;

	protected FileSystem() {
		rootDirs = new LinkedList<FSElement>();
		};
	
	protected FSElement initFileSystem(String name, int capacity) {
		 this.name = name;
		 this.capacity = capacity;
		 FSElement root = createDefaultRoot();
		 
		 
		 if(root.isDirectory() && capacity >= root.getSize()) {
			 setRoot(root);
			 this.id = root.hashCode();
			 return root;
		 } else {
			 throw new RuntimeException("Null Exception");			 
		 }
	
    }

	protected abstract FSElement createDefaultRoot();
    
	protected abstract void setRoot(FSElement root);
	

	public int getCapacity() {
		return this.capacity;
	}
	
	public String getName() {
		return this.name;
	}

 
    
    	
    
}
