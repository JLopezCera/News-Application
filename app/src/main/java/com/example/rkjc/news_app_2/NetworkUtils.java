package com.example.rkjc.news_app_2;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    final static String NEWS_BASE_URL =
           "https://newsapi.org/v1/articles?source=the-next-web";


    final static String PARAM_SORT = "sortBy";
    final static String sortBy = "latest";
    final static String Api_Key = "dc06f115ab2345edab56ee52b3944b51";

    public static URL buildUrl() {
        Uri builtUri = Uri.parse(NEWS_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_SORT, sortBy)
                .appendQueryParameter("apiKey", Api_Key)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
