package tech.alvarez.notifications

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.huawei.agconnect.config.AGConnectServicesConfig
import com.huawei.hms.aaid.HmsInstanceId
import tech.alvarez.notifications.MainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getToken()
    }

    private fun getToken() {
        object : Thread() {
            override fun run() {
                try {
                    val appId = AGConnectServicesConfig.fromContext(this@MainActivity).getString("client/app_id")
                    val token = HmsInstanceId.getInstance(this@MainActivity).getToken(appId, "HCM")
                    if (!TextUtils.isEmpty(token)) {
                        Log.d(TAG, "Token: $token")
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "getToken failed", e)
                }
            }
        }.start()
    }

    companion object {
        val TAG: String? = "DANIEL"
    }
}