plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
}

android {
    namespace = "app.ditsdev.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String","BASE_URL" , "${project.findProperty("BASE_URL")}")
        buildConfigField("String","API_KEY","${project.findProperty("API_KEY")}")
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFile("consumer-rules.pro")
        }
        debug {
            isMinifyEnabled = true
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
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.material)
    api(libs.androidx.navigation.fragment.ktx)
    api(libs.androidx.navigation.ui.ktx)
    api(libs.androidx.activity)
    api(libs.androidx.constraintlayout)

    //Koin
    api(libs.insert.koin.koin.core)
    api(libs.insert.koin.koin.android)

    api(libs.recyclerview)
    api(libs.material)

    //COIL LOADER
    api(libs.coil)
    api(libs.coil.network.okhttp)

    //RETROFIT , OKHTTP,GSON
    api(libs.retrofit)
    api(libs.converter.gson)
    api(libs.okhttp)
    api(libs.logging.interceptor)

    api(libs.junit)
    api(libs.androidx.junit)
    api(libs.androidx.espresso.core)

    api(libs.androidx.fragment.testing.manifest)

    api(libs.androidx.fragment.testing)

    api(libs.androidx.runner)
    api(libs.androidx.rules)
    //ROOM
    api(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
    androidTestImplementation(libs.androidx.room.testing)


    //RXJAVA
    api(libs.rxjava)
    api(libs.rxandroid)
    api(libs.adapter.rxjava3)
    api(libs.androidx.room.rxjava3)
    api(libs.androidx.lifecycle.reactivestreams.ktx)

    //SQL CIPHER
    implementation(libs.android.database.sqlcipher)
    implementation(libs.androidx.sqlite.ktx)

    //mockito
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)
}