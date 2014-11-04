/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.easycassandra.persistence.cassandra.spring;

import java.util.LinkedList;
import java.util.List;

import org.easycassandra.ClassInformation;
import org.easycassandra.ClassInformations;
import org.easycassandra.ClassInformation.KeySpaceInformation;
import org.easycassandra.persistence.cassandra.ClusterInformation;

import com.datastax.driver.core.Session;

/**
 * Class for manage Connections.
 * @author otaviojava
 * @version 2.0
 */
public class CassandraFactoryDynamically extends AbstractCassandraFactory {

    /**
     * Constructor to Factory.
     * @param clusterInformation {@link ClusterInformation}
     */
    public CassandraFactoryDynamically(ClusterInformation clusterInformation) {
		super(clusterInformation);
	}

	/**
     * list of classes added by Cassandra.
     */
    private List<Class<?>> classes = new LinkedList<Class<?>>();

    /**
     * add class on factory.
     * @param class1 the class
     * @param keySpace the keyspace
     * @return if the process was sucess
     */
    public boolean addFamilyObject(Class<?> class1, String keySpace) {
        if (classes.contains(class1)) {
            return true;
        }
        ClassInformation classInformation = ClassInformations.INSTACE.getClass(class1);
        String familyColumn = classInformation.getNameSchema();
        if (!classInformation.getSchema().equals("")) {
            getTemplate(classInformation.getSchema());

        }
        KeySpaceInformation key = classInformation.getKeySpace(getKeySpace());
        Session session = getCluster().connect(key.getKeySpace());
        classes.add(class1);
        return fixColumnFamily(session, familyColumn, class1);
    }


}
