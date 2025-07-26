package de.mathisneunzig.md;

import java.util.ArrayList;
import java.util.List;

public class MDChapter implements MarkdownElement {

    private final String title;
    private final List<MarkdownElement> content = new ArrayList<>();

    public MDChapter(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public MDChapter addText(String text) {
        this.content.add(new MDText(text));
        return this;
    }

    public MDChapter addSection(MDSection section) {
        this.content.add(section);
        return this;
    }

    public MDChapter addElement(MarkdownElement element) {
        this.content.add(element);
        return this;
    }

    public List<MarkdownElement> getContent() {
        return content;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(title).append("\n\n");

        for (MarkdownElement element : content) {
            sb.append(element.render()).append("\n\n");
        }

        return sb.toString().trim();
    }
}
