 package com.example.findnoy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.findnoy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {


    private EditText email, password;
    private Button login;
    private static String URL_LOGIN = "http://192.168.43.23/FindNoy/login.php";
    private ProgressBar loading;
    private String inputUsername,inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceSta te) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        loading = findViewById(R.id.progressBar);
        email = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GET INPUTED DATA

                inputUsername = email.getText().toString().trim();
                inputPassword = password.getText().toString().trim();

            //    Toast.makeText(LogIn.this,"ERROR: " + inputUsername + inputPassword,Toast.LENGTH_SHORT).show();

                if(!inputUsername.isEmpty() || !inputPassword.isEmpty()){
                    Login(inputUsername,inputPassword);
                }else {
                    email.setError("Please input your username or email");
                    password.setError("Please input your password");
                }

              //  Intent intentDashboard = new Intent(LogIn.this, dashboard.class);
              //  startActivity(intentDashboard);
            }
        });
    }

    private void Login(final String em, final String pass){
        loading.setVisibility(View.VISIBLE);
        //login.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // Toast.makeText(LogIn.this,"RESPONSE: " + response,Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                  //  Toast.makeText(LogIn.this,"ERROR: " + jsonObject.toString(),Toast.LENGTH_SHORT).show();
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");

                    if(success.equals("1")){
                        for(int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);
                           // String userEmail = object.getString("email").trim();

                            Toast.makeText(LogIn.this, "Successfully login",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LogIn.this, dashboard.class);
                            startActivity(intent);

                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LogIn.this,"ERROR: " + e.toString(),Toast.LENGTH_LONG).show();
                    loading.setVisibility(View.GONE);
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LogIn.this,"Error: " + error.toString(),
                                Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", em);
                params.put("password", pass);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
      //  Toast.makeText(LogIn.this,"test: " + stringRequest.toString(),
      //          Toast.LENGTH_SHORT).show();

    }
}
