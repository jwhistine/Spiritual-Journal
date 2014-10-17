/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import journal.FileService;
import journal.Scripture;
import journal.ScriptureFinder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author mormon
 */
public class ScriptureFinderTest {
    
    public ScriptureFinderTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
  public void parseLineSingle_CanParseSingleVerse() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("Hello Moses 1:39");
    Assert.assertEquals(s.getBook(), "Moses");
    Assert.assertEquals(s.getChapter(), 1);
    Assert.assertEquals(s.getVerse(), 39);
  }
  
  /**********************************************************************
   * TESTS FOR THE SCRIPTURE FINDER CLASS
   *********************************************************************/
  @Test
  public void parseLineSingle_CanParseMultipleVerses() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("Hello Moses 1:38-39");
    Assert.assertEquals(s.toString(), "Moses 1:38-39");
  }
  
  @Test
  public void parseLineSingle_CanParseDoctrineAndCovenants() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("This is a scripture D&C 128:3");
    Assert.assertEquals(s.getBook(), "D&C");
    Assert.assertEquals(s.getChapter(), 128);
    Assert.assertEquals(s.getVerse(), 3);
  }
  
  @Test
  public void parseLineSingle_ReturnsNullForNoScripture() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("There is no scripture here!");
    Assert.assertEquals(s, null);
  }
  
  @Test
  public void parseLineSingle_DoesNotFindNonScripture() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("The ratio is 3:4");
    Assert.assertEquals(s, null);
  }
  
  @Test
  public void parseLineSingle_CanParseChapter() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("Here is a scripture: Nephi chapter 2");
    Assert.assertEquals(s.getBook(), "Nephi");
    Assert.assertEquals(s.getChapter(), 2);
    Assert.assertEquals(s.getVerse(), -1);
  }
  
  @Test
  public void parseLineSingle_CanParseChapterAsText() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("Here is a scripture: Nephi chapter two");
    Assert.assertEquals(s.getBook(), "Nephi");
    Assert.assertEquals(s.getChapter(), 2);
    Assert.assertEquals(s.getVerse(), -1);
  }
  
  @Test
  public void parseLineSingle_CanParseScriptureWithNumberPrefix() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("Here is a scripture: 2 Nephi chapter 2");
    Assert.assertEquals(s.getBook(), "2 Nephi");
    Assert.assertEquals(s.getChapter(), 2);
    Assert.assertEquals(s.getVerse(), -1);
  }
  
  @Test
  public void parseLineSingle_CanParseScriptureWithMultipleChapters() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("Here is a scripture: 2 Nephi chapters 2-3");
    Assert.assertEquals(s.getBook(), "2 Nephi 2-3");
  }
  
  @Test
  public void parseLineSingle_CanParseScriptureWithBookOnly() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("Here is a scripture: 2 Nephi");
    Assert.assertEquals(s.getBook(), "2 Nephi");
  }
  
  @Test
  public void parseLineSingle_CanParseSingleVerseWithTypo() {
    ScriptureFinder sf = new ScriptureFinder();
    Scripture s = sf.parseLineSingle("Hello Mosses 1:39");
    Assert.assertEquals(s.getBook(), "Moses");
    Assert.assertEquals(s.getChapter(), 1);
    Assert.assertEquals(s.getVerse(), 39);
  }
  
  /***************************************************************************
   * OTHER TESTS:
   * File class
   **************************************************************************/
  @Test
  public void openFile(){
      FileService f = new FileService();
      f.importFile();
      Assert.assertEquals(f.getImport(), "");
  }
  
  @Test
  public void closeFile(){
      FileService f = new FileService();
      f.exportFile();
      Assert.assertEquals(f.getExport(), "");
  }
}
