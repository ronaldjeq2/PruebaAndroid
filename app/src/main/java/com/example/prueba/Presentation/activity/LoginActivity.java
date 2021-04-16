package com.example.prueba.Presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba.R;
import com.example.prueba.Presentation.activity.view.LoginView;
import com.example.prueba.Presentation.presenter.ILoginPresenter;
import com.example.prueba.Presentation.presenter.LoginPresenterCompl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView  {
    @BindView(R.id.editTextTextEmailAddress)
    EditText edtEmail;
    @BindView(R.id.editTextNumberPassword)
    EditText edtPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterCompl(this);
    }

    @OnClick(R.id.button)
    public void submit() {
        loginPresenter.login(edtEmail.getText().toString(), edtPassword.getText().toString());
    }

    @Override
    public void onLoginResult(Boolean success, String message) {
        if (success){
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("email_extra", edtEmail.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
