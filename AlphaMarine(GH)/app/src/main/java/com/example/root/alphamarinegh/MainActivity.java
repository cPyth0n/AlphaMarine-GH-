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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Defining views
    private EditText editTextCID;
    private EditText editTextFName;
    private EditText editTextLName;
    private EditText editTextDest;
    private EditText editTextNBoxes;
    private EditText editTextItems;
    private EditText editTextPF;
    private EditText editTextCity;
    private EditText editTextState;
    private EditText editTextShipto;
    private EditText editTextReceFone;
    private EditText editTextNotes;
    private EditText editTextUC;

    //Defining Buttons
    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initializing views
        editTextCID = (EditText) findViewById(R.id.editTextCID);
        editTextFName = (EditText) findViewById(R.id.editTextFName);
        editTextLName = (EditText) findViewById(R.id.editTextLName);
        editTextDest = (EditText) findViewById(R.id.editTextDest);
        editTextNBoxes = (EditText) findViewById(R.id.editTextNBoxes);
        editTextItems = (EditText) findViewById(R.id.editTextItems);
        editTextPF = (EditText) findViewById(R.id.editTextPF);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        editTextState = (EditText) findViewById(R.id.editTextState);
        editTextShipto = (EditText) findViewById(R.id.editTextShipto);
        editTextReceFone = (EditText) findViewById(R.id.editTextReceFone);
        editTextNotes = (EditText) findViewById(R.id.editTextNotes);
        editTextUC = (EditText) findViewById(R.id.editTextUC);

        //Setting Listeners to buttons
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }
    //Adding Customer
    private void addCustomer(){

        final String cid = editTextCID.getText().toString().trim();
        final String fname = editTextFName.getText().toString().trim();
        final String lname = editTextLName.getText().toString().trim();
        final String dest = editTextDest.getText().toString().trim();
        final String nboxes = editTextNBoxes.getText().toString().trim();
        final String items = editTextItems.getText().toString().trim();
        final String pf = editTextPF.getText().toString().trim();
        final String city = editTextCity.getText().toString().trim();
        final String state = editTextState.getText().toString().trim();
        final String shipto = editTextShipto.getText().toString().trim();
        final String recefone = editTextReceFone.getText().toString().trim();
        final String notes = editTextNotes.getText().toString().trim();
        final String uc = editTextUC.getText().toString().trim();

        class AddCustomer extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Adding...","Wait...",false,false);
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_CUSTID, cid);
                params.put(Config.KEY_FNAME, fname);
                params.put(Config.KEY_LNAME, lname);
                params.put(Config.KEY_DESTINATION, dest);
                params.put(Config.KEY_NBOXES, nboxes);
                params.put(Config.KEY_ITEMS, items);
                params.put(Config.KEY_PFONE, pf);
                params.put(Config.KEY_CITY, city);
                params.put(Config.KEY_STATE, state);
                params.put(Config.KEY_SHIPTO, shipto);
                params.put(Config.KEY_RECEFONE, recefone);
                params.put(Config.KEY_NOTES, notes);
                params.put(Config.KEY_UNITCHARGE, uc);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }
        AddCustomer ac = new AddCustomer();
        ac.execute();
    }
    @Override
    public void onClick(View v){
        if(v == buttonAdd){
            addCustomer();

        }
        if(v == buttonView){
            startActivity(new Intent(this, ViewByDestination.class));
        }
    }
}
