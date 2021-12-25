package edu.umb.cs680.hw10.APFS;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;



public class ApfsDirectory extends ApfsElement {


    private LinkedList<ApfsElement> children; 

    public ApfsDirectory(ApfsDirectory parent,
            String name,
            LocalDateTime creation) {
        super(parent, name, 0, creation, name, creation);
        if(name.length() > 255) this.name = name.substring(0, 255);
        children = new LinkedList<ApfsElement>();
    }
 
	public LinkedList<ApfsFile> getFiles() {
		LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
	   for (ApfsElement element: this.getChildren() ) 
		   
		   if(element.isFile())
			   files.add((ApfsFile) element);
	   
	   return files;
   }
    
    public LinkedList<ApfsElement> getChildren() {
        return this.children;
    }
    
    public void appendChild(ApfsElement child) {
    	this.children.add(child);
    	child.setParent(this);
    }

	@Override
	public void accept(ApfsVisitor v) {
		v.visit(this);
		for(ApfsElement child: children) child.accept(v);
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