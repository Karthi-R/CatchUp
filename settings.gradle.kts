import org.gradle.kotlin.dsl.repositories

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

//pluginManagement {
//  repositories {
//    gradlePluginPortal()
//    google()
//  }
//  resolutionStrategy {
//    eachPlugin {
//      if (requested.id.id == "com.android.application") {
//        useModule("com.android.tools.build:gradle:${requested.version}")
//      }
//    }
//  }
//}

include(
  ":app",
  ":third_party:bypass",
  ":service-api",
  ":services:slashdot",
  ":services:reddit",
  ":services:hackernews",
  ":services:medium",
  ":services:producthunt",
  ":services:designernews",
  ":services:dribbble",
  ":services:imgur",
  ":services:github",
  ":gemoji",
  ":tooling:moshkt:api",
  ":tooling:moshkt:compiler",
//  ":tooling:moshkt:integration",
  ":util"
)

//project(":bypass").projectDir = File(rootDir, "third_party/bypass")
//project(":slashdot").projectDir = File(rootDir, "services/slashdot")
//project(":reddit").projectDir = File(rootDir, "services/reddit")
//project(":hackernews").projectDir = File(rootDir, "services/hackernews")
//project(":medium").projectDir = File(rootDir, "services/medium")
//project(":producthunt").projectDir = File(rootDir, "services/producthunt")
//project(":designernews").projectDir = File(rootDir, "services/designernews")
//project(":dribbble").projectDir = File(rootDir, "services/dribbble")
//project(":imgur").projectDir = File(rootDir, "services/imgur")
//project(":github").projectDir = File(rootDir, "services/github")
