package de.mathisneunzig.md;
public class MDCodeBlock implements MarkdownElement {
    private final String language;
    private final String code;

    public MDCodeBlock(String language, String code) {
        this.language = language;
        this.code = code;
    }

    @Override
    public String render() {
        return "```" + language + "\n" + code + "\n```";
    }
}
