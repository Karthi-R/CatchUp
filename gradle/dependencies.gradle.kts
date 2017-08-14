import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

/*
 * Copyright (c) 2017 Zac Sweers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Versions {
  val androidTestSupport = "0.4.1"
  val apollo = "0.4.0"
  val archComponents = "1.0.0-alpha8"
  val autodispose = "0.2.0"
  val avFirebase = "1.1.0"
  val avMoshi = "0.4.3"
  val barber = "1.3.1"
  val butterknife = "8.8.1"
  val chuck = "1.1.0"
  val conductor = "2.1.4"
  val dagger = "2.11"
  val espresso = "2.2.1"
  val firebase = "11.0.4"
  val glide = "4.0.0"
  val inspector = "0.2.0"
  val kotlin = "1.1.4-eap-77"
  val leakcanary = "1.5.1"
  val okhttp = "3.8.1"
  val playServices = "11.0.4"
  val retrofit = "2.3.0"
  val rxbinding = "2.0.0"
  val rxpalette = "0.3.0"
  val stetho = "1.5.0"
  val support = "26.0.1"
}

object Deps {
  object android {
    object arch {
      object lifecycle {
        val apt = "android.arch.lifecycle:compiler:${Versions.archComponents}"
        val extensions = "android.arch.lifecycle:extensions:${Versions.archComponents}"
      }

      object room {
        val apt = "android.arch.persistence.room:compiler:${Versions.archComponents}"
        val runtime = "android.arch.persistence.room:runtime:${Versions.archComponents}"
        val rxJava2 = "android.arch.persistence.room:rxjava2:${Versions.archComponents}"
      }
    }

    object build {
      val buildToolsVersion = "26.0.0"
      val compileSdkVersion = 26
      val minSdkVersion = 21
      val targetSdkVersion = 26
    }

    object firebase {
      val core = "com.google.firebase:firebase-core:${Versions.firebase}"
      val config = "com.google.firebase:firebase-config:${Versions.firebase}"
      val database = "com.google.firebase:firebase-database:${Versions.firebase}"
      val gradlePlugin = "com.google.firebase:firebase-plugins:1.1.1"
      val perf = "com.google.firebase:firebase-perf:${Versions.firebase}"
    }

    val gradlePlugin = "com.android.tools.build:gradle:3.0.0-beta2"

    object support {
      val annotations = "com.android.support:support-annotations:${Versions.support}"
      val appCompat = "com.android.support:appcompat-v7:${Versions.support}"
      val cardView = "com.android.support:cardview-v7:${Versions.support}"
      val constraintLayout = "com.android.support.constraint:constraint-layout:1.1.0-beta1"
      val customTabs = "com.android.support:customtabs:${Versions.support}"
      val design = "com.android.support:design:${Versions.support}"
      val multidex = "com.android.support:multidex:1.0.2"
      val palette = "com.android.support:palette-v7:${Versions.support}"
      val percent = "com.android.support:percent:${Versions.support}"
      val recyclerView = "com.android.support:recyclerview-v7:${Versions.support}"
      val compat = "com.android.support:support-compat:${Versions.support}"
      val v4 = "com.android.support:support-v4:${Versions.support}"
    }
  }

  object apollo {
    val androidSupport = "com.apollographql.apollo:apollo-android-support:${Versions.apollo}"
    val gradlePlugin = "com.apollographql.apollo:gradle-plugin:${Versions.apollo}"
    val runtime = "com.apollographql.apollo:apollo-runtime:${Versions.apollo}"
    val rx2Support = "com.apollographql.apollo:apollo-rx2-support:${Versions.apollo}"
  }

  object auto {
    object value {
      object apt {
        val core = "com.google.auto.value:auto-value:1.4.1"
        val annotations = "com.jakewharton.auto.value:auto-value-annotations:1.4"
      }

      object compileOnly {
        val annotations = "com.jakewharton.auto.value:auto-value-annotations:1.4"
      }

      object extensions {
        object firebase {
          object apt {
            val core = "me.mattlogan.auto.value:auto-value-firebase:${Versions.avFirebase}"
          }

          object compileOnly {
            val annotation = "me.mattlogan.auto.value:auto-value-firebase-annotation:${Versions.avFirebase}"
          }

          val adapter = "me.mattlogan.auto.value:auto-value-firebase-adapter:${Versions.avFirebase}"
        }

        object moshi {
          object apt {
            val core = "com.ryanharter.auto.value:auto-value-moshi:${Versions.avMoshi}"
          }

          object compileOnly {
            val annotations = "com.ryanharter.auto.value:auto-value-moshi-annotations:${Versions.avMoshi}"
          }
        }

        object redacted {
          object apt {
            val core = "com.squareup.auto.value:auto-value-redacted:1.0.1"
          }
        }
      }
    }
  }

  object autoDispose {
    val core = "com.uber.autodispose:autodispose:${Versions.autodispose}"
    val android = "com.uber.autodispose:autodispose-android:${Versions.autodispose}"
    val kotlin = "com.uber.autodispose:autodispose-kotlin:${Versions.autodispose}"
  }

  object barber {
    val apt = "io.sweers.barber:barber-compiler:${Versions.barber}"
    val api = "io.sweers.barber:barber-api:${Versions.barber}"
  }

  object build {
    val ci = "true" == System.getenv("CI")
    // query git for the SHA, Tag and commit count. Use these to automate versioning.
    val gitSha = "git rev-parse --short HEAD".execute(project.rootDir)
    val gitTag = "git describe --tags".execute(project.rootDir)
    val gitCommitCount = 100 + Integer.parseInt(
        "git rev-list --count HEAD".execute(project.rootDir) ?: "0")
    val gitTimestamp = "git log -n 1 --format=%at".execute(rootDir)

    object gradlePlugins {
      val bugsnag = "com.bugsnag:bugsnag-android-gradle-plugin:2.4.2"
      val psync = "io.sweers.psync:psync:2.0.0-SNAPSHOT"
      val versions = "com.github.ben-manes:gradle-versions-plugin:0.15.0"
    }

    object repositories {
      val google = "https://maven.google.com"
      val jitpack = "https://jitpack.io"
      val kotlinEap = "http://dl.bintray.com/kotlin/kotlin-eap-1.1"
      val snapshots = "https://oss.sonatype.org/content/repositories/snapshots/"
    }
  }

  object butterKnife {
    val apt = "com.jakewharton:butterknife-compiler:${Versions.butterknife}"
    val runtime = "com.jakewharton:butterknife:${Versions.butterknife}"
  }

  object chuck {
    val debug = "com.readystatesoftware.chuck:library:${Versions.chuck}"
    val release = "com.readystatesoftware.chuck:library-no-op:${Versions.chuck}"
  }

  object conductor {
    val core = "com.bluelinelabs:conductor:${Versions.conductor}"
    val autoDispose = "com.bluelinelabs:conductor-autodispose:${Versions.conductor}"
    val support = "com.bluelinelabs:conductor-support:${Versions.conductor}"
  }

  object dagger {
    object android {
      object apt {
        val processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
      }

      val runtime = "com.google.dagger:dagger-android:${Versions.dagger}"
    }

    object apt {
      val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    val runtime = "com.google.dagger:dagger:${Versions.dagger}"
  }

  object errorProne {
    object build {
      val core = "com.google.errorprone:error_prone_core:2.0.21"
    }

    object compileOnly {
      val annotations = "com.google.errorprone:error_prone_annotations:2.0.21"
    }

    val gradlePlugin = "net.ltgt.gradle:gradle-errorprone-plugin:0.0.10"
  }

  object glide {
    val core = "com.github.bumptech.glide:glide:${Versions.glide}"
    val okhttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
  }

  object inspector {
    object apt {
      val compiler = "io.sweers.inspector:inspector-compiler:${Versions.inspector}"

      object extensions {
        val android = "io.sweers.inspector:inspector-android-compiler-extension:${Versions.inspector}"
        val autovalue = "io.sweers.inspector:inspector-autovalue-compiler-extension:${Versions.inspector}"
        val nullability = "io.sweers.inspector:inspector-nullability-compiler-extension:${Versions.inspector}"
      }
    }

    val core = "io.sweers.inspector:inspector:${Versions.inspector}"

    object factoryCompiler {
      val apt = "io.sweers.inspector:inspector-factory-compiler:${Versions.inspector}"

      object compileOnly {
        val annotations = "io.sweers.inspector:inspector-factory-compiler-annotations:${Versions.inspector}"
      }
    }
  }

  object kotlin {
    val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    object stdlib {
      val core = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
      val jre7 = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
    }
  }

  object leakCanary {
    val debug = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
    val release = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leakcanary}"
  }

  object misc {
    val bugsnag = "com.bugsnag:bugsnag-android:3.9.0"

    object debug {
      val madge = "com.jakewharton.madge:madge:1.1.4"
      val processPhoenix = "com.jakewharton:process-phoenix:2.0.0"
      val scalpel = "com.jakewharton.scalpel:scalpel:1.1.2"
      val telescope = "com.mattprecious.telescope:telescope:2.1.0"
    }

    val diskLruCache = "com.jakewharton:disklrucache:2.0.2"
    val javaxInject = "org.glassfish:javax.annotation:10.0-b28"
    val jsr305 = "com.google.code.findbugs:jsr305:3.0.2"
    val lazythreeten = "com.gabrielittner.threetenbp:lazythreetenbp:0.2.0"
    val lottie = "com.airbnb.android:lottie:2.1.2"
    val moshi = "com.squareup.moshi:moshi:1.5.0"
    val moshiLazyAdapters = "com.serjltt.moshi:moshi-lazy-adapters:2.0"
    val okio = "com.squareup.okio:okio:1.13.0"
    val recyclerViewAnimators = "jp.wasabeef:recyclerview-animators:2.2.7"
    val simpleXml = "org.simpleframework:simple-xml:2.7.1"
    val timber = "com.jakewharton.timber:timber:4.5.1"
    val unbescape = "org.unbescape:unbescape:1.1.5.RELEASE"
  }

  object okhttp {
    val core = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

    object debug {
      val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    val webSockets = "com.squareup.okhttp3:okhttp-ws:${Versions.okhttp}"
  }

  object retrofit {
    val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    object debug {
      val mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    }

    val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val rxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val xml = "com.squareup.retrofit2:converter-simplexml:${Versions.retrofit}"
  }

  object rx {
    val android = "io.reactivex:rxandroid:1.2.1"

    object binding {
      val core = "com.jakewharton.rxbinding2:rxbinding:${Versions.rxbinding}"
      val v4 = "com.jakewharton.rxbinding2:rxbinding-support-v4:${Versions.rxbinding}"
      val design = "com.jakewharton.rxbinding2:rxbinding-design:${Versions.rxbinding}"
    }

    val java = "io.reactivex:rxjava:1.3.0"
    val preferences = "com.f2prateek.rx.preferences2:rx-preferences:2.0.0-RC3"
    val receivers = "com.f2prateek.rx.receivers:rx-receivers:0.1.0"
    val relay = "com.jakewharton.rxrelay2:rxrelay:2.0.0"
    val java2 = "io.reactivex.rxjava2:rxjava:2.1.2"
    val android2 = "io.reactivex.rxjava2:rxandroid:2.0.1"
    val java2Interop = "com.github.akarnokd:rxjava2-interop:0.10.2"
    val java2Extensions = "com.github.akarnokd:rxjava2-extensions:0.17.5"

    object palette {
      val core = "io.sweers.rxpalette:rxpalette:${Versions.rxpalette}"
      val kotlin = "io.sweers.rxpalette:rxpalette-kotlin:${Versions.rxpalette}"
    }
  }

  object stetho {
    object debug {
      val core = "com.facebook.stetho:stetho:${Versions.stetho}"
      val okhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
      val timber = "com.facebook.stetho:stetho-timber:${Versions.stetho}"
    }
  }

  object test {
    object android {
      object espresso {
        val core = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
        val contrib = "com.android.support.test.espresso:espresso-contrib:${Versions.espresso}"
        val web = "com.android.support.test.espresso:espresso-web:${Versions.espresso}"
      }

      val runner = "com.android.support.test:runner:${Versions.androidTestSupport}"
      val rules = "com.android.support.test:rules:${Versions.androidTestSupport}"
    }

    val junit = "junit:junit:4.12"
    val robolectric = "org.robolectric:robolectric:3.2.2"
    val truth = "com.google.truth:truth:0.34"
  }
}

val commandRegex = "\\s".toRegex()

fun String.execute(workingDir: File): String? {
  try {
    val parts = split(commandRegex)
    val proc = ProcessBuilder(*parts.toTypedArray())
        .directory(workingDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()

    proc.waitFor(5, TimeUnit.SECONDS)
    return proc.inputStream.bufferedReader().readText().trim()
  } catch(e: IOException) {
    e.printStackTrace()
    return null
  }
}
