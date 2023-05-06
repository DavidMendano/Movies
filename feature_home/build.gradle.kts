import com.dmendano.com.buildsrc.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dmendano.feature_home"
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

    implementation(Libs.AndroidX.androidx_core)
    implementation(Libs.AndroidX.Activity.activity)

    implementation(Libs.AndroidX.Lifecycle.lifecycle)
    implementation(Libs.AndroidX.Lifecycle.viewmodelKtx)

    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.ui_tooling)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.navigation)
    debugImplementation(Libs.AndroidX.Compose.debug_ui)

    implementation(Libs.AndroidX.Navigation.navigation)

    implementation(Libs.Coil.coil)

    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}