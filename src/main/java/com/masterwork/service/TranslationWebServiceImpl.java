package com.masterwork.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Specific implementation uses YANDEX.dictionary.web.service
 * and YANDEX.translation.web.service
 */
@ApplicationScoped
public class TranslationWebServiceImpl implements TranslationWebService {

    List<String> translationFromWebServiceString = new ArrayList<String>();

    public List<String> translateViaWebService(String firstEquivalent) {

        String sURL = "https://dictionary.yandex.net/api/v1/dicservice.json/" +
                "lookup?key=dict.1.1.20161208T063510Z.e02a3667c329be0d.2a110ff2e023b6131a5877292a8da39c05967a57" +
                "&lang=en-de&text=" + firstEquivalent;

        System.out.println(sURL);

        try {
            URL url = new URL(sURL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            JsonObject rootobj = root.getAsJsonObject();
            JsonArray definitionArray = rootobj.get("def").getAsJsonArray();

            for (JsonElement tr : definitionArray) {
                JsonObject translationObject = tr.getAsJsonObject();
                JsonArray translationArray = translationObject.get("tr").getAsJsonArray();
                for (JsonElement translationElement : translationArray) {
                    JsonObject translationText = translationElement.getAsJsonObject();
                    String translationString = translationText.get("text").getAsString();
                    translationFromWebServiceString.add(translationString);

                    System.out.println(translationString);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return translationFromWebServiceString;
    }
}
