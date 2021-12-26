package edu.umb.cs680.hw12.APFS;
public interface ApfsVisitor{
	public void visit(ApfsDirectory dir);
	public void visit(ApfsFile file);
	public void visit(ApfsLink link);

}
