package edu.umb.cs680.hw14.APFS;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.FSFoundation.FSElement;

class ApfsSortTest {

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
	private  String expectedNames = "";
	private  String actualNames = "";
	
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
		x = new ApfsLink(home, "x", LocalDateTime.of(2021, 11, 04, 1, 7), applications);
				
		code = new ApfsDirectory(home, "code", LocalDateTime.of(2021, 11, 04, 1, 18));
		home.appendChild(code);
		c = new ApfsFile(code, "c", 10, LocalDateTime.of(2021, 11, 04, 4, 7));
		code.appendChild(c);
		d = new ApfsFile(code, "d", 20, LocalDateTime.of(2021, 11, 04, 9, 8));
		code.appendChild(d);
		y = new ApfsLink(code, "y",  LocalDateTime.of(2021, 11, 3, 1, 30), a);

	}

	@Test
	void verifyAlphabeticalSorting() {
		
		expectedNames += applications.getName()+ ", ";
		expectedNames += home.getName()+ ", ";
		
		for (FSElement element: root.getChildren((ApfsElement e1, ApfsElement e2) -> e1.getName().compareTo(e2.getName())))
			 actualNames += (element.getName()) + ", ";
		 		
		assertEquals(expectedNames, actualNames);
	
	}	


	@Test
	void verifyReverseAlphabeticalComparator() {

		expectedNames += home.getName()+ ", ";		
		expectedNames += applications.getName()+ ", ";

		for (FSElement element:  root.getSubDirectories((ApfsElement e1, ApfsElement e2) -> e2.getName().compareTo(e1.getName())))
		actualNames += (element.getName()) + ", ";
		 		
		assertEquals(expectedNames, actualNames);
	
	}

	@Test
	void verifyTimeStampComparator() {

		expectedNames += "d" + ", ";
		expectedNames += "c" + ", ";
		
		 for (FSElement element:  code.getFiles((ApfsElement e1, ApfsElement e2) -> e2.getLastModified().compareTo(e1.getLastModified())))
			 actualNames += (element.getName()) + ", ";
		 		
		assertEquals(expectedNames, actualNames);

	}
}