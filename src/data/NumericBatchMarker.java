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
        ArrayList<String> list = new ArrayList<>();
        for (int i = start; i < end + 1; i++) {
            list.add(i + "");
        }
        return list;
    }
}
