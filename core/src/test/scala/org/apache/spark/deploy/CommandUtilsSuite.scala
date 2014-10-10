/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.deploy

import org.scalatest.FunSuite
import org.apache.spark.deploy.worker.CommandUtils
import org.apache.spark.util.Utils
import org.scalatest.Matchers

class CommandUtilsSuite extends FunSuite with Matchers {

  test("set libraryPath correctly") {
    val cmd = new Command("mainClass", Seq(), Map(), Seq(), Seq("libraryPathToB"), Seq())
    val libraryPath = Utils.libraryPath
    val env = CommandUtils.buildEnvironment(cmd)
    env.keySet should contain(libraryPath)
    assert(env(libraryPath).startsWith("libraryPathToB"))
  }
}
