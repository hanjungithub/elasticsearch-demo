package com.example.elasticsearchdemo;

import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchDemoApplicationTests {

    @Autowired
    private ElasticsearchService elasticsearchService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private TestEsRepository testEsRepository;
    @Test
    public void contextLoads() {
    }

    @Test
    public void add(){
        ElasticsearchDomain elasticsearchDomain = new ElasticsearchDomain();
        elasticsearchDomain.setTitle("我是波波，我是渣渣");
        elasticsearchDomain.setContent("我是渣渣波波，被你发现了");
        elasticsearchService.save(elasticsearchDomain);
    }
    @Test
    public void search(){
        /*// 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "渣渣"));
        Page<ElasticsearchDomain> searchs = elasticsearchService.search(queryBuilder.build());*/
        List<ElasticsearchDomain> searchs = elasticsearchService.findByTitle("水军。");
        System.out.println("一共"+searchs.size()+"条");
        for (ElasticsearchDomain item : searchs) {
            System.out.println(item);
        }
    }

    @Test
    public void search1(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "渣渣"));
        List<ElasticsearchDomain> elasticsearchDomains = elasticsearchTemplate.queryForList(queryBuilder.build(), ElasticsearchDomain.class);
        System.out.println("一共"+elasticsearchDomains.size()+"条");
        for (ElasticsearchDomain item : elasticsearchDomains) {
            System.out.println(item);
        }
    }

    @Test
    public void testAutoCreateIndex(){
        TestEs testEs = new TestEs();
        testEs.setTitle("我是波波，我是渣渣");
        testEs.setContent("我是渣渣波波，被你发现了");
        testEsRepository.save(testEs);
    }

    @Test
    public void testSearch(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "zha炸"));
        Page<TestEs> searchs = testEsRepository.search(queryBuilder.build());
        System.out.println("一共"+searchs.getTotalElements()+"条");
        for (TestEs item : searchs) {
            System.out.println(item.getContent());
        }
    }


}

