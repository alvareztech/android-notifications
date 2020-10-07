# android-notifications

## HMS

### Client

```groovy
implementation 'com.huawei.hms:push:4.0.3.301'
```

#### Common errors

getToken failed, com.huawei.hms.common.ApiException: 907135702: certificate fingerprint empty

__Solution__: Add fingerprint to web console.

TokenTask failed, ErrorCode: 800100000
/HMSSDK_HmsInstanceIdEx: TokenTask failed, ErrorCode: 800100000
 getToken failed, com.huawei.hms.common.ApiException: 907122036: no right

__Solution__: Update `agconnect-services.json` configuration file.

### Server

[Reference](https://developer.huawei.com/consumer/en/doc/HMSCore-References-V5/https-send-api-0000001050986197-V5)


```http
POST
https://oauth-login.cloud.huawei.com/oauth2/v3/token
```

__Header__
Host
oauth-login.cloud.huawei.com
Content-Type
application/x-www-form-urlencoded

__Body__

grant_type
client_credentials
 
client_secret
Is your App Secret

client_id
Is your App ID

__Response__

```json
{
    "access_token": "CgB6e3x9pzAkPR...",
    "expires_in": 3600,
    "token_type": "Bearer"
}
```


```http
POST
https://push-api.cloud.huawei.com/v1/[appid]/messages:send
```

```json
{
    "validate_only": false,
    "message": {
        "notification": {
            "title": "Title 1",
            "body": "Body 1"
        },
        "android": {
            "notification": {
                "title": "Android Title 1",
                "body": "Android Body 1",
                "click_action": {
                    "type": 1,
                    "intent": "#Intent;compo=com.rvr/.Activity;S.W=U;end"
                }
            }
        },
        "token": [
            "client_token_1",
            "client_token_2"
        ]
    }
}
```