package edu.umb.cs680.hw10.APFS;
public interface ApfsVisitor{
	public void visit(ApfsDirectory dir);
	public void visit(ApfsFile file);
	public void visit(ApfsLink link);

}
