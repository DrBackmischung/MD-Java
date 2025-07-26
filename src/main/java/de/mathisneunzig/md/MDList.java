package de.mathisneunzig.md;

import java.util.ArrayList;
import java.util.List;

public class MDList implements MarkdownElement {
    private final List<MDListItem> items = new ArrayList<>();
    private final boolean ordered;

    public MDList(boolean ordered) {
        this.ordered = ordered;
    }

    public MDList addItem(String content) {
        items.add(new MDListItem(content));
        return this;
    }

    public MDList addItem(MarkdownElement content) {
        items.add(new MDListItem(content));
        return this;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (MDListItem item : items) {
            if (ordered) {
                sb.append(counter++).append(". ").append(item.render()).append("\n");
            } else {
                sb.append("- ").append(item.render()).append("\n");
            }
        }
        return sb.toString().trim();
    }
}
