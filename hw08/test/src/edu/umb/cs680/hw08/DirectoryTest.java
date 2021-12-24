package edu.umb.cs680.hw08;
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
	private static Link x;
    private static Link y;
	
	
	@BeforeAll
	public static void setUp() {
	    root = new Directory(null, "root", LocalDateTime.of(2021, 11, 04, 1, 1));

		applications = new Directory(root, "applications", LocalDateTime.of(2021, 11, 04, 1, 2));
		root.appendChild(applications);
		a = new File(applications, "a", 19, LocalDateTime.of(2021, 11, 04, 1, 3));
		applications.appendChild(a); 
		
   	    
		home = new Directory(root, "home", LocalDateTime.of(2021, 11, 04, 1, 5));
    	root.appendChild(home);
    	b = new File(home, "b", 5, LocalDateTime.of(2021, 11, 04, 1, 6));
    	home.appendChild(b);
    	x = new Link(home, "x", LocalDateTime.of(2021, 11, 04, 1, 7), applications);
    	    
    	    
    	code = new Directory(home, "code", LocalDateTime.of(2021, 11, 04, 1, 18));
    	home.appendChild(code);
    	c = new File(code, "c", 10, LocalDateTime.of(2021, 11, 04, 4, 7));
    	d = new File(code, "d", 20, LocalDateTime.of(2021, 11, 04, 9, 8));
		code.appendChild(c);
		code.appendChild(d);
		y = new Link(code, "y",  LocalDateTime.of(2021, 11, 04, 10, 1), a);
		fileSystem.appendRootDir(root);

	}

	private String[] linkFieldsArray(Link l) {
		String[] LinkInfo = {
        		l.isLink().toString(),
        		l.getName(), 
        		l.getParent().getName(),
        		String.valueOf(l.getSize()),
        		l.getTarget().getName(), 		
		};
		return LinkInfo;
	}
	
	@Test
	 void applicationsLinkTest() {
		String[] expected = {"true",
				  			 "x",
				  			 "home",
				  			 "0",
							 "applications"
				 			};


		assertArrayEquals(expected, linkFieldsArray(x));	
		 
	 }
	
	@Test
	void fileLinkTest() {
		String[] expected = {"true",
							 "y",
							 "code",
							 "0",
						     "a"
				 			};
		
		assertArrayEquals(expected, linkFieldsArray(y));	
	}	
	
			
}