package com.example.teachvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class glavnaya extends AppCompatActivity {
    private AdapterMask pAdapter;
    private List<Mask> listZakazis = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavnaya);
        ListView ivProducts = findViewById(R.id.ListVideo);
        pAdapter = new AdapterMask(glavnaya.this, listZakazis);
        ivProducts.setAdapter(pAdapter);
        new GetVideo().execute();
    }
    private class GetVideo extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://ngknn.ru:5001/NGKNN/СорокинДА/api/Videos");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();

            } catch (Exception exception) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray tempArray = new JSONArray(s);
                for (int i = 0; i < tempArray.length(); i++) {

                    JSONObject productJson = tempArray.getJSONObject(i);
                    Mask tempProduct = new Mask(
                            productJson.getInt("id"),
                            productJson.getString("Name"),
                            productJson.getString("Video")
                    );
                    listZakazis.add(tempProduct);
                    pAdapter.notifyDataSetInvalidated();
                }
            } catch (Exception ignored) {


            }
        }
    }
}