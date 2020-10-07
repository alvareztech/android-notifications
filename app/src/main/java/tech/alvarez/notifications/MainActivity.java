package tech.alvarez.notifications;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "DANIEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getToken();
    }

    private void getToken() {
        new Thread() {
            @Override
            public void run() {
                try {
                    String appId = AGConnectServicesConfig.fromContext(MainActivity.this).getString("client/app_id");
                    String token = HmsInstanceId.getInstance(MainActivity.this).getToken(appId, "HCM");
                    if (!TextUtils.isEmpty(token)) {
                        Log.d(TAG, "Token: " + token);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "getToken failed", e);
                }
            }
        }.start();
    }
}