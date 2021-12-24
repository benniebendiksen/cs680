package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class Directory extends FSElement {

	private FileSystem fileSystem; 
    private LinkedList<FSElement> childs; 

    public Directory(Directory parent,
            String name,
            LocalDateTime creation) {
        super(parent, name, 0, creation);
        fileSystem = FileSystem.getFileSystem();
        childs = new LinkedList<FSElement>();
    }
 
	public void appendChild(FSElement child) {
    	this.childs.add(child);
    	child.setParent(this);
    }

    public LinkedList<FSElement> getChildren() {
        return this.childs;
    }

	public LinkedList<File> getFiles() {
		LinkedList<File> files = new LinkedList<File>();
	   for (FSElement element: this.getChildren() ) 
		   
		   if(!element.isDirectory())
			   files.add((File) element);
	   
	   return files;
   }

    public LinkedList<Directory> getDirectories() {
   	 LinkedList<Directory> dirs = new LinkedList<Directory>();
		for (FSElement element: this.getChildren() ) 
			
			if(element.isDirectory())
				dirs.add((Directory) element);
		
		return dirs;
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