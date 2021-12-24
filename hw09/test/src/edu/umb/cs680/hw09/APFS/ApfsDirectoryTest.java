package edu.umb.cs680.hw09.APFS;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import edu.umb.cs680.hw09.FSFoundation.FSElement;

class ApfsDirectoryTest {
    private static APFS apfs = APFS.getFileSystem();
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
	public static void defineHierarchy() {
		root = APFS.getFileSystem().getRootDir();
				
	    
		applications = new ApfsDirectory(root, "applications", LocalDateTime.of(2021, 11, 04, 1, 2));
		root.appendChild(applications);
		a = new ApfsFile(applications, "a", 19, LocalDateTime.of(2021, 11, 04, 1, 3));
		applications.appendChild(a); 
  	    
   	    
		home = new ApfsDirectory(root, "home", LocalDateTime.of(2021, 11, 04, 1, 5));
    	root.appendChild(home);
    	b = new ApfsFile(home, "b", 5, LocalDateTime.of(2021, 11, 04, 1, 6));
    	home.appendChild(b);
    	root.appendChild(home);
    	x = new ApfsLink(home, "x", LocalDateTime.of(2021, 11, 04, 1, 7), applications);
    	    
    	    
		code = new ApfsDirectory(home, "code", LocalDateTime.of(2021, 11, 04, 1, 18));
    	home.appendChild(code);
    	c = new ApfsFile(code, "c", 10, LocalDateTime.of(2021, 11, 04, 4, 7));
    	d = new ApfsFile(code, "d", 20, LocalDateTime.of(2021, 11, 04, 9, 8));
		code.appendChild(c);
		code.appendChild(d);
		y = new ApfsLink(code, "y",  LocalDateTime.of(2021, 11, 3, 1, 30), a);

	}
	private String[] dirToStringArray(ApfsDirectory d) {


		//  for (FSElement element:  d.getChildren())  
		// 	  children += (element.getName()) + ", ";

		//  for (FSElement element:  d.getSubDirectories())  
		// 	  subDirs += (element.getName()) + ", ";
		 
		//  for (FSElement element:  d.getFiles())  
		// 	  files += (element.getName()) + ", ";
			  
		if(d.getParent() != null) parent = d.getParent().getName();
		 
		 
        String[] dirInfo = {
        		d.isDirectory().toString(),
        		d.isFile().toString(),
        		d.isLink().toString(),
        		d.getName(), 
        		parent,
        		root.getName(),
			};

        return dirInfo;
    }

	@Test
	void verifyCreateDefaultRootDirectoryEquality() {
		String[] expected = {"true",
							 "false",
							 "false",
							 "Default Root",
							 "",
							 "Default Root"
							 };
		
		assertArrayEquals(expected, dirToStringArray(root));	
	}

	
	@Test
	void verifyDirectoryEqualityApplications() {
		String[] expected = {"true",
							 "false",
							 "false",
							 "applications",
							 "Default Root",
							 "Default Root"
							 };
		
		assertArrayEquals(expected, dirToStringArray(applications));	
	}
	

		@Test
		void verifyDirectoryEqualityHome() {
			String[] expected = {"true",
								 "false",
								 "false",
								 "home",
								 "Default Root",
								 "Default Root"
								 };
			
			assertArrayEquals(expected, dirToStringArray(home));	
		}
		


		@Test
		void verifyDirectoryEqualityCode() {
			String[] expected = {"true",
								 "false",
								 "false",
								 "code",
								 "home",
								 "Default Root"
								 };
			
			assertArrayEquals(expected, dirToStringArray(code));	
		}

}