package com.example.app3.views;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.beans.UserInfo;
import com.example.app3.beans.UserSession;
import com.example.app3.persenters.LoginPersenter;
import com.example.app3.views.interfaces.ArticleViewInterface;
import com.example.app3.views.interfaces.BaseInterface;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 黑羊 on 2017/4/16.
 */

public class LoginActivity extends BaseActivity implements BaseInterface{
    LoginPersenter persenter=new LoginPersenter(this);
    ProgressDialog progressDialog;


    @Bind(R.id.login_name) EditText _nameText;
    @Bind(R.id.login_password) EditText _passwordText;
    @Bind(R.id.login_btn) Button _loginButton;
    @Bind(R.id.login_link) TextView _signupLink;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);//简化findviewbyid()

        initDialog();

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persenter.login(_nameText.getText().toString(),
                        _passwordText.getText().toString());
            }
        });
        _signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initDialog() {
        progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
    }

    public void Login_Name_Error(String s) {
        _nameText.setError(s);
    }

    public void Login_Pwd_Error(String s) {
        _passwordText.setError(s);
    }

    /**
     * 登陆成功
     */
    public void success(){

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
