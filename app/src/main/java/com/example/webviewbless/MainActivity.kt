package com.example.webviewbless

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
var loading: ProgressBar? = null
    lateinit var web: WebView
    var url = "https://google.com"
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loading = load
        web = webView
        web.webViewClient = myWebClient()
        web.loadUrl(url)
        web.settings?.javaScriptEnabled = true
    }

    inner class myWebClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            load!!.visibility = View.VISIBLE
            view.loadUrl(url)
            return true
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            load!!.visibility = View.VISIBLE
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            load!!.visibility = View.GONE
        }
    }
}
