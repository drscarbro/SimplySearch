package com.m2d.simplysearch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        output = (TextView) findViewById(R.id.txtVwResults);
        output.setMovementMethod(new ScrollingMovementMethod());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                queryAsync results = new queryAsync();
                results.execute("Anything","Something","Another Thing");
            }

        });
    }

    protected void updateDisplay(String result) {
        output.append(result + "\n");
    }

    private class queryAsync extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute(){
            updateDisplay("I'm Starting Something!");
        }

        @Override
        protected String doInBackground(String... params) {
            return "All done.";
        }

        @Override
        protected void onPostExecute(String results){
            updateDisplay(results);
        }

    }

}
