package com.example.a61555.dbconnectdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private float value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.value);
    }

    public void connect(View view) {
        Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
        /*
            需开新线程建立链接
         */
        new Thread() {
            public void run() {
                Connection connection = DBConnection.getInstance();
                if (connection != null) {
                    Log.i("[Connection]", "OK");
                } else
                    Log.i("[Connection]", "Failed");
            }
        }.start();
    }

    public void setData(View view) {
        Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
        new Thread() {
            public void run() {
                String sql = "UPDATE test1 SET 功率设定2 = "+editText.getText().toString()+" WHERE id = 1";
                Connection connection = DBConnection.getInstance();
                try {
                    Statement statement = connection.createStatement();
                    int result = statement.executeUpdate(sql);
                    Log.i("[Connection]", result+"");
                    DBConnection.disconnect();
                } catch (SQLException e) {
                    e.printStackTrace();
                    DBConnection.disconnect();
                }
            }
        }.start();
    }
}
