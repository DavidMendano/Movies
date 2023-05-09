plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dmendano.feature_favourites"
    compileSdk = 33

    defaultConfig {
        minSdk = 28
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":common"))

    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.androidx_core)
    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.Activity.activity)

    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.Lifecycle.lifecycle)
    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.Lifecycle.viewmodelKtx)

    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.Compose.ui)
    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.Compose.ui_tooling)
    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.Compose.material)
    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.Compose.navigation)
    debugImplementation(com.dmendano.com.buildsrc.Libs.AndroidX.Compose.debug_ui)

    implementation(com.dmendano.com.buildsrc.Libs.AndroidX.Navigation.navigation)

    implementation(com.dmendano.com.buildsrc.Libs.Hilt.android)
    kapt(com.dmendano.com.buildsrc.Libs.Hilt.compiler)

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}