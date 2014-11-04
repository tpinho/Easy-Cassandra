package org.easycassandra.persistence.cassandra.spring.repository;

import java.util.Date;
import java.util.List;

import org.easycassandra.bean.model.IdLifestyle;
import org.easycassandra.bean.model.Lifestyle;
import org.easycassandra.bean.model.Step;
import org.easycassandra.persistence.cassandra.spring.CassandraRepository;
import org.easycassandra.persistence.cassandra.spring.CassandraTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * repository to Lifestyle.
 */
@Repository("stepRepository")
public class StepRepository extends CassandraRepository<Lifestyle, IdLifestyle> {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @Override
    public CassandraTemplate getCassandraTemplate() {
        return cassandraTemplate;
    }

    /**
     * find by key and index.
     * @param key the key
     * @param date the date
     * @return the entities by keys
     */
    public List<Step> findByKeyAndIndex(final IdLifestyle key, final Date date) {
        return cassandraTemplate.findByKeyAndIndex(key, date, Step.class);
    }
}
