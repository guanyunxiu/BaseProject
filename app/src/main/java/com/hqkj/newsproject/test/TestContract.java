package com.hqkj.newsproject.test;

import com.hqkj.newsproject.base.BaseContract;
import com.hqkj.newsproject.bean.UserModel;


import io.reactivex.Observable;

public interface TestContract {
    interface View extends BaseContract.BaseView{
          void onSuccess(int id);
    }
    interface Presenter extends BaseContract.BasePresenter<View> {
        void onLogin();
    }
}
