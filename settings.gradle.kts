dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://androidx.dev/snapshots/builds/8003490/artifacts/repository")
    }
}
rootProject.name = "Unsplasssh"
include(":app")
 