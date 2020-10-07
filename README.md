# android-notifications

## HMS

```groovy
implementation 'com.huawei.hms:push:4.0.3.301'
```

### Common errors

getToken failed, com.huawei.hms.common.ApiException: 907135702: certificate fingerprint empty

__Solution__: Add fingerprint to web console.

TokenTask failed, ErrorCode: 800100000
/HMSSDK_HmsInstanceIdEx: TokenTask failed, ErrorCode: 800100000
 getToken failed, com.huawei.hms.common.ApiException: 907122036: no right

__Solution__: Update `agconnect-services.json` configuration file.
