package tech.alvarez.notifications

import android.util.Log
import com.huawei.hms.push.HmsMessageService
import com.huawei.hms.push.RemoteMessage
import java.util.*

class MessageService : HmsMessageService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        remoteMessage?.let {
            Log.d(TAG, """
                            onMessageReceived: $remoteMessage
                            getCollapseKey: ${remoteMessage.collapseKey}
                            getData: ${remoteMessage.data}
                            getFrom: ${remoteMessage.from}
                            getTo: ${remoteMessage.to}
                            getMessageId: ${remoteMessage.messageId}
                            getSendTime: ${remoteMessage.sentTime}
                            getMessageType: ${remoteMessage.messageType}
                            getTtl: ${remoteMessage.ttl}
                            """)

            val notification = remoteMessage.notification
            notification?.let {
                Log.i(TAG, """
                                 getImageUrl: ${notification.imageUrl}
                                 getTitle: ${notification.title}
                                 getTitleLocalizationKey: ${notification.titleLocalizationKey}
                                 getTitleLocalizationArgs: ${Arrays.toString(notification.titleLocalizationArgs)}
                                 getBody: ${notification.body}
                                 getBodyLocalizationKey: ${notification.bodyLocalizationKey}
                                 getBodyLocalizationArgs: ${Arrays.toString(notification.bodyLocalizationArgs)}
                                 getIcon: ${notification.icon}
                                 getSound: ${notification.sound}
                                 getTag: ${notification.tag}
                                 getColor: ${notification.color}
                                 getClickAction: ${notification.clickAction}
                                 getChannelId: ${notification.channelId}
                                 getLink: ${notification.link}
                                 getNotifyId: ${notification.notifyId}
                                 """)
            }
        }
    }

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "onNewToken: $token")
    }

    companion object {
        val TAG: String? = "DANIEL"
    }
}