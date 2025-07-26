package de.mathisneunzig.md;
public class MDLink implements MarkdownElement {
    private final String label;
    private final String url;

    public MDLink(String label, String url) {
        this.label = label;
        this.url = url;
    }

    @Override
    public String render() {
        return "[" + label + "](" + url + ")";
    }
}
