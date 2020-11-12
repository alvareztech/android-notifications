package tech.alvarez.notifications

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.huawei.agconnect.config.AGConnectServicesConfig
import com.huawei.hms.aaid.HmsInstanceId
import com.huawei.hms.push.HmsMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.subscribeButton).setOnClickListener {
            subscribe("topic1")
        }
        findViewById<Button>(R.id.unsubscribeButton).setOnClickListener {
            unsubscribe("topic1")
        }

        getToken()
    }

    private fun subscribe(topic: String) {
        HmsMessaging.getInstance(this).subscribe(topic).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d(TAG, "Subscribe: SUCCESS")
            } else {
                Log.d(TAG, "Subscribe: FAILURE")
            }
        }
    }

    private fun unsubscribe(topic: String) {
        HmsMessaging.getInstance(this).unsubscribe(topic).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d(TAG, "Unsubscribe: SUCCESS")
            } else {
                Log.d(TAG, "Unsubscribe: FAILURE")
            }
        }
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