package com.example.elasticsearchdemo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author hanjun
 * @date 2019/2/15
 */
@Repository
public interface TestEsRepository extends ElasticsearchRepository<TestEs,UUID> {
}
