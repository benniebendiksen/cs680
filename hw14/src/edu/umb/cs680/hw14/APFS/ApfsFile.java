package edu.umb.cs680.hw14.APFS;
import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {


	public ApfsFile(ApfsDirectory parent, 
    				 String name,
                    int size,
                    LocalDateTime creationTime) {
		
        super(parent, name, size, creationTime, name, creationTime);
        if(name.length() > 255) this.name = name.substring(0, 255);
    	
    }

	@Override
	public void accept(ApfsVisitor v) {
		v.visit(this);
		
	}

	@Override
	public Boolean isDirectory() {

		return false;
	}; 
	
	@Override
	public Boolean isFile() {
		return true;
	}	

	@Override
	public Boolean isLink() {
		return false;
	}
	

}