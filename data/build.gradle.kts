plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kaptPlugin)
}
android {
    compileSdkVersion(AndroidSdk.compileSdk)
    defaultConfig {
        minSdkVersion(AndroidSdk.minSdk)
        targetSdkVersion(AndroidSdk.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

}


dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.ktxCore)

    implementation(DaggerLib.dagger)
    implementation(DaggerLib.daggerSupport)
    kapt(DaggerLib.daggerCompiler)
    kapt(DaggerLib.daggerProcessor)

    implementation(Networking.retrofit)
    implementation(Networking.convertor)

    implementation(RXLibraries.rxAndroid)
    implementation(RXLibraries.rxJava)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

}