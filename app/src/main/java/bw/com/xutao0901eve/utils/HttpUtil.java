package bw.com.xutao0901eve.utils;

import android.os.Handler;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {

    //单例模式
    private static HttpUtil httpUtil = null;

    private HttpUtil(){}

    public static HttpUtil getInstance(){
        if (httpUtil==null) {
            synchronized (HttpUtil.class){
                if (httpUtil==null) {
                    httpUtil = new HttpUtil();
                }
            }
        }
        return httpUtil;
    }

    public interface ICallBack{

        void onSuccess(Object obj);
        void onError(String msg);

    }

    private Handler handler = new Handler();

    public void getJson(final String path, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("GET");
                    int responseCode = connection.getResponseCode();
                    if (responseCode==200) {
                        InputStream inputStream = connection.getInputStream();
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        int len = 0;
                        byte[] buffer = new byte[1024];
                        while ((len = inputStream.read(buffer))!=-1){
                            bos.write(buffer,0,len);
                        }

                        final String json = bos.toString();

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (iCallBack!=null) {
                                    iCallBack.onSuccess(json);
                                }
                            }
                        });

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
