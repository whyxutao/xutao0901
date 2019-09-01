package bw.com.xutao0901eve.model;

import java.io.IOException;

import bw.com.xutao0901eve.app.App;
import bw.com.xutao0901eve.contract.HomeContract;
import bw.com.xutao0901eve.utils.HttpUtil;
import bw.com.xutao0901eve.utils.NewUtil;

public class HomeModel implements HomeContract.IModel {
    @Override
    public void getHomeData(String path, IModelCallBack iModelCallBack) throws IOException {

     if (NewUtil.getInstance().getWang(App.context)){

         HttpUtil.getInstance().getJson(path, new HttpUtil.ICallBack() {
             @Override
             public void onSuccess(Object obj) {

             }

             @Override
             public void onError(String msg) {

             }
         });

     }else {



     }

    }
}
