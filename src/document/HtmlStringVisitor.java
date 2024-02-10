package document;

import document.element.*;

public class HtmlStringVisitor implements DocumentVisitor<String> {

    @Override
    public String visitBasicText(BasicText current) {
        return current.getText() + "\n";
    }

    @Override
    public String visitBoldText(BoldText current) {
        return "<b>" + current.getText() + "</b>\n";
    }

    @Override
    public String visitHeading(Heading current) {
        return "<h" + current.getLevel() + ">" + current.getText() + "</h" + current.getLevel() + ">\n";
    }

    @Override
    public String visitHyperText(HyperText current) {
        return "<a href=\"" + current.getUrl() + "\">" + current.getText() + "</a>\n";
    }

    @Override
    public String visitItalicText(ItalicText current) {
        return "<i>" + current.getText() + "</i>\n";
    }

    @Override
    public String visitParagraph(Paragraph current) {
        StringBuilder result = new StringBuilder();
        result.append("<p>");

        for (BasicText c : current.getContent()) {
            result.append(c.accept(this));
        }
        result.append("</p>\n");

        return result.toString().trim();
    }

}
