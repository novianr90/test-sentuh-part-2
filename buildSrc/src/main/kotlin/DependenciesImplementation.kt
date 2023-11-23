import org.gradle.api.artifacts.dsl.DependencyHandler

object DependenciesImplementation {
    fun DependencyHandler.core() {
        implementation(Dependency.Core.coreKtx)
    }

    fun DependencyHandler.layout() {
        implementation(Dependency.Layout.appCompat)
        implementation(Dependency.Layout.constraintLayout)
        implementation(Dependency.Layout.coordinatorLayout)
        implementation(Dependency.Layout.androidMaterial)
        implementation(Dependency.Layout.skeletonLayout)
        implementation(Dependency.Layout.shimmer)
        implementation(Dependency.Layout.fragment)
    }

    fun DependencyHandler.hilt() {
        implementation(Dependency.Hilt.hilt)
        kapt(Dependency.Hilt.compiler)
    }

    fun DependencyHandler.retrofit() {
        implementation(Dependency.Retrofit.retrofit)
        implementation(Dependency.Retrofit.gson)
        implementation(Dependency.Retrofit.gsonConverter)
    }

    fun DependencyHandler.okhttp() {
        implementation(Dependency.OkHttp.okhttp)
        implementation(Dependency.OkHttp.interceptor)
    }

    fun DependencyHandler.viewModel() {
        implementation(Dependency.ViewModel.viewModelKtx)
        implementation(Dependency.ViewModel.liveData)
    }

    fun DependencyHandler.glide() {
        implementation(Dependency.Glide.glide)
        kapt(Dependency.Glide.compiler)
    }

    fun DependencyHandler.coroutines() {
        implementation(Dependency.Coroutines.core)
    }

    fun DependencyHandler.unitTest() {
        test(Dependency.UnitTest.junit)
    }

    fun DependencyHandler.androidTestImplementation() {
        androidTest(Dependency.AndroidTest.junit)
        androidTest(Dependency.AndroidTest.espresso)
    }
}