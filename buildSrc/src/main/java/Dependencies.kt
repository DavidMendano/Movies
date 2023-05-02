package com.dmendano.com.buildsrc

object Libs {
    object AndroidX {
        private const val core_version = "1.10.0"

        const val androidx_core = "androidx.core:core-ktx:${core_version}"
        object Activity {
            private const val version = "1.7.1"

            const val activity = "androidx.activity:activity-compose:${version}"
        }

        object Lifecycle {
            private const val version = "2.6.1"

            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val lifecycle =  "androidx.lifecycle:lifecycle-runtime-ktx:${version}"
        }

        object Compose {
            private const val ui_version = "1.4.2"
            private const val navigation_version = "2.5.3"

            const val ui = "androidx.compose.ui:ui:${ui_version}"
            const val ui_tooling = "androidx.compose.ui:ui-tooling-preview:${ui_version}"
            const val material = "androidx.compose.material:material:${ui_version}"
            const val navigation = "androidx.navigation:navigation-compose:${navigation_version}"
        }

        object Navigation {
            private const val version = "1.0.0"

            const val navigation = "androidx.hilt:hilt-navigation-compose:${version}"
        }
    }

    object JavaX {
        private const val version = "1"
        const val javax = "javax.inject:javax.inject:$version"
    }

    object Hilt {
        private const val version = "2.44"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val buildGradle = "com.google.dagger.hilt.android:$version"
    }

    object OkHttp3 {
        private const val version = "4.9.3"

        const val loginInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }
}
