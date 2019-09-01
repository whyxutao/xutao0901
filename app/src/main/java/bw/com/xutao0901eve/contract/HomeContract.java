package bw.com.xutao0901eve.contract;

import android.view.View;

import java.io.IOException;

public interface HomeContract {

    //View
    interface IView{

        void onSuccess();
        void onError(Throwable e);

    }

    //Model
    interface IModel{

        void getHomeData(String path,IModelCallBack iModelCallBack) throws IOException;

        interface IModelCallBack{
            void onSuccess();
            void onError(Throwable e);
        }

    }

    //Presenter
    interface IPresenter{

        //绑定视图
        void attachView(View view);

        //解绑
        void detachView();

        //初始化Model
        void getModel();

    }

}
