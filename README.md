# Unsplasssh
Sample project to test paging 3 with Jetpack Compose


## Prerequisite

To build this project you require: 
  
  - Android Studio 2021.1 or higher
  - Gradle 7.0.4+
  - Kotlin 1.6.10
  - Client ID from [Unsplash Developers](https://unsplash.com/developers)
  - Copy your app's Access Key, then add the following to your `local.properties`: 

```
ACCESS_KEY="<YOUR ACCESS KEY>"
```

  
## Libraries


- [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - For persisting view state across config changes
- [Jetpack Compose](https://developer.android.com/jetpack/compose?gclsrc=ds&gclsrc=ds) - Android's modern UI toolkit for building native UI
- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client and supports coroutines out of the box.  
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logs HTTP request and response data.
- [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization) - A cross-platform and multi-format framework for data serialization
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines for asynchronous programming
- [Dagger Hilt](https://dagger.dev/hilt) - handles dependency injection
- [Paging 3](https://developer.android.com/jetpack/androidx/releases/paging) - Library for pagination
