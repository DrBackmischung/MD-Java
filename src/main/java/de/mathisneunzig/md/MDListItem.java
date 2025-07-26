package de.mathisneunzig.md;
public class MDListItem implements MarkdownElement {
    private final MarkdownElement content;

    public MDListItem(String text) {
        this.content = new MDText(text);
    }

    public MDListItem(MarkdownElement content) {
        this.content = content;
    }

    @Override
    public String render() {
        return content.render();
    }
}
