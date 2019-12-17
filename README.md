# AnsonNewsTestApp

A Machine Test app for Mauqah Technology, illustrating Android development with Kotlin, JetPack, Dagger 2, RxKotlin, Clean Architecture, Junit etc.

Introduction
------------  
### Functionality

Display list of most popular news using [NY Times Most Popular Articles API][1] and show the details of the news.

#### The app has three modules:
1. *app*: The application is implemented using MVVM architecture (ViewModel and Data Binding, etc).
2. *data*: Local and remote data accessing and manipulating components. 
3. *domain*: Basic utils to all application.

### Project characteristics

This project brings to table set of best practices, tools, and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Modern architecture (feature modules, Clean Architecture, Model-View-ViewModel, Model-View-Intent)
* [Android Jetpack](https://developer.android.com/jetpack)
* A single-activity architecture, using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage fragment operations
* Reactive UI
* CI pipeline
* Testing
* Static analysis tools
* Dependency Injection
* Material design

## Tech-stack
<img src="misc/image/application_anim.gif" width="336" align="right" hspace="20">

Min API level is set to [`21`](https://android-arsenal.com/api?level=21), so the presented approach is suitable for over
[85% of devices](https://developer.android.com/about/dashboards) running Android. This project takes advantage of many
popular libraries and tools of the Android ecosystem. Most of the libraries are in the stable version, unless there is a
good reason to use non-stable dependency.

* Tech-stack
    * [Kotlin](https://kotlinlang.org/)  + [RxJava](https://github.com/ReactiveX/RxJava)  - perform background operations
    * [Dagger](https://dagger.dev/) - dependency injection
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - deal with whole in-app navigation
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
  *   [Picasso](https://square.github.io/picasso/) - image loading library with Kotlin idiomatic API
 
* Architecture
    * Clean Architecture (at module level)
    * MVVM + MVI (presentation layer)
    * [Dynamic feature modules](https://developer.android.com/studio/projects/dynamic-delivery)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
    * [Mockito](https://github.com/mockito/mockito) + [Mockito-Kotlin](https://github.com/nhaarman/mockito-kotlin)
   
* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    * Custom tasks
    

## Architecture

Feature related code is placed inside one of the feature modules. This modularized approach provides better
[separation of concerns](https://en.wikipedia.org/wiki/Separation_of_concerns) in the codebase and allows for feature to
be developed in isolation, independently from other features.

## Ci pipeline

[CI pipeline](circle.yml) verifies project correctness which each PR. Some of the tasks run in parallel, while
others like `app build` will not be stared until all `static checks` and `tests` complete successfully:

![ci_pipeline.jpg](misc/image/ci_pipeline.jpg)

These are all of the Gradle tasks (cmd commands) that are [executed by CI](/circle.yml):
* `./gradlew lintDebug` - runs Android lint
* `./gradlew detekt` - runs detekt
* `./gradlew ktlintCheck` - runs ktlint
* `./gradlew testDebugUnitTest` - run unit tests
* `./gradlew :app:bundleDebug` - create app bundle



[1]: https://developer.nytimes.com/docs/most-popular-product/1/overview
