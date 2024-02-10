package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

public interface DocumentVisitor<R> {
  
  R visitBasicText(BasicText current);
  
  R visitBoldText(BoldText current);

  R visitHeading(Heading current);

  R visitHyperText(HyperText current);

  R visitItalicText(ItalicText current);

  R visitParagraph(Paragraph current);
}
