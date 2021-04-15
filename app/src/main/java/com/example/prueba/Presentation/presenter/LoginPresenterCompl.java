package com.example.prueba.Presentation.presenter;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.prueba.Data.LoginResponse;
import com.example.prueba.Domain.adapter.MyApiAdapter;
import com.example.prueba.Presentation.activity.view.LoginView;
import com.example.prueba.Presentation.model.Login;
import com.example.prueba.Presentation.model.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterCompl implements ILoginPresenter, Callback<LoginResponse> {
    LoginView loginView;
    Login login;
    Handler handler;

    public LoginPresenterCompl(LoginView loginView) {
        this.loginView = loginView;

        handler = new Handler(Looper.getMainLooper());
    }



    public void login(String name, String passwd) {
       Call<LoginResponse> call = MyApiAdapter.getApiService().postLogin(name, passwd);
       call.enqueue(this);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        loginView.onSetProgressBarVisibility(visiblity);
    }

    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if (response.isSuccessful()){
            loginView.onLoginResult(login.getSuccess(), login.getMessage());
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        loginView.onLoginResult(true, "error");
    }
}
