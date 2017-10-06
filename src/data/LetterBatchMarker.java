package data;

public class LetterBatchMarker extends UrlBatchmarker {
    final protected char beginning, end;

    public LetterBatchMarker(char beginning, char end) {
        this.beginning = beginning;
        this.end = end;
    }
}
