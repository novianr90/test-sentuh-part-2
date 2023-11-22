import DependenciesImplementation.core
import DependenciesImplementation.coroutines
import DependenciesImplementation.glide
import DependenciesImplementation.hilt
import DependenciesImplementation.layout
import DependenciesImplementation.okhttp
import DependenciesImplementation.retrofit
import DependenciesImplementation.viewModel

plugins {
    id(ProjectPlugin.androidApp)
    id(ProjectPlugin.kotlinAndroid)
    kotlin(ProjectPlugin.kapt)
    id(ProjectPlugin.hilt)
}

android {
    namespace = AppConfig.nameSpace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    core()
    layout()
    hilt()
    retrofit()
    okhttp()
    viewModel()
    glide()
    coroutines()

}