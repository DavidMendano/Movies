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
    implementation(project(path = ":home:home_domain"))

    implementation(Libs.JavaX.javax)
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.converterGson)
}
