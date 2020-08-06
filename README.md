# KotlinStaticAnalysis
Detekt in multi modules Android project

Project contains from three modules:
- app - main application module
- lib_a - Android library module
- lib_b - Android library module

Project demonstrates how Detekt analyses Kotlin code in these three different modules with mistakes made intentionally.

Detekt configuration file is placed in `config/detekt.yml` file and was modified eliminate `NewLineAtEndOfFile` issue in test files.

### Common project updates
Add to project `build.gradle`:

```
buildscript { ... }

plugins {
    id("io.gitlab.arturbosch.detekt").version("1.11.0-RC1")
}

repositories {
    jcenter()
    ...
}
...
```

### Single detekt analyser over the project
Add to project `build.gradle`:

```
...
repositories { ... }

detekt {
    input = files(rootProject.rootDir)
    config = files("config/detekt.yml")
    buildUponDefaultConfig = true

    reports {
        html {
            enabled = true
            destination = file("reports/report.html")
        }
    }
}
```

#### It's possible to integrate Klint into detekt by adding following code to project `build.gradle`

```
...
detekt { ... }

dependencies {
    detektPlugins "io.gitlab.arturbosch.detekt:detekt-formatting:1.11.0-RC1"
}
```

### Parallel code analysing with deteck
Need to add to project `build.gradle` only:
```
...
repositories { ... }

subprojects {
    apply plugin: "io.gitlab.arturbosch.detekt"

    detekt {
        config = files("${project.rootDir}/config/detekt.yml")
        parallel = true
    }
}
```
