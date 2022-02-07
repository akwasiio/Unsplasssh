import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.6.10"
}

val composeVersion = "1.1.0-rc01"
val secretsPropsFile = rootProject.file("./secrets.properties")
val secretsProperties = Properties()
secretsProperties.load(FileInputStream(secretsPropsFile))

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.example.unsplasssh"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "CLIENT_ID", secretsProperties.getProperty("CLIENT_ID"))
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
        kotlinCompilerExtensionVersion = "1.2.0-SNAPSHOT"
    }
}

dependencies {
    val retrofitVersion = "2.9.0"

    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.activity:activity-compose:1.5.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0-alpha01")
    implementation("com.google.accompanist:accompanist-coil:0.12.0")
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    implementation("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}