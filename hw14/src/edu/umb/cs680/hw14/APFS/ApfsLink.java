package edu.umb.cs680.hw14.APFS;


import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {

	protected ApfsElement target;
	public ApfsLink(ApfsDirectory parent, String name, LocalDateTime creationTime, ApfsElement target) 
	{
		super(parent, name, 0, creationTime, name, creationTime);
        if(name.length() > 255) this.name = name.substring(0, 255);

		this.target = target;
	}

    public ApfsElement getTarget() {
        return this.target;
    }

	@Override
	public void accept(ApfsVisitor v) {
		v.visit(this);
		
	}
	
	@Override
	public Boolean isDirectory() {
		return false;
	}

	@Override
	public Boolean isFile() {
		return false;
	}


	@Override
	public Boolean isLink() {
		return true;
	}
}
