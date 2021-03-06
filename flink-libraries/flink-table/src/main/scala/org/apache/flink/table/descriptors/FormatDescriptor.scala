/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.descriptors

import org.apache.flink.table.descriptors.FormatDescriptorValidator.{FORMAT_TYPE, FORMAT_PROPERTY_VERSION}

/**
  * Describes the format of data.
  *
  * @param tpe string identifier for the format
  */
abstract class FormatDescriptor(
    private val tpe: String,
    private val version: Int)
  extends Descriptor {

  override def toString: String = this.getClass.getSimpleName

  /**
    * Internal method for properties conversion.
    */
  final private[flink] def addProperties(properties: DescriptorProperties): Unit = {
    properties.putString(FORMAT_TYPE, tpe)
    properties.putInt(FORMAT_PROPERTY_VERSION, version)
    addFormatProperties(properties)
  }

  /**
    * Internal method for format properties conversion.
    */
  protected def addFormatProperties(properties: DescriptorProperties): Unit

}
