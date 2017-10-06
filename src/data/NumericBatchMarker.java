package data;

public class NumericBatchMarker extends UrlComponent {
    final int beginning, end;

    public NumericBatchMarker(int beginning, int end) {
        this.beginning = beginning;
        this.end = end;
    }
}
