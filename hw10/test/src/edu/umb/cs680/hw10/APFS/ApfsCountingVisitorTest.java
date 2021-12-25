package edu.umb.cs680.hw10.APFS;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.FSFoundation.FSElement;


class ApfsCountingVisitorTest {
	private static APFS apfs = APFS.getFileSystem();
	private static ApfsCountingVisitor countingVisitor;
	private static ApfsFileCrawlingVisitor crawlingVisitor;
	private static ApfsFileSearchVisitor searchVisitor;
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
			x = new ApfsLink(home, "x", LocalDateTime.of(2021, 11, 04, 1, 7), applications);
					
					
			code = new ApfsDirectory(home, "code", LocalDateTime.of(2021, 11, 04, 1, 18));
			home.appendChild(code);
			c = new ApfsFile(code, "c", 10, LocalDateTime.of(2021, 11, 04, 4, 7));
			code.appendChild(c);
			d = new ApfsFile(code, "d", 20, LocalDateTime.of(2021, 11, 04, 9, 8));
			code.appendChild(d);
			y = new ApfsLink(code, "y",  LocalDateTime.of(2021, 11, 3, 1, 30), a);

		}



	//Tests of counting visitor
	@Test
	public void testCountingVisitorDirNumFromRoot() {

		countingVisitor = new ApfsCountingVisitor();
		root.accept(countingVisitor);
		int actual = countingVisitor.getDirVisits();
		int expected = 4;
		
		
		assertEquals(expected, actual);
	}

	
	//Test of crawling visitor
	@Test
	public void testCrawlingVisitorGetFilesFromRoot() {
		crawlingVisitor = new ApfsFileCrawlingVisitor();
		root.accept(crawlingVisitor);
		
		LinkedList<ApfsFile> actual = new LinkedList<ApfsFile>();
		LinkedList<ApfsFile> expected = new LinkedList<ApfsFile>();
		
		actual = crawlingVisitor.getFiles();
		expected.addAll(Arrays.asList(a, b, c, d));
				
		assertEquals(expected, actual);
	}

	//Test of search visitor
	@Test
	public void testSearchForDFromHome() {
		searchVisitor = new ApfsFileSearchVisitor("d");
		root.accept(searchVisitor);

		LinkedList<ApfsFile> actual = new LinkedList<ApfsFile>();
		LinkedList<ApfsFile> expected = new LinkedList<ApfsFile>();
		actual = searchVisitor.getFoundFiles();
		expected.addAll(Arrays.asList(d));
				
		assertEquals(expected, actual);
	}
	
}