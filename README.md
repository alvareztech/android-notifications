# Android Notifications

## HMS

### Client

```groovy
implementation 'com.huawei.hms:push:4.0.3.301'
```

#### Common errors

```
getToken failed, com.huawei.hms.common.ApiException: 907135702: certificate fingerprint empty
```

__Solution__: Add fingerprint to Huawei web console.

```
HMSSDK_HmsInstanceIdEx: TokenTask failed, ErrorCode: 800100000
 getToken failed, com.huawei.hms.common.ApiException: 907122036: no right
```

__Solution__: Update `agconnect-services.json` configuration file.

### Server

#### Get Token

##### Request

```http
POST https://oauth-login.cloud.huawei.com/oauth2/v3/token
Host: oauth-login.cloud.huawei.com
Content-Type: application/x-www-form-urlencoded
```

* `grant_type`: `client_credentials`
* `client_secret`: Your Client Secret
* `client_id`: Your Client ID

##### Response

```json
{
    "access_token": "CgB6e3x9pzAkPR...",
    "expires_in": 3600,
    "token_type": "Bearer"
}
```

#### Send Message

##### Request

```http
POST https://push-api.cloud.huawei.com/v1/[appid]/messages:send
Authorization: Bearer CgB6e3x9pzAkPRPDoctuJ...
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

##### Response

```json
{
    "code": "80000000",
    "msg": "Success",
    "requestId": "160209653167346065000206"
}
```