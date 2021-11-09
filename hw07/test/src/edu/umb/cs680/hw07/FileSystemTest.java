package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileSystemTest {

    private static FileSystem fileSystem;
    private static Directory root;
    private static Directory applications;
    private static File a;
    private static Directory home; 
    private static File b;
    private static Directory code;
    private static File c;
    private static File d;
	private String rootDirectoriesNames = "";
	private String rootFileNames = "";
	private String subDirectoriesNames = "";

	

	
	//All test classes will use directory file structure as a fixture
	@BeforeAll
	public static void defineHierarchy() {
	    root = new Directory(null, "root", LocalDateTime.of(2021, 11, 5, 1, 1));
	    fileSystem = FileSystem.getFileSystem();
	    
		applications = new Directory(root, "applications", LocalDateTime.of(2021, 11, 6, 1, 1));
    	a = new File(applications, "a", 1, LocalDateTime.of(2021, 11, 6, 1, 2));
   	    
    	home = new Directory(root, "home", LocalDateTime.of(2021, 11, 6, 1, 3));
    	b = new File(home, "b", 5, LocalDateTime.of(2021, 11, 6, 1, 4));
    	
    	code = new Directory(home, "code", LocalDateTime.of(2021, 11, 6, 1, 4));
    	c = new File(code, "c", 1, LocalDateTime.of(2021, 11, 6, 1, 5));
    	d = new File(code, "d", 2, LocalDateTime.of(2021, 11, 6, 1, 6));
    	 
	}

	private String[] fileSystemToStringArray(FileSystem fs) {

		
		 for (Directory rootDir:  fs.getRootDirs())
			 rootDirectoriesNames += (rootDir.getName()) + ", ";
		 
		 for (String name:  fs.getSubDirectoriesNames())
			  subDirectoriesNames += name + ", ";

		 for (File element:  fs.getRootFiles())
			 rootFileNames += element.getName() + ", ";


        String[] fileSystemInfo = {
        		String.valueOf(fs.sizeRootDirs()),
        		rootDirectoriesNames,
        		subDirectoriesNames,
        		rootFileNames
			};
        
        return fileSystemInfo;
    }
	
	@Test
	void fileSystemEquality() {
		String[] expected = {"1",
							"root, ",
							"applications, home, ",
							""
							 };
		
		assertArrayEquals(expected, fileSystemToStringArray(fileSystem));	
	}	
	
	@Test
	void sameFSInstance() {
		FileSystem fS1 = FileSystem.getFileSystem();
		FileSystem fS2 = FileSystem.getFileSystem();
		
		assertSame(fS1, fS2);
	}

}
