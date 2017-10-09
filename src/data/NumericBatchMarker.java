package data;

public class NumericBatchMarker extends UrlBatchmarker {
    protected final Integer start, end;

    protected NumericBatchMarker(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
}
