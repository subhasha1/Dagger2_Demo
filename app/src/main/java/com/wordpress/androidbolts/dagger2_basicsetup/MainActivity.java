package com.wordpress.androidbolts.dagger2_basicsetup;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerApplication.component(this).inject(this);


        final TextView tvLabel = (TextView) findViewById(R.id.tvLabel);
        final EditText etInput = (EditText) findViewById(R.id.etText);
        Button button = (Button) findViewById(R.id.btnSave);
        assert button != null;
        assert tvLabel != null;
        assert etInput != null;

        tvLabel.setText(sharedPreferences.getString("key_label", ""));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putString("key_label", etInput.getText().toString()).apply();
                tvLabel.setText(sharedPreferences.getString("key_label", ""));
            }
        });
    }
}
