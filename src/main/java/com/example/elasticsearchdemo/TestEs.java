package com.example.elasticsearchdemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

/**
 * @author hanjun
 * @date 2019/2/15
 */
@Setter
@Getter
@Setting(settingPath="elasticsearch/settings.json")
@Mapping(mappingPath="elasticsearch/mappings.json")
@Document(indexName = "testes",type = "info")
public class TestEs {
    @Id
    private String id;
    private String title;
    private String content;
}
