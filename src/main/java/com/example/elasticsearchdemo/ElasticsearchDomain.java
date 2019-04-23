package com.example.elasticsearchdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * @author hanjun
 * @date 2019/2/14
 */
@Document(indexName = "ik_index_test",type = "reply")
public class ElasticsearchDomain {
    @Id
    private String id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;
    @Score
    private float score;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "score:"+score+";content:"+content;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
