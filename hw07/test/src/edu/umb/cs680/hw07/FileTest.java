package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


class FileTest {
	    private static Directory root;
	    private static Directory applications;
	    private static File a;
	    private static Directory home; 
	    private static Directory code;
	    private static File c;
	    private static File d;
	    private static File b;
		private String parent = "";
		
		
		@BeforeAll
		public static void defineHierarchy() {
			//generate hierarchy
		    root = new Directory(null, "root", LocalDateTime.of(2021, 11, 6, 1, 0));

		    //instantiate application followed by its two children; uses local datetime api
			  applications = new Directory(root, "applications", LocalDateTime.of(2021, 11, 6, 1, 1));
			  	root.appendChild(applications);
	    	    a = new File(applications, "a", 1, LocalDateTime.of(2021, 11, 6, 1, 2));
	    	    applications.appendChild(a);
	    	    
	    	    
	   	    
	    	 home = new Directory(root, "home", LocalDateTime.of(2021, 11, 6, 1, 3));
	    	    root.appendChild(home);
	    	    b = new File(home, "b", 2, LocalDateTime.of(2021, 11, 6, 1, 4));
	    	    home.appendChild(b);
	    	    
	    	    code = new Directory(home, "code", LocalDateTime.of(2021, 11, 6, 1, 5));
	    	    	home.appendChild(code);
	    	      c = new File(code, "c", 10, LocalDateTime.of(2021, 11, 6, 1, 6));
	    	      d = new File(code, "d", 20, LocalDateTime.of(2021, 11, 6, 1, 7));
	    	      code.appendChild(c);
	    	      code.appendChild(d);
	    
		}

		private String[] fileToStringArray(File f) {

			if(f.getParent() != null)
				 parent = f.getParent().getName();
			 
	        String[] fileInfo = {
	        		f.isDirectory().toString(),
	        		f.getName(), 
	        		parent,
	        		String.valueOf(f.getSize())
				};
	        
	        return fileInfo;
	    }
		

		@Test
		void verifyFileEqualityA() {
			String[] expected = {"false", "a","applications","1"};
			assertArrayEquals(expected, fileToStringArray(a));	
		}	
		

		@Test
		void verifyFileEqualityB() {
			String[] expected = {"false", "b", "home", "2"};
			assertArrayEquals(expected, fileToStringArray(b));	
		}	
		
		
}
