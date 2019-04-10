package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @author root
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    CircleView circleView;
//    XWalkView webView;
    WebView webView;

    String url = "https://file56334719749c.iamh5.cn/v3/idea/iAhaciaQ";

//    @Override
//    protected void onXWalkReady() {
//        XWalkPreferences.setValue(XWalkPreferences.ANIMATABLE_XWALK_VIEW, true);
//        XWalkSettings setting = webView.getSettings();
//        setting.setLoadWithOverviewMode(false);
//        setting.setJavaScriptEnabled(true);//支持js
//        setting.setJavaScriptCanOpenWindowsAutomatically(true);    //支持通过JS打开新窗口
//        setting.setUseWideViewPort(true);                     //将图片调整到合适webview的大小
//        setting.setLoadWithOverviewMode(true);                 //缩放至屏幕的大小
//        setting.setLoadsImagesAutomatically(true);                //支持自动加载图片
//        setting.setSupportMultipleWindows();                        //支持多窗口
//        setting.setSupportZoom(true);
//        setting.setAllowFileAccess(true);
//        setting.setDomStorageEnabled(true);
//        setting.setAllowContentAccess(true);
//        setting.setAllowContentAccess(true);
//        setting.setDomStorageEnabled(true);
//        webView.requestFocus()
//        setting.cacheMode = WebSettings.LOAD_NO_CACHE
//        webView.setResourceClient(object : XWalkResourceClient(xwalkview) {
//            override fun onLoadStarted(view: XWalkView?, url: String?) {
//                super.onLoadStarted(view, url)
//            }
//
//            override fun onLoadFinished(view: XWalkView?, url: String?) {
//                super.onLoadFinished(view, url)
//            }
//
//            override fun shouldOverrideUrlLoading(view: XWalkView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//
//            override fun onReceivedSslError(view: XWalkView?, callback:
//            ValueCallback<Boolean>?, error: SslError?) {
//                callback?.onReceiveValue(true)
//                super.onReceivedSslError(view, callback, error)
//            }
//
//
//            override fun onReceivedLoadError(view: XWalkView?, errorCode: Int,
//                    description: String?, failingUrl: String?) {
//                super.onReceivedLoadError(view, errorCode, description, failingUrl)
//            }
//
//            override fun onProgressChanged(view: XWalkView?, process: Int) {
//                super.onProgressChanged(view, process)
//                if (...) {
//                    ...
//                    progressBar.setProgress(process)
//                    ...
//                } else {
//                    ...
//                }
//            }
//        })
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleView = findViewById(R.id.cv_circle_view);
        webView = findViewById(R.id.mv_load);
        webView.loadUrl(url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });

    }

    public void clickMe(View view) {

//        Log.d(TAG, "clickMe: ");
//        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(circleView, "color", 0xffff0000, 0xff00ff00);
//        objectAnimator.setEvaluator(new ArgbEvaluator());
//        objectAnimator.start();
//        ObjectAnimator animator =
//                ObjectAnimator.ofObject(circleView, "point",
//                        new PointEvaluator(), new PointF(100, 100), new PointF(200, 200));
//        animator.start();
    }
}
