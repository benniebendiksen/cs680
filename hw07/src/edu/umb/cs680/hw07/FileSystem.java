package edu.umb.cs680.hw07;


import java.util.LinkedList;


public class FileSystem {
	
	private static FileSystem INSTANCE;
	private LinkedList<Directory> rootDirectories = new LinkedList<Directory>();
	
	private FileSystem() {
		};
	//example of Static Factory Method
	public static FileSystem getFileSystem() {
		if(INSTANCE==null) 
			INSTANCE = new FileSystem();
			return INSTANCE;
	}
	
	public LinkedList<Directory> getRootDirs() {
        return this.rootDirectories;
    }
	
    public void appendRootDir(Directory root) {
    	if (root.getParent()==null)
    	this.rootDirectories.add(root);

    }
    
    public int sizeRootDirs() {
    	return this.getRootDirs().size();
    }
    
    public LinkedList<String> getSubDirectoriesNames() {
    	LinkedList<String> subDirNames = new LinkedList<String>();
		for (Directory d:  this.getRootDirs()) 
			for (Directory subD: d.getSubDirectories()) 
			subDirNames.add(subD.getName());
		return subDirNames;
    }
    
    public LinkedList<File> getRootFiles() {
    	LinkedList<File> rootfiles = new LinkedList<File>();
		for (Directory element:  this.getRootDirs()) 
			for (File subElement:  element.getFiles()) 
				rootfiles.add(subElement);
		return rootfiles;
    }
    	
    
}
