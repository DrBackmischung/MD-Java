package de.mathisneunzig.md;

import java.util.ArrayList;
import java.util.List;

public class MDSubsection implements MarkdownElement {
    private String title;
    private List<MarkdownElement> content = new ArrayList<>();

    public MDSubsection(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    public MDSubsection addText(String text) {
        content.add(new MDText(text));
        return this;
    }

    public MDSubsection addElement(MarkdownElement e) {
        content.add(e);
        return this;
    }

    public List<MarkdownElement> getContent() { return content; }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder("### ").append(title).append("\n\n");
        for (MarkdownElement e : content) {
            sb.append(e.render()).append("\n\n");
        }
        return sb.toString().trim();
    }
}
