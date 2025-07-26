package de.mathisneunzig.md;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MDFile implements MarkdownElement {
    private final List<MarkdownElement> elements = new ArrayList<>();

    public MDFile addElement(MarkdownElement e) {
        elements.add(e);
        return this;
    }

    public List<MarkdownElement> getElements() {
        return elements;
    }

    @Override
    public String render() {
        return elements.stream()
            .map(MarkdownElement::render)
            .collect(Collectors.joining("\n\n"))
            .trim();
    }
}
