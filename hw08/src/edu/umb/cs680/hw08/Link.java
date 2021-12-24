package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement {

	protected FSElement target;
	public Link(Directory parent, String name,
			LocalDateTime creation, FSElement target) {
		super(parent, name, 0, creation);
		this.target = target;
	}

    public FSElement getTarget() {
        return this.target;
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
