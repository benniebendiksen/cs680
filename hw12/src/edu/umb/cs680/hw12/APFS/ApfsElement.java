package edu.umb.cs680.hw12.APFS;
import java.util.Date;
import java.time.LocalDateTime;
import edu.umb.cs680.hw12.FSFoundation.FSElement;


public abstract class ApfsElement extends FSElement {
	protected String name;
	protected int size;
	protected String owner;
	protected LocalDateTime creation;
	

	public ApfsElement(FSElement parent, String name, int size, LocalDateTime created, String owner, LocalDateTime lastModified) {
		super(parent, name, size, created);
		this.name = name;
		this.parent = parent;
		this.size = size;
		this.owner = owner;
		this.creation = LocalDateTime.now();
		
	}
	
	public abstract void accept(ApfsVisitor v);

	protected void setOwnersName(String newName) {
		this.owner = newName;
	}
	
	protected void setlastModified(LocalDateTime time) {
		this.creation = time;
	}
	
	
	public String getOwnersName() {
		return this.owner;
	}
	
	public LocalDateTime getLastModified() {
		return this.creation;
	}
	

	@Override
	public Boolean isDirectory() {
		return null;
	}

	@Override
	public Boolean isFile() {
		return null;
	}

	@Override
	public Boolean isLink() {
		return null;
	}

}
