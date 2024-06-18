// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id ("com.android.library") version "7.4.0" apply false
    //hilt
    id("com.google.dagger.hilt.android") version "2.49" apply false
}