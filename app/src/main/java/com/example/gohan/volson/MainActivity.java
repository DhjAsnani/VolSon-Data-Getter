package com.example.gohan.volson;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView name,email,mob;
    Button button;
    String server_url = "http://192.168.26.7:8080/Learn/volSon/info.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.textView);
        email= (TextView) findViewById(R.id.textView2);
        mob = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, server_url, (String) null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            button.setBackgroundColor(Color.BLUE);
                            name.setText(response.getString("Name"));
                            email.setText(response.getString("Email"));
                            mob.setText(response.getString("Mobile"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        button.setBackgroundColor(Color.RED);
                        error.printStackTrace();

                    }
                });
                    Singleton.getInstance(MainActivity.this).addToRequestQ(jsonObjectRequest);
            }
        });
    }
}
