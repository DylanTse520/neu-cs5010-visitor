package document;

import document.element.TextElement;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private final List<TextElement> content;

    public Document() {
        content = new ArrayList<>();
    }

    public void add(TextElement e) {
        content.add(e);
    }

    public int countWords() {
        Integer wordCount = 0;
        for (TextElement c : content) {
            wordCount += c.accept(new WordCountVisitor());
        }
        return wordCount;
    }

    public String toText(DocumentVisitor<String> visitor) {
        StringBuilder result = new StringBuilder();
        for (TextElement c : content) {
            result.append(c.accept(visitor));
        }
        return result.toString().trim();
    }

}
