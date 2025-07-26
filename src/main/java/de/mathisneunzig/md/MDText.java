package de.mathisneunzig.md;

public class MDText implements MarkdownElement {
    private String text;

    public MDText(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String render() {
        return text + "\n";
    }
}
