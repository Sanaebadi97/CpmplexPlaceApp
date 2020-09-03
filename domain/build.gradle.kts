import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.javaLibraryPlugin)
    id(BuildPlugins.kotlinPlugin)
}


dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(RXLibraries.rxAndroid)
    implementation(RXLibraries.rxJava)

    testImplementation(TestLibraries.junit4)
}

// compile bytecode to java 8 (default is java 6)
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}