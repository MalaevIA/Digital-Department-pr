plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val packageName = "ru.myitschool.work"

android {
    namespace = packageName
    compileSdk = 33 // Или заменить, если `Version.Android.Sdk.compile` реально существует

    defaultConfig {
        applicationId = packageName
        minSdk = 21 // Или заменить на `Version.Android.Sdk.min`, если он есть
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures.viewBinding = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity:1.9.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}
