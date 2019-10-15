package com.jiayu.commonbase.contract;

import com.jiayu.commonbase.mvp.IView;
import com.jiayu.commonbase.presenter.AuthPresenter;

public interface AuthContract {
      interface View extends IView {
        void loginSuccess(String data);
    }
    interface Presenter{
          void authLogin(AuthPresenter.OnLoginCallback callback);
    }
}
