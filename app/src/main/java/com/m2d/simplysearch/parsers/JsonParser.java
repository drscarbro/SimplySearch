package com.m2d.simplysearch.parsers;

import com.m2d.simplysearch.model.Results;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 4/15/16.
 */
public class JsonParser {

    public static List<Results> parseFeed(JSONObject content) {

        try {
            JSONArray ar = content.getJSONArray("RelatedTopics");
            List<Results> resultsList = new ArrayList<>();

            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Results results = new Results();

//                results.setRelatedTopics(obj.getString("RelatedTopics")); //result;
                results.setResult(obj.getString("Result")); //result;
                results.setIconUrl(obj.getString("URL")); //iconUrl
                results.setIconHeight(obj.getString("Height")); //iconHeight;
                results.setIconWidth(obj.getString("Width")); //iconWidth;
                results.setFirstUrl(obj.getString("FirstURL")); //firstUrl;
                results.setText(obj.getString("Text")); //text;

                resultsList.add(results);

            }


            return resultsList;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
