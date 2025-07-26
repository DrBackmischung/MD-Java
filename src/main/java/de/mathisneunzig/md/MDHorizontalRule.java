package de.mathisneunzig.md;
public class MDHorizontalRule implements MarkdownElement {
    @Override
    public String render() {
        return "---";
    }
}
