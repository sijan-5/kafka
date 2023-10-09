plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.kafka"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.kafka"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("org.apache.kafka:kafka-clients:3.5.1")

    //noinspection GradleDynamicVersion
    implementation ("com.rudderstack.android.sdk:core:1.20.0")
// add the following line if you don't have Gson included already
    //noinspection GradleDynamicVersion
    implementation ("com.google.code.gson:gson:2.10.1")


    //sql-cipher
    implementation ("net.zetetic:android-database-sqlcipher:4.5.4")
    implementation ("androidx.sqlite:sqlite:2.3.1")

    //lifecycle
    // required for new life cycle methods
    implementation ("androidx.lifecycle:lifecycle-process:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-common:2.6.1")

    
}
