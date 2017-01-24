package com.example.root.alphamarinegh;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class ViewByDestination extends AppCompatActivity implements View.OnClickListener {

    //Defining views & Buttons
    private EditText editTextDateStart;
    private EditText editTextDateEnd;
    private EditText editTextDest;
    private Button buttonViewDest;
    private Button buttonViewCust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_by_destination);

        //Initializing views
        editTextDateStart = (EditText) findViewById(R.id.editTextDateStart);
        editTextDateEnd = (EditText) findViewById(R.id.editTextDateEnd);
        editTextDest = (EditText) findViewById(R.id.editTextDest);

        //Listeners to buttons
        buttonViewDest = (Button) findViewById(R.id.buttonViewDest);
        buttonViewCust = (Button) findViewById(R.id.buttonViewCust);
        buttonViewDest.setOnClickListener(this);
        buttonViewCust.setOnClickListener(this);
    }

    //Posting query data
    private void queryDestination(){

        final String datestart = editTextDateStart.getText().toString().trim();
        final String dateend = editTextDateEnd.getText().toString().trim();
        final String desting = editTextDest.getText().toString().trim();

        class QueryDestination extends AsyncTask<Void, Void, String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(ViewByDestination.this, "Querying table...",
                        "Please wait...", false,false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ViewByDestination.this,s,Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_LowerDateStart, datestart);
                params.put(Config.KEY_UpperDateEnd, dateend);
                params.put(Config.KEY_DESTINATION, desting);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_GET_DEST, params);
                return res;

            }

        }
        QueryDestination qd = new QueryDestination();
        qd.execute();
    }

    @Override
    public void onClick(View view) {
        if(view == buttonViewDest){
            queryDestination();
            //startActivity(new Intent(this,ByDestination.class));
        }

    }
}
