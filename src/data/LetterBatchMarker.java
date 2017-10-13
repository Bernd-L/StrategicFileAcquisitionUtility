package data;

import java.util.ArrayList;

public class LetterBatchMarker extends UrlBatchmarker {
    protected final Character start, end;

    public LetterBatchMarker(Character start, Character end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected ArrayList<String> toStrings() {
        return null;
    }


}
