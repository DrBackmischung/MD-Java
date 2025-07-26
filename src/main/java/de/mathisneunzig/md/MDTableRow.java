package de.mathisneunzig.md;

import java.util.Arrays;
import java.util.List;

public class MDTableRow implements MarkdownElement {
    private final List<String> cells;

    public MDTableRow(String... cells) {
        this.cells = Arrays.asList(cells);
    }

    @Override
    public String render() {
        return "| " + String.join(" | ", cells) + " |";
    }
}
