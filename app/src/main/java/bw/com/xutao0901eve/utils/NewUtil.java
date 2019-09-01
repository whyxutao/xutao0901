package bw.com.xutao0901eve.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NewUtil {

    //单例模式
    private static NewUtil newUtil = null;

    private NewUtil(){}

    public static NewUtil getInstance(){
        if (newUtil==null) {
            synchronized (HttpUtil.class){
                if (newUtil==null) {
                    newUtil = new NewUtil();
                }
            }
        }
        return newUtil;
    }

    //网络判断
    public boolean getWang(Context context){

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null) {
            return info.isAvailable();
        }
        return false;
    }


}
