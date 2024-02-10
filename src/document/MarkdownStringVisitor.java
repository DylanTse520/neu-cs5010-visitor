package document;

import document.element.*;

public class MarkdownStringVisitor implements DocumentVisitor<String> {

    @Override
    public String visitBasicText(BasicText current) {
        return current.getText() + "\n";
    }

    @Override
    public String visitBoldText(BoldText current) {
        return "**" + current.getText() + "**\n";
    }

    @Override
    public String visitHeading(Heading current) {
        return "#".repeat(Math.max(0, current.getLevel())) + " " + current.getText() + "\n";
    }

    @Override
    public String visitHyperText(HyperText current) {
        return "[" + current.getText() + "](" + current.getUrl() + ")\n";
    }

    @Override
    public String visitItalicText(ItalicText current) {
        return "*" + current.getText() + "*\n";
    }

    @Override
    public String visitParagraph(Paragraph current) {
        StringBuilder result = new StringBuilder();
        result.append("\n");
        for (BasicText c : current.getContent()) {
            result.append(c.accept(this));
        }
        result.append("\n");

        return result.toString();
    }

}
