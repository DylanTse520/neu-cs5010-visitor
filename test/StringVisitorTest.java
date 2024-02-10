import document.BasicStringVisitor;
import document.Document;
import document.HtmlStringVisitor;
import document.MarkdownStringVisitor;
import document.element.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringVisitorTest {

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
        paragraph.add(new BoldText("lorem ipsum"));
        paragraph.add(new BasicText("dolor sit amet"));
        document.add(paragraph);
    }

    @Test
    public void testBasicString() {
        assertEquals("lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum dolor sit amet", document.toText(new BasicStringVisitor()));
    }

    @Test
    public void testHtmlString() {
        assertEquals("""
                        lorem ipsum
                        <b>lorem ipsum</b>
                        <i>lorem ipsum</i>
                        <h2>lorem ipsum</h2>
                        <a href="https://www.loremipsum.com">lorem ipsum</a>
                        <p><b>lorem ipsum</b>
                        dolor sit amet
                        </p>""",
                document.toText(new HtmlStringVisitor()));
    }

    @Test
    public void testMDString() {
        assertEquals("""
                        lorem ipsum
                        **lorem ipsum**
                        *lorem ipsum*
                        ## lorem ipsum
                        [lorem ipsum](https://www.loremipsum.com)

                        **lorem ipsum**
                        dolor sit amet""",
                document.toText(new MarkdownStringVisitor()));
    }

}
