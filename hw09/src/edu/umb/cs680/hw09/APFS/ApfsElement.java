package edu.umb.cs680.hw09.APFS;
import java.util.Date;
import java.time.LocalDateTime;
import edu.umb.cs680.hw09.FSFoundation.FSElement;


public abstract class ApfsElement extends FSElement {
	protected String name;
	protected int size;
	protected String owner;
	protected LocalDateTime lastModified;
	protected String checksum;
	

	public ApfsElement(FSElement parent, String name, int size, LocalDateTime created, String owner, LocalDateTime lastModified) {
		super(parent, name, size, created);
		this.name = name;
		this.parent = parent;
		this.size = size;
		this.owner = owner;
		this.lastModified = LocalDateTime.now();
		
	}
	
	protected void setOwnersName(String newName) {
		this.owner = newName;
	}
	
	protected void setlastModified(LocalDateTime timeStamp) {
		this.lastModified = timeStamp;
	}
	
	
	public String getOwnersName() {
		return this.owner;
	}
	
	public LocalDateTime getLastModified() {
		return this.lastModified;
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
