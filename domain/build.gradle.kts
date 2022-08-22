plugins {
    id(Dependency.Application.javaLibrary)
    id(Dependency.Kotlin.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
}
dependencies {
    //Test
    testImplementation(Dependency.Test.jUnit)
    testImplementation(Dependency.Test.mockitoCore)
    testImplementation(Dependency.Test.mockitoInline)
    testImplementation(Dependency.Test.mockito)

    //Coroutine
    implementation(Dependency.Coroutine.coroutine)

    //Inject
    implementation(Dependency.Dagger2.daggerInject)

}