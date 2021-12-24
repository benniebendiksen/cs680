package edu.umb.cs680.hw09.APFS;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsFileTest {

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
	private String parent = "";
	private String childs = "";
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
	
	private String[] fileToStringArray(ApfsFile f) {

		 if(f.getParent() != null)
		  parent = f.getParent().getName();
		 
        String[] fileInfo = {

			f.isFile().toString(),
        	f.isDirectory().toString(),
        	f.isLink().toString(),
        	f.getName(), 
        	parent
		};
        
        return fileInfo;
    }
	

	@Test
	void testFileA() {
		String[] expected = {"true",
							 "false",
							 "false",
							 "a",
							 "applications"
							 };
		
		assertArrayEquals(expected, fileToStringArray(a));	
	}	

	@Test
	void testFileD() {
		String[] expected = {"true",
							 "false",
							 "false",
							 "d",
							 "code"
							 };
		
		assertArrayEquals(expected, fileToStringArray(d));	
	}		
	
}
