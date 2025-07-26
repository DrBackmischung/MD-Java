package de.mathisneunzig.md;
public class MDImage implements MarkdownElement {
    private final String altText;
    private final String url;

    public MDImage(String altText, String url) {
        this.altText = altText;
        this.url = url;
    }

    @Override
    public String render() {
        return "![" + altText + "](" + url + ")";
    }
}
