package de.mathisneunzig.md;
public class MDBlockquote implements MarkdownElement {
    private final String content;

    public MDBlockquote(String content) {
        this.content = content;
    }

    @Override
    public String render() {
        return "> " + content;
    }
}
