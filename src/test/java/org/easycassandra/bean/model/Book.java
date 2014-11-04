package org.easycassandra.bean.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.easycassandra.MapData;

/**
 * the Book class.
 * @author otaviojava
 */
@Entity(name = "resumebook")
public class Book {

    @Id
    @Column(name = "booksname")
    private String name;

    @MapData
    private Map<Long, String> chapterResume;

    public Map<Long, String> getChapterResume() {
        return chapterResume;
    }

    public void setChapterResume(Map<Long, String> chapterResume) {
        this.chapterResume = chapterResume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
