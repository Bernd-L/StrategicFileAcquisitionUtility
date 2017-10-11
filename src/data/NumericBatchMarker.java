package data;

import java.util.ArrayList;

public class NumericBatchMarker extends UrlBatchmarker {
    protected final Integer start, end;

    protected NumericBatchMarker(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected ArrayList<String> toStrings() {
        ArrayList<String> result = new ArrayList<>();

    }
}
