package edu.umb.cs680.hw14.APFS;

import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw14.FSFoundation.FSElement;
import edu.umb.cs680.hw14.FSFoundation.FileSystem;


public class APFS extends FileSystem {	
	private APFS() {};
	private static APFS instance = null;

	public static APFS getFileSystem() {
		if(instance==null) 
			instance =  new APFS();
			instance.initFileSystem("Default Root", 50000);
			return instance;
	}

	
	@Override
	protected void setRoot(FSElement root) {	
		if (rootDirs.size() < 1) {
			root.setCreationTime(LocalDateTime.of(2019, 12, 20, 4, 30));
			rootDirs.add(root);
		}
	}   

	@Override
	public FSElement createDefaultRoot() {
		 return new ApfsDirectory(null, name,  LocalDateTime.now());
	}

    public ApfsDirectory getRootDir() {
    	int ONLY_DIR=0;
		return (ApfsDirectory) rootDirs.get(ONLY_DIR);

    }


    public LinkedList<ApfsFile> getRootFiles() {
    	LinkedList<ApfsFile> rootfiles = new LinkedList<ApfsFile>();
			for (ApfsFile dir:  this.getRootDir().getFiles()) 
				rootfiles.add(dir);
		return rootfiles;
    }
    
    
    public LinkedList<String> getRootFilesNames() {
    	LinkedList<String> rootfiles = new LinkedList<String>();
			for (ApfsFile dir:  this.getRootDir().getFiles()) 
				rootfiles.add(dir.getName());
		return rootfiles;
    }
    
 
    protected void deleteApfs() {
    	Object Apfs = instance.initFileSystem("", 0);
    	Apfs = null;
    	super.rootDirs.clear();
    }





}
