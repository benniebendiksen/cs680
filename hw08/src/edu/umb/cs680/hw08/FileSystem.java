package edu.umb.cs680.hw08;
import java.util.LinkedList;


public class FileSystem {
	
	private static FileSystem instance = null;
	private LinkedList<Directory> rootDirectories;
	
	private FileSystem() {
		rootDirectories = new LinkedList<Directory>();
		};
	
	public static FileSystem getFileSystem() {
		if(instance==null) 
			instance = new FileSystem();
			return instance;
	}
	
    public void appendRootDir(Directory dir) {
    	if (dir.getParent()==null)
    	this.rootDirectories.add(dir);

    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirectories;
    }
    	
    
}
