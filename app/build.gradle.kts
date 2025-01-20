plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "app.ditsdev.gamingfo"
    compileSdk = 35

    defaultConfig {
        applicationId = "app.ditsdev.gamingfo"
        minSdk = 28
        targetSdk = 34
        //noinspection OldTargetApi
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

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
        viewBinding = true
        buildConfig = true
    }
    dynamicFeatures += setOf(":favorite")
}

dependencies {
    implementation(project(":core"))
    api(libs.recyclerview)
    api(libs.material)

    //COIL LOADER
    implementation(libs.coil)
    implementation(libs.coil.network.okhttp)

    api(libs.androidx.navigation.dynamic.features.fragment)
}