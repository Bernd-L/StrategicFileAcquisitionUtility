package data;

public class LetterBatchMarker extends UrlBatchmarker {
    protected final Character start, end;

    public LetterBatchMarker(Character start, Character end) {
        this.start = start;
        this.end = end;
    }
}
