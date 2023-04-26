object Versions {
    const val androidx_core= "1.10.0"
    const val androidx_lifecycle= "2.6.1"
    const val androidx_activity= "1.7.1"

    const val compose_ui = "1.4.2"
    const val compose_navigation = "2.5.3"
}

object AndroidX {
    const val androidx_core= "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidx_lifecycle= "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidx_lifecycle}"
    const val androidx_activity= "androidx.activity:activity-compose:${Versions.androidx_activity}"
}

object Compose {
    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose_ui}"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_ui}"
    const val compose_material = "androidx.compose.material:material:${Versions.compose_ui}"
    const val compose_navigation = "androidx.navigation:navigation-compose:${Versions.compose_navigation}"
}