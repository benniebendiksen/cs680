package edu.umb.cs680.hw08;


import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent,
                 String name,
                 int size,
                 LocalDateTime creation) {
        super(parent, name, size, creation);
        
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