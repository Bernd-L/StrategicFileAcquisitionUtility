package data;

import java.util.ArrayList;

public class URL {
    @Override
    public String toString() {
        return super.toString();
    }

    private final String protocol;
    private final String host;
    private final String domain;
    private final String topLevelDomain;

    public URL(String url) {
        parseUrl(url);
    }

    private void parseUrl(String url) {
        int columSlashSlash = url.indexOf("://");
        if (columSlashSlash == -1) {
            protocol = null;
        } else {
            protocol = url.substring(0, columSlashSlash)
        }
    }

    private final ArrayList<UrlBatchmarker>();
}
