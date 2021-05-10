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
package org.apache.commons.rdf.api;

import java.util.Objects;

/**
 * An <a href= "http://www.w3.org/TR/rdf11-concepts/#dfn-rdf-triple" >RDF-1.1
 * Triple</a>, as defined by
 * <a href= "http://www.w3.org/TR/rdf11-concepts/#section-triples" >RDF-1.1 Concepts and
 * Abstract Syntax</a>, a W3C Recommendation published on 25 February 2014.
 * <p>
 * A <code>Triple</code> object in Commons RDF is considered
 * <strong>immutable</strong>, that is, over its life time it will have
 * consistent behavior for its {@link #equals(Object)}, and the {@link RDFTerm}
 * instances returned from {@link #getSubject()}, {@link #getPredicate()} and
 * {@link #getObject()} will have consistent {@link RDFTerm#equals(Object)}
 * behavior.
 * <p>
 * Note that <code>Triple</code> methods are not required to return object
 * identical (<code>==</code>) instances as long as they are equivalent
 * according to {@link RDFTerm#equals(Object)}. Specialisations of
 * <code>Triple</code> may provide additional methods that are documented to be
 * mutable.
 * <p>
 * <code>Triple</code> methods are <strong>thread-safe</strong>, however
 * specialisations may provide additional methods that are documented to not be
 * thread-safe.
 * <p>
 * <code>Triple</code>s can be safely used in hashing collections like
 * {@link java.util.HashSet} and {@link java.util.HashMap}.
 * <p>
 * Any <code>Triple</code> can be used interchangeably across Commons RDF
 * implementations.
 *
 * @see Quad
 * @see RDF#createTriple(BlankNodeOrIRI,IRI,RDFTerm)
 * @see <a href= "http://www.w3.org/TR/rdf11-concepts/#dfn-rdf-triple" >RDF-1.1
 *      Triple</a>
 */
public interface Triple extends TripleLike {

    /**
     * The subject of this triple, which may be either a {@link BlankNode} or an
     * {@link IRI}, which are represented in Commons RDF by the interface
     * {@link BlankNodeOrIRI}.
     *
     * @return The subject {@link BlankNodeOrIRI} of this triple.
     * @see <a href="http://www.w3.org/TR/rdf11-concepts/#dfn-subject">RDF-1.1
     *      Triple subject</a>
     */
    @Override
    BlankNodeOrIRI getSubject();

    /**
     * The predicate {@link IRI} of this triple.
     *
     * @return The predicate {@link IRI} of this triple.
     * @see <a href="http://www.w3.org/TR/rdf11-concepts/#dfn-predicate">RDF-1.1
     *      Triple predicate</a>
     */
    @Override
    IRI getPredicate();

    /**
     * The object of this triple, which may be either a {@link BlankNode}, an
     * {@link IRI}, or a {@link Literal}, which are represented in Commons RDF
     * by the interface {@link RDFTerm}.
     *
     * @return The object {@link RDFTerm} of this triple.
     * @see <a href="http://www.w3.org/TR/rdf11-concepts/#dfn-object">RDF-1.1
     *      Triple object</a>
     */
    @Override
    RDFTerm getObject();

    /**
     * Check it this Triple is equal to another Triple.
     * <p>
     * Two Triples are equal if and only if their {@link #getSubject()},
     * {@link #getPredicate()} and {@link #getObject()} are equal.
     * </p>
     * <p>
     * Implementations MUST also override {@link #hashCode()} so that two equal
     * Triples produce the same hash code.
     * </p>
     *
     * @param other
     *            Another object
     * @return true if other is a Triple and is equal to this
     * @see Object#equals(Object)
     */
    @Override
    boolean equals(Object other);

    /**
     * Calculate a hash code for this Triple.
     * <p>
     * The returned hash code MUST be equal to the result of
     * {@link Objects#hash(Object...)} with the arguments {@link #getSubject()},
     * {@link #getPredicate()}, {@link #getObject()}.
     * <p>
     * This method MUST be implemented in conjunction with
     * {@link #equals(Object)} so that two equal {@link Triple}s produce the
     * same hash code.
     *
     * @return a hash code value for this Triple.
     * @see Object#hashCode()
     * @see Objects#hash(Object...)
     */
    @Override
    int hashCode();

}
