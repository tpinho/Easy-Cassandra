/*
 * Copyright 2013 Otávio Gonçalves de Santana (otaviojava)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.easycassandra;

/**
 * Exception when happen error with the key of a column family.
 * @author otaviojava
 */
public class KeyProblemsException extends EasyCassandraException {

    /**
     * Constructor to KeyProblemsException.
     * @param message
     *            information to log
     */
    public KeyProblemsException(String message) {
        super(message);

    }

	private static final long serialVersionUID = 1L;
}
