package edu.umb.cs680.hw14.APFS;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;



public class ApfsDirectory extends ApfsElement {


    public LinkedList<ApfsElement> children; 

    public ApfsDirectory(ApfsDirectory parent,
            String name,
            LocalDateTime creation) {
        super(parent, name, 0, creation, name, creation);
        if(name.length() > 255) this.name = name.substring(0, 255);
        children = new LinkedList<ApfsElement>();
    }

	// append child to children and sort children with the default sorting
	public void appendChild(ApfsElement child) {
		// AlphabeticalComparator defaultSort = new AlphabeticalComparator();
    	this.children.add(child);
		children.sort((ApfsElement e1, ApfsElement e2) -> e1.getName().compareTo(e2.getName()));
    	child.setParent(this);
    }

	public LinkedList<ApfsElement> getChildren() {
		this.children.sort((ApfsElement e1, ApfsElement e2) -> e1.getName().compareTo(e2.getName()));
		
        return this.children;
    }

	public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> sortingPolicy) {
		this.children.sort(sortingPolicy);
		return this.children;
   }

   public LinkedList<ApfsDirectory> getSubDirectories() {
	LinkedList<ApfsDirectory> directories = new LinkedList<ApfsDirectory>();
	for (ApfsElement element: this.getChildren()) 
		if(element.isDirectory())
			directories.add((ApfsDirectory) element);
	directories.sort((ApfsElement e1, ApfsElement e2) -> e1.getName().compareTo(e2.getName()));
	return directories;
}
 
   public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> sortingPolicy) {
	LinkedList<ApfsDirectory> directories = new LinkedList<ApfsDirectory>();
	for (ApfsElement element: this.getChildren(sortingPolicy) ) 
		if(element.isDirectory())
			directories.add((ApfsDirectory) element);
	
	directories.sort(sortingPolicy);
	return directories;
}

	public LinkedList<ApfsFile> getFiles() {
		LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
	for (ApfsElement element: this.getChildren() ) 
		
		if(element.isFile())
			files.add((ApfsFile) element);
	files.sort((ApfsElement e1, ApfsElement e2) -> e1.getName().compareTo(e2.getName()));
	return files;
	}

	public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> sortingPolicy) {
		LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
	   for (ApfsElement element: this.getChildren(sortingPolicy) ) 
		   
		   if(element.isFile())
			   files.add((ApfsFile) element);
	   files.sort(sortingPolicy);
	   return files;
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