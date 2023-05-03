import com.dmendano.com.buildsrc.Libs

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(Libs.JavaX.javax)
    implementation(Libs.Retrofit.converterGson)
    implementation(Libs.Kotlin.Coroutines.core)
}
