package edu.umb.cs680.hw08;


import java.time.LocalDateTime;
import java.util.LinkedList;



public class Directory extends FSElement {

	private FileSystem fileSystem; 
    private LinkedList<FSElement> children; 

    public Directory(Directory parent,
            String name,
            LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        fileSystem = FileSystem.getFileSystem();
        children = new LinkedList<FSElement>();
    }
 
    
    public LinkedList<FSElement> getChildren() {
        return this.children;
    }
    
    public void appendChild(FSElement child) {
    	this.children.add(child);
    	child.setParent(this);
    }

    public int countChildren() {
		int childrenCount = 0;
		for (FSElement element: this.getChildren() ) 
			childrenCount++;
		
		return childrenCount;
    	
    }

    public LinkedList<Directory> getSubDirectories() {
   	 LinkedList<Directory> dirs = new LinkedList<Directory>();
		for (FSElement element: this.getChildren() ) 
			
			if(element.isDirectory())
				dirs.add((Directory) element);
		
		return dirs;
   }
    
    public LinkedList<File> getFiles() {
    	 LinkedList<File> files = new LinkedList<File>();
		for (FSElement element: this.getChildren() ) 
			
			if(!element.isDirectory())
				files.add((File) element);
		
		return files;
    }
    
    public int getCurrentDirsFileSizes() {
    	int dirSize = 0;
    	
		for (FSElement element:  this.getChildren() ) {
	    		dirSize += element.getSize();
	    	}
		return dirSize;
    }

    public int getTotalSize() {
    	int total = 0;  
    	int fileSizes = 0;
    	int subDirsSizes = 0;
    	int currDirSize = this.getSize();
    	
    	
		for (File file:  this.getFiles() ) {
			fileSizes += file.getSize();
    	}

		for (Directory dir:  this.getSubDirectories() ) {
			subDirsSizes += dir.getTotalSize();
    	}
		
		
		total = currDirSize + fileSizes +  subDirsSizes;
		
    	return total;
    }
		


	@Override
	public Boolean isDirectory() {
		return true;
	}

	@Override
	public Boolean isFile() {
		return false;
	}


	@Override
	public Boolean isLink() {
		return false;
	}
}