package com.molingyu.webviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 本例中演示了：
 * （1）在webview中调用java native 方法，并获得该方法的返回值（string类型）
 * （2）在java native 调用webview的js方法，无返回值
 */
public class MainActivity extends Activity {
    private WebView mWebView;
    private String TAG = "WebViewDemo";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient());

        // 增加接口方法,让前端页面调用
        mWebView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public String testMethod(final String str1, final String str2) {

                String rtnStr;

                rtnStr = str1 + str2;

                // to-do
                return rtnStr;
            }
        }, "demo");

        /**
         * 调用前端页面定义的JS接口javacalljswithargs
         * javacalljswithargs的定义见assets/demo.html
         */
        findViewById(R.id.javaCallJSWithString).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String arg = "hello world";
                mWebView.loadUrl("javascript:javacalljswithargs(" + "'" + arg + "'" + ")");    //参数需要用单引号括起来
            }
        });

        // 加载B页面
        mWebView.loadUrl("file:///android_asset/demo.html");

    }

}