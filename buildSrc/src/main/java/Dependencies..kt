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
        const val materialVersion="1.3.0-alpha02"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxVersion}"
    const val material =  "com.google.android.material:material:${Versions.materialVersion}"
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