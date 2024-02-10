import document.Document;
import document.element.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCountVisitorTest {

    private Document document;

    @Before
    public void setUp() {
        document = new Document();
        document.add(new BasicText("lorem ipsum"));
        document.add(new BoldText("lorem ipsum"));
        document.add(new ItalicText("lorem ipsum"));
        document.add(new Heading("lorem ipsum", 2));
        document.add(new HyperText("lorem ipsum", "https://www.loremipsum.com"));
        Paragraph paragraph = new Paragraph();
        paragraph.add(new BasicText("lorem ipsum"));
        paragraph.add(new BasicText("dolor sit amet"));
        document.add(paragraph);
    }

    @Test
    public void testWordCount() {
        assertEquals(15, document.countWords());
    }

}
