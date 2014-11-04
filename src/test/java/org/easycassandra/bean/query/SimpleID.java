package org.easycassandra.bean.query;

import javax.persistence.Column;
/**
 * id.
 * @author otaviojava
 */
public class SimpleID {

    @Column(name = "indexbuilder")
    private Integer index;

    @Column(name = "idbuilder")
    private Integer key;


    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
