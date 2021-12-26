package edu.umb.cs680.hw14.APFS.util;
import edu.umb.cs680.hw14.APFS.*;
import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsVisitor{

	private LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
	
	@Override
	public void visit(ApfsDirectory dir) {
		return;		
	}

	@Override
	public void visit(ApfsFile file) {
		files.add(file);
	}
	
	@Override
	public void visit(ApfsLink link) {
		return;
	
	}
	
	public LinkedList<ApfsFile> getFiles(){
		return files;
	}

}
