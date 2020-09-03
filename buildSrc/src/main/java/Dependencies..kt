const val kotlinVersion = "1.4.0"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.0.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kaptPlugin = "kotlin-kapt"
    const val androidLibrary = "com.android.library"
    const val javaLibraryPlugin = "java-library"
    const val kotlinPlugin = "kotlin"

}


object AndroidSdk {
    const val minSdk = 21
    const val compileSdk = 29
    const val targetSdk = compileSdk
    const val applicationId = "info.sanaebadi.placeapp"
}

object Libraries {
    private object Versions {
        const val appCompatVersion = "1.2.0"
        const val constraintLayoutVersion = "2.0.0"
        const val ktxVersion = "1.3.0"
        const val materialVersion = "1.3.0-alpha02"
        const val arrowVersion = "1.0.0"
        const val lifeCycleVersion = "2.2.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val arrow = "com.fernandocejas:arrow:${Versions.arrowVersion}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleVersion}"
    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycleVersion}"

}

object TestLibraries {
    private object Versions {
        const val junitVersion = "4.12"
        const val testRunnerVersion = "1.1.0-alpha4"
        const val espressoVersion = "3.1.0-alpha4"
    }

    const val junit4 = "junit:junit:${Versions.junitVersion}"
    const val testRunner = "androidx.test:runner:${Versions.testRunnerVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
}


object Networking {
    private object Versions {
        const val retrofitVersion = "2.3.0"
        const val converterGsonVersion = "2.2.0"
        const val rxRetrofitAdapterVersion = retrofitVersion
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val convertor = "com.squareup.retrofit2:converter-gson:${Versions.converterGsonVersion}"
    const val rxRetrofitAdapter =
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.rxRetrofitAdapterVersion}"
}


object RXLibraries {
    private object Versions {
        const val rxAndroidVersion = "2.1.1"
        const val rxJavaVersion = "2.2.10"
    }

    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
}

object DaggerLib {
    private object Versions {
        const val daggerVersion = "2.26"
    }

    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"

}