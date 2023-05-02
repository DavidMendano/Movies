import com.dmendano.com.buildsrc.Libs

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Libs.JavaX.javax)
    implementation(Libs.Retrofit.converterGson)
}
