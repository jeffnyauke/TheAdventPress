## Kotlin Sample App
[![CircleCI](https://circleci.com/gh/jeffnyauke/TheAdventPress/tree/master.svg?style=shield)](https://circleci.com/gh/jeffnyauke/TheAdventPress/tree/master)
[![codecov](https://codecov.io/gh/jeffnyauke/TheAdventPress/branch/master/graph/badge.svg)](https://codecov.io/gh/jeffnyauke/TheAdventPress)
[![Codacy](https://api.codacy.com/project/badge/Grade/7529460f75c24b51a446103e35433883)](https://www.codacy.com/manual/jeffnyauke/TheAdventPress?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jeffnyauke/TheAdventPress&amp;utm_campaign=Badge_Grade)  
[![CodeStyle](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![Kotlin Version](https://img.shields.io/badge/kotlin-1.3.61-blue.svg)](http://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/gradle-6.1-blue.svg)](https://lv.binarybabel.org/catalog/gradle/latest)
[![API](https://img.shields.io/badge/API-21%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![License](https://img.shields.io/badge/License-Apache%202.0-lightgrey.svg)](http://www.apache.org/licenses/LICENSE-2.0)

<!--<img src="screenshots/demo/demo.gif" width="250" align="right" hspace="20">-->

The Advent Press is an app aimed at presenting the Three Angel's Messages of Revelation 14 and preparing a people for the second coming of Jesus Christ.

## Table of Contents

-   [Tech-stack](https://github.com/jeffnyauke/TheAdventPress#tech-stack)
-   [Resources](https://github.com/jeffnyauke/TheAdventPress#resources)
-   [Contributions](https://github.com/jeffnyauke/TheAdventPress#contributions)
-   [Authors](https://github.com/jeffnyauke/TheAdventPress#authors)
-   [License](https://github.com/jeffnyauke/TheAdventPress#license)

## Tech-stack

This project takes advantage of many popular libraries, plugins and tools of the Android ecosystem. Most of the libraries are in the stable version, unless there is a good reason to use non-stable dependency.

### Dependencies

-   [Jetpack](https://developer.android.com/jetpack):
    -   [Android KTX](https://developer.android.com/kotlin/ktx.html) - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    -   [AndroidX](https://developer.android.com/jetpack/androidx) - major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    -   [Benchmark](https://developer.android.com/studio/profile/benchmark.html) - handles warmup, measures your code performance, and outputs benchmarking results to the Android Studio console.
    -   [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    -   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
    -   [Navigation](https://developer.android.com/guide/navigation/) - helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
    -   [Paging](https://developer.android.com/topic/libraries/architecture/paging/) - helps you load and display small chunks of data at a time. Loading partial data on demand reduces usage of network bandwidth and system resources.
    -   [Room](https://developer.android.com/topic/libraries/architecture/room) - persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
-   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - managing background threads with simplified code and reducing needs for callbacks.
-   [Dagger2](https://dagger.dev/) - dependency injector for replacement all FactoryFactory classes.
-   [Retrofit](https://square.github.io/retrofit/) - type-safe HTTP client.
-   [Coil](https://github.com/coil-kt/coil) - image loading library for Android backed by Kotlin Coroutines.
-   [Moshi](https://github.com/square/moshi) - makes it easy to parse JSON into Kotlin objects.
-   [Timber](https://github.com/JakeWharton/timber) - a logger with a small, extensible API which provides utility on top of Android's normal Log class.
-   [Stetho](http://facebook.github.io/stetho/) - debug bridge for applications via Chrome Developer Tools.
-   [and more...](https://github.com/jeffnyauke/TheAdventPress/blob/master/buildSrc/src/main/kotlin/dependencies/Dependencies.kt)

### Test dependencies

-   [UIAutomator](https://developer.android.com/training/testing/ui-automator) - a UI testing framework suitable for cross-app functional UI testing across system and installed apps.
-   [Espresso](https://developer.android.com/training/testing/espresso) - to write concise, beautiful, and reliable Android UI tests
-   [Robolectric](https://github.com/robolectric/robolectric) - industry-standard unit testing framework for Android.
-   [JUnit](https://github.com/junit-team/junit4) - a simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks.
-   [Mockito](https://github.com/nhaarman/mockito-kotlin) - most popular Mocking framework for unit tests written in Java.
-   [Mockk](https://github.com/mockk/mockk) - provides DSL to mock behavior. Built from zero to fit Kotlin language.
-   [AndroidX](https://github.com/android/android-test) - the androidx test library provides an extensive framework for testing Android apps.
-   [and more...](https://github.com/jeffnyauke/TheAdventPress/blob/master/buildSrc/src/main/kotlin/dependencies/TestDependencies.kt)

### Plugins

-   [Ktlint](https://github.com/pinterest/ktlint) - an anti-bikeshedding Kotlin linter with built-in formatter.
-   [Detekt](https://github.com/arturbosch/detekt) - a static code analysis tool for the Kotlin programming language.
-   [Spotless](https://github.com/diffplug/spotless) - a code formatter can do more than just find formatting errors.
-   [Versions](https://github.com/ben-manes/gradle-versions-plugin) - make easy to determine which dependencies have updates.
-   [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) - generates simple object and builder classes for type-safe navigation and access to any associated arguments.
-   [Jacoco](https://github.com/jacoco/jacoco) - code coverage library
-   [and more...](https://github.com/jeffnyauke/TheAdventPress/blob/master/buildSrc/build.gradle.kts)

## Contributions

All contributions are welcome!
Please feel free to post questions, recommendations, ideas, bugs by create [new issue](https://github.com/jeffnyauke/TheAdventPress/issues/new) following the template or if you want create directly [new pull request](https://github.com/jeffnyauke/TheAdventPress/compare).

## Authors

<a href="https://twitter.com/jeffreynyauke" target="_blank">
  <img src="https://avatars1.githubusercontent.com/u/14073448?s=400&u=e21d2306a36644576535f8f2f7ba939aeee148f1&v=4" width="70" align="left">
</a>

**Jeffrey Nyauke**

[![Linkedin](https://img.shields.io/badge/-linkedin-grey?logo=linkedin)](https://www.linkedin.com/in/jeffreynyauke/)
[![Twitter](https://img.shields.io/badge/-twitter-grey?logo=twitter)](https://twitter.com/jeffreynyauke)
[![Medium](https://img.shields.io/badge/-medium-grey?logo=medium)](https://medium.com/@jeffnyauke)
[![Web](https://img.shields.io/badge/-web-grey?logo=appveyor)](http://theadventpress.org/)

## License

```license
Copyright (c) 2019 jeffnyauke@gmail.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
