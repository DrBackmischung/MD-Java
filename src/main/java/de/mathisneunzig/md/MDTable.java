package de.mathisneunzig.md;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MDTable implements MarkdownElement {
    private final List<String> headers = new ArrayList<>();
    private final List<MDTableRow> rows = new ArrayList<>();

    public MDTable setHeaders(String... headers) {
        this.headers.clear();
        this.headers.addAll(Arrays.asList(headers));
        return this;
    }

    public MDTable addRow(String... cells) {
        rows.add(new MDTableRow(cells));
        return this;
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();

        // Header
        sb.append("| ").append(String.join(" | ", headers)).append(" |\n");

        // Separator
        sb.append("| ").append(headers.stream().map(h -> "---").collect(Collectors.joining(" | "))).append(" |\n");

        // Rows
        for (MDTableRow row : rows) {
            sb.append(row.render()).append("\n");
        }

        return sb.toString().trim();
    }
}
