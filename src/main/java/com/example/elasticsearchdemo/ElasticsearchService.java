package com.example.elasticsearchdemo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author hanjun
 * @date 2019/2/14
 */
@Repository
public interface ElasticsearchService extends ElasticsearchRepository<ElasticsearchDomain,UUID> {

    /**
     * 根据条件分词搜索
     * @param title
     * @return
     */
    List<ElasticsearchDomain> findByTitle(String title);
}
