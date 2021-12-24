package edu.umb.cs680.hw09.APFS;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.FSFoundation.FSElement;


class APFSTest {
    private static ApfsDirectory root;
    private static ApfsDirectory applications;
    private static ApfsFile a;
    private static ApfsDirectory home; 
    private static ApfsFile b;
    private static ApfsDirectory code;
    private static ApfsFile c;
    private static ApfsFile d;
	private static ApfsLink x;
	private static ApfsLink y;   
	private String rootDirectory = "";
	private String Parent = "";
	private String files = "";
	

	@BeforeAll
	public static void directoryHierarchy() {

		root = APFS.getFileSystem().getRootDir();
	    
	 	applications = new ApfsDirectory(root, "applications", LocalDateTime.of(2021, 11, 04, 1, 2));
  	    a = new ApfsFile(applications, "a", 19, LocalDateTime.of(2021, 11, 04, 1, 3));
  	    
    	home = new ApfsDirectory(root, "home", LocalDateTime.of(2021, 11, 04, 1, 5));
    	b = new ApfsFile(home, "b", 5, LocalDateTime.of(2021, 11, 04, 1, 6));
    	x = new ApfsLink(home, "x", LocalDateTime.of(2021, 11, 04, 1, 7), applications);
    	    
   	    code = new ApfsDirectory(home, "code", LocalDateTime.of(2021, 11, 04, 1, 18));
	    c = new ApfsFile(code, "c", 10, LocalDateTime.of(2021, 11, 04, 4, 7));
	    d = new ApfsFile(code, "d", 20, LocalDateTime.of(2021, 11, 04, 9, 8));
    	y = new ApfsLink(code, "y",  LocalDateTime.of(2021, 11, 04, 10, 1), a);

	}

	private String[] dirToStringArray(ApfsDirectory d) {

		for (FSElement element:  d.getFiles())  
			  files += (element.getName()) + ", ";



		 rootDirectory =  root.getName();	
			  

		 if(d.getParent() != null) 
		 	Parent = d.getParent().getName();
		 
		 
        String[] dirInfo = {
        		d.isDirectory().toString(),
        		d.isFile().toString(),
        		d.getName(), 
        		rootDirectory,
        		files
			};

        return dirInfo;
    }

	
	@Test
	void verifyAPFSSingleton() {
		APFS fileSystem1 = APFS.getFileSystem();
		APFS fileSystem2 = APFS.getFileSystem();
		
		assertSame(fileSystem1, fileSystem2);
	}

	

	@Test
	void verifyRootDirName() {
		String expected = "Default Root" ;
		assertEquals(expected, APFS.getFileSystem().getRootDir().getName());
	}	
	
	
	@Test
	void verifyCreateDefaultRootDirectoryEquality() {
		String[] expected = {"true",
							 "false",
							 "Default Root",
							 "Default Root",
							 ""
							 };
		
		assertArrayEquals(expected, dirToStringArray(root));	
	}


}