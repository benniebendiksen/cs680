package edu.umb.cs680.hw07;



import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class DirectoryTest {
	//first field references the lone FileSystem instance (e.g., static factory method use)
    private static FileSystem fileSystem = FileSystem.getFileSystem();
    private static Directory root;
    private static Directory applications;
    private static File a;
    private static Directory home; 
    private static File b;
    private static Directory code;
    private static File c;
    private static File d;
	private String parent = "";
	private String children = "";
	private String subDirs = "";
	private String files = "";
	
	@BeforeAll
	public static void defineHierarchy() {
	    root = new Directory(null, "root", LocalDateTime.of(2021, 11, 04, 1, 1));

		applications = new Directory(root, "applications", LocalDateTime.of(2021, 11, 04, 1, 2));
		root.appendChild(applications);
		a = new File(applications, "a", 19, LocalDateTime.of(2021, 11, 04, 1, 3));
		b = new File(applications, "b", 1,  LocalDateTime.of(2021, 11, 04, 1, 4));
		applications.appendChild(a);
		applications.appendChild(b);	    
   	    
    	home = new Directory(root, "home", LocalDateTime.of(2021, 11, 04, 1, 5));
    	root.appendChild(home);
    	b = new File(home, "b", 5, LocalDateTime.of(2021, 11, 04, 1, 6));
    	home.appendChild(b);
    	    
    	code = new Directory(home, "code", LocalDateTime.of(2021, 11, 04, 1, 6));
    	home.appendChild(code);
    	c = new File(code, "c", 10, LocalDateTime.of(2021, 11, 04, 1, 7));
    	d = new File(code, "d", 20, LocalDateTime.of(2021, 11, 04, 1, 8));
		code.appendChild(c);
		code.appendChild(d);
		fileSystem.appendRootDir(root);
	}

	private String[] directoryToStringArray(Directory d) {
		if(d.getParent() != null) 
			parent = d.getParent().getName();

		 for (FSElement element:  d.getChildren())  
			  children += (element.getName()) + ", ";

		 for (FSElement element:  d.getSubDirectories())  
			  subDirs += (element.getName()) + ", ";
		 
		 for (FSElement element:  d.getFiles())  
			  files += (element.getName()) + ", ";
		 
		 
        String[] dirInfo = {
        		d.isDirectory().toString(),
        		d.getName(), 
        		parent,
        		String.valueOf(d.getSize()),
        		String.valueOf(d.countChildren()), 
        		children,
        		subDirs,
        		files
			};

        return dirInfo;
    }
	
	@Test
	// we must perform an equality check for each Directory instance (i.e., root, app, home, code)
	void equalityCheckRoot() {
		String[] expected = {"true",
							 "root",
							 "",
							 "0",
							 "2",
							 "applications, home, ",
							 "applications, home, ",
							 ""
							 };
		
		assertArrayEquals(expected, directoryToStringArray(root));	
	}	
	
	@Test
	void equalityCheckApplications() {
		String[] expected = {"true",
							 "applications",
							 "root",
							 "0",
							 "1",
							 "a, ",
							 "",
							 "a, "
							 };
		
		assertArrayEquals(expected, directoryToStringArray(applications));	
	}

		@Test
		void equalityCheckHome() {
			String[] expected = {"true",
								 "home",
								 "root",
								 "0",
								 "2",
								 "code, b, ",
								 "code, ",
								 "b, "
								 
								 };
			
			assertArrayEquals(expected, directoryToStringArray(home));	
		}

		@Test
		void equalityCheckCode() {
			String[] expected = {"true",
								 "code",
								 "home",
								 "0",
								 "2",
								 "c, d, ",
								 "",
								 "c, d, "
								 };
			
			assertArrayEquals(expected, directoryToStringArray(code));	
		}

}
