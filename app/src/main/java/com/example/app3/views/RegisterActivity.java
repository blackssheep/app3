package com.example.app3.views;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.persenters.RegisterPersenter;
import com.example.app3.views.interfaces.BaseInterface;
import com.jaiky.imagespickers.ImageSelectorActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 黑羊 on 2017/4/16.
 */

public class RegisterActivity extends BaseActivity implements BaseInterface {
    RegisterPersenter persenter;
    ProgressDialog progressDialog;
    private String[] mString={"问题1","问题2","问题3","问题4"};

    @Bind(R.id.sign_name) EditText _nameText;
    @Bind(R.id.sign_question) Spinner _question;
    @Bind(R.id.sign_answer) EditText _answerText;
    @Bind(R.id.sign_password) EditText _passwordText;
    @Bind(R.id.sign_reEnterPassword) EditText _reEnterPasswordText;
    @Bind(R.id.sign_btn) Button _signupButton;
    @Bind(R.id.sign_link) TextView _loginLink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        persenter=new RegisterPersenter(this);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mString);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        _question.setAdapter(adapter);

        progressDialog = new ProgressDialog(RegisterActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = _nameText.getText().toString();
                String question=mString[_question.getSelectedItemPosition()];
                String answer = _answerText.getText().toString();
                String password = _passwordText.getText().toString();
                String reEnterPassword = _reEnterPasswordText.getText().toString();
                persenter.Register(name,password,reEnterPassword,question,answer);
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        _nameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    //UserName失去焦点时即调用
                    persenter.IsExite(_nameText.getText().toString());
                }
            }
        });
    }
    public void Sign_Name_Error(String error){
        _nameText.setError(error);
    }
    public void Sign_Pwd_Error(String error){
        _passwordText.setError(error);
    }
    public void Sign_Answer_Error(String error){
        _answerText.setError(error);
    }
    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }
}
