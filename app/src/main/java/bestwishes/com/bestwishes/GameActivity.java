package bestwishes.com.bestwishes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GameActivity extends AppCompatActivity {

    public boolean showAd=false;
    int dalayTime=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        WebView webView;
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new InsideWebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("file:///android_asset/index.html");


        Intent intent = getIntent();
        String link = intent.getDataString();
        if(link != null)
            Toast.makeText(GameActivity.this, "DATA..." + link, Toast.LENGTH_SHORT).show();

    }



    @Override
    protected void onResume() {
        super.onResume();
        showAd=true;
    }


    @Override
    protected void onPause() {
        super.onPause();
        showAd=false;

    }

    protected class InsideWebViewClient extends WebViewClient {
        //show progress dialog
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            findViewById(R.id.progress1).setVisibility(View.VISIBLE);
        }

        @Override
        // close progress dialog
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            findViewById(R.id.progress1).setVisibility(View.GONE);
        }
    }



}
