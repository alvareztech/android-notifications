package tech.alvarez.notifications;

import android.util.Log;

import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;

import java.util.Arrays;

public class MessageService extends HmsMessageService {

    public static final String TAG = "DANIEL";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "onMessageReceived: " + remoteMessage);

        Log.d(TAG, "getCollapseKey: " + remoteMessage.getCollapseKey()
                + "\n getData: " + remoteMessage.getData()
                + "\n getFrom: " + remoteMessage.getFrom()
                + "\n getTo: " + remoteMessage.getTo()
                + "\n getMessageId: " + remoteMessage.getMessageId()
                + "\n getSendTime: " + remoteMessage.getSentTime()
                + "\n getMessageType: " + remoteMessage.getMessageType()
                + "\n getTtl: " + remoteMessage.getTtl());

        RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification != null) {
            Log.i(TAG, "\n getImageUrl: " + notification.getImageUrl()
                    + "\n getTitle: " + notification.getTitle()
                    + "\n getTitleLocalizationKey: " + notification.getTitleLocalizationKey()
                    + "\n getTitleLocalizationArgs: " + Arrays.toString(notification.getTitleLocalizationArgs())
                    + "\n getBody: " + notification.getBody()
                    + "\n getBodyLocalizationKey: " + notification.getBodyLocalizationKey()
                    + "\n getBodyLocalizationArgs: " + Arrays.toString(notification.getBodyLocalizationArgs())
                    + "\n getIcon: " + notification.getIcon()
                    + "\n getSound: " + notification.getSound()
                    + "\n getTag: " + notification.getTag()
                    + "\n getColor: " + notification.getColor()
                    + "\n getClickAction: " + notification.getClickAction()
                    + "\n getChannelId: " + notification.getChannelId()
                    + "\n getLink: " + notification.getLink()
                    + "\n getNotifyId: " + notification.getNotifyId());
        }
    }

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);

        Log.d(TAG, "onNewToken: " + token);
    }
}
