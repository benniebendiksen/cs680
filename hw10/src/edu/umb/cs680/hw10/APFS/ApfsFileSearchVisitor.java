package edu.umb.cs680.hw10.APFS;
import edu.umb.cs680.hw10.APFS.*;
import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsVisitor{

	private String fileName;


	ApfsFileSearchVisitor (String fileName){
		this.fileName = fileName; 
	}

	private LinkedList<ApfsFile> filesGrabbed = new LinkedList<ApfsFile>();
	

	@Override
	public void visit(ApfsLink link) {
		return;
	}

	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}

	@Override
	public void visit(ApfsFile file) {
		if (file.getName().equals(fileName)) 
			filesGrabbed.add(file);
	}
	
	public LinkedList<ApfsFile> getFoundFiles(){
		return filesGrabbed;
	}


}
