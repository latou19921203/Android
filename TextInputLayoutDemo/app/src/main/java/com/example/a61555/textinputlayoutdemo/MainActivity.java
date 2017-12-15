package com.example.a61555.textinputlayoutdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public TextInputLayout userNameWrapper;
    public TextInputLayout emailWrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameWrapper = findViewById(R.id.userName);
        emailWrapper = findViewById(R.id.email);
    }

    private boolean checkUserName() {
        String userName = userNameWrapper.getEditText().getText().toString();
        return userName.equals("")||userName==null ? false : true;
    }

    private boolean checkEmail() {
        String email = emailWrapper.getEditText().getText().toString();
        String emailFormate = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
        Pattern pattern = Pattern.compile(emailFormate);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void login(View v) {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        if (!checkUserName()) {
            userNameWrapper.setError("用户名不正确！");
        } else {
            userNameWrapper.setError("");
            if (!checkEmail()) {
                emailWrapper.setError("邮箱格式不正确！");
            } else {
                emailWrapper.setError("");
            }
        }
    }
}
