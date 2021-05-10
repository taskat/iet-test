/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
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
package org.apache.commons.rdf.rdf4j;

/**
 * Marker interface for RDF4J implementations of Commons RDF
 * {@link org.apache.commons.rdf.api.IRI}.
 * <p>
 * The underlying RDF4J {@link org.eclipse.rdf4j.model.IRI} instance can be
 * retrieved with {@link #asValue()}.
 *
 * @see RDF4J#createIRI(String)
 */
public interface RDF4JIRI extends RDF4JBlankNodeOrIRI, org.apache.commons.rdf.api.IRI {

    @Override
    org.eclipse.rdf4j.model.IRI asValue();

}
