package edu.umb.cs680.hw14.APFS.util;
import edu.umb.cs680.hw14.APFS.*;
public class ApfsCountingVisitor implements ApfsVisitor{

	private int dirVisits = 0;
	private int fileVisits = 0;
	private int linkVisits = 0;

	public void visit(ApfsDirectory dir) {
		dirVisits++;
		
	}

	public void visit(ApfsLink link) {
		linkVisits++;
		
	}

	
	public void visit(ApfsFile file) {
		fileVisits++;	
	}
	
	public int getDirVisits() {
		return dirVisits;
	}
	
	public int getLinkVisits() {
		return linkVisits;
	}
	
	public int getFileVisits() {
		return fileVisits;
	}
}