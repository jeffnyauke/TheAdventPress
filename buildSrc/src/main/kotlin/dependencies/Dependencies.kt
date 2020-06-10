/*
 *
 *  Copyright (c) 2020 jeffnyauke@gmail.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package dependencies

/**
 * Project dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"
    const val MATERIAL =
        "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL}"
    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.COROUTINES}"
    const val ROOM = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM}"
    const val RECYCLE_VIEW =
        "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.RECYCLE_VIEW}"
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val NAVIGATION_UI =
        "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val LIFECYCLE_LIVEDATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"
    const val FRAGMENT_KTX =
        "androidx.fragment:fragment-ktx:${BuildDependenciesVersions.FRAGMENT_KTX}"
    const val CONSTRAIN_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAIN_LAYOUT}"
    const val SWIPE_REFRESH_LAYOUT =
        "androidx.swiperefreshlayout:swiperefreshlayout:${BuildDependenciesVersions.SWIPE_REFRESH_LAYOUT}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${BuildDependenciesVersions.PAGING}"
    const val DAGGER = "com.google.dagger:dagger:${BuildDependenciesVersions.DAGGER}"
    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.RETROFIT}"
    const val RETROFIT_CONVERTER =
        "com.squareup.retrofit2:converter-gson:${BuildDependenciesVersions.RETROFIT}"
    const val LOGGING =
        "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersions.LOGGING}"
    const val MOSHI = "com.squareup.moshi:moshi:${BuildDependenciesVersions.MOSHI}"
    const val MOSHI_KTX = "com.squareup.moshi:moshi-kotlin:${BuildDependenciesVersions.MOSHI}"
    const val COIL = "io.coil-kt:coil:${BuildDependenciesVersions.COIL}"
    const val COLLECTIONS =
        "androidx.collection:collection-ktx:${BuildDependenciesVersions.APPCOMPAT}"
    const val PREFERENCES =
        "androidx.preference:preference-ktx:${BuildDependenciesVersions.APPCOMPAT}"
    const val FIREBASE_ANALYTICS =
        "com.google.firebase:firebase-analytics:${BuildDependenciesVersions.FIREBASE_ANALYTICS}"
    const val FIREBASE_ADMOB =
        "com.google.android.gms:play-services-ads:${BuildDependenciesVersions.FIREBASE_ADMOB}"
    const val FIREBASE_APP_INDEXING =
        "com.google.firebase:firebase-appindexing:${BuildDependenciesVersions.FIREBASE_APP_INDEXING}"
    const val FIREBASE_AUTH =
        "com.google.firebase:firebase-auth:${BuildDependenciesVersions.FIREBASE_AUTH}"
    const val FIREBASE_CLOUD_FUNCTIONS =
        "com.google.firebase:firebase-functions-ktx:${BuildDependenciesVersions.FIREBASE_CLOUD_FUNCTIONS}"
    const val FIREBASE_FIRESTORE =
        "com.google.firebase:firebase-firestore-ktx:${BuildDependenciesVersions.FIREBASE_FIRESTORE}"
    const val FIREBASE_DYNAMIC_LINKS =
        "com.google.firebase:firebase-dynamic-links-ktx:${BuildDependenciesVersions.FIREBASE_DYNAMIC_LINKS}"
    const val FIREBASE_APP_MESSAGING =
        "com.google.firebase:firebase-inappmessaging-ktx:${BuildDependenciesVersions.FIREBASE_APP_MESSAGING}"
    const val FIREBASE_APP_MESSAGING_DISPLAY =
        "com.google.firebase:firebase-inappmessaging-display-ktx:${BuildDependenciesVersions.FIREBASE_APP_MESSAGING_DISPLAY}"
    const val FIREBASE_PERFORMANCE =
        "com.google.firebase:firebase-perf:${BuildDependenciesVersions.FIREBASE_PERFORMANCE}"
    const val FIREBASE_REMOTE_CONFIG =
        "com.google.firebase:firebase-config-ktx:${BuildDependenciesVersions.FIREBASE_REMOTE_CONFIG}"
    const val FIREBASE_CLOUD_MESSAGING =
        "com.google.firebase:firebase-messaging:${BuildDependenciesVersions.FIREBASE_CLOUD_MESSAGING}"
    const val FIREBASE_CRASHLYTICS =
        "com.google.firebase:firebase-crashlytics:${BuildDependenciesVersions.FIREBASE_CRASHLYTICS}"
    const val LOTTIE = "com.airbnb.android:lottie:${BuildDependenciesVersions.LOTTIE}"
    const val PERMISSIONS =
        "com.github.florent37:runtime-permission-kotlin:${BuildDependenciesVersions.PERMISSIONS}"
    const val CIRCLE_IMAGE =
        "de.hdodenhof:circleimageview:${BuildDependenciesVersions.CIRCLE_IMAGE}"

    const val PLAY_CORE = "com.google.android.play:core:${BuildDependenciesVersions.PLAY_CORE}"
}
