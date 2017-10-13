package data;

import exception.InvalidURLException;

import java.util.ArrayList;

public class URL {
    private final String protocol;
    private final String host;
    private final String domain;
    private final String topLevelDomain;
    private final ArrayList<UrlBatchmarker> batchMarkers;


    public URL(String url) throws InvalidURLException {

        for (char c = 'a'; c < 125; c++) {
            System.out.println(c);
        }
        //Get protocol
        int columSlashSlash = url.indexOf("://");
        int firstDot = url.indexOf(".");
        int firstSlash = url.indexOf("/", columSlashSlash + 3);
        int secondDot = url.indexOf(".", firstDot + 1);
        int lastDot = url.lastIndexOf(".");


        //check for errors
        if (firstDot == -1 || firstDot < columSlashSlash) {
            throw new InvalidURLException("URL is invalid: " + url);
        }


        //Get protocol
        if (columSlashSlash == -1) {
            protocol = null;
        } else {
            protocol = url.substring(0, columSlashSlash);
        }

        //Check if there is a host & get host
        if (secondDot == lastDot) {
            host = null;
        } else {
            host = url.substring(columSlashSlash + 3, firstDot);
        }

        //Get domain
        if (host == null) {
            domain = url.substring(columSlashSlash + 3, firstDot);
        } else {
            domain = url.substring(firstDot + 1, secondDot);
        }

        //Get top level domain


        topLevelDomain = null;
        batchMarkers = null;
        System.out.println(protocol);
        System.out.println(host);
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
