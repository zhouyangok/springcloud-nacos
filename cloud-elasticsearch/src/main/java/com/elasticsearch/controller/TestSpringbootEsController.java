package com.elasticsearch.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elasticsearch.service.BaseElasticService;
import com.elasticsearch.vo.IdxVo;
import com.elasticsearch.vo.User;
import com.springcloud.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.cert.ocsp.Req;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName TestSpringbootEsController
 * @Description: 测试es
 * @Author zhouyang
 * @Date 2020/7/12 下午5:11.
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestSpringbootEsController {


    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private BaseElasticService baseElasticService;

    @GetMapping("/creatIndex")
    public CommonResult creatIndex(String idxName) {
        CommonResult response = new CommonResult();
        try {
            CreateIndexRequest request = new CreateIndexRequest(idxName);
            CreateIndexResponse response1 = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            System.out.println(response1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping("/indexExist")
    public boolean indexExist(String idxName) throws Exception {
        GetIndexRequest request = new GetIndexRequest(idxName);
//        request.local(false);
//        request.humanReadable(true);
//        request.includeDefaults(false);
//        request.indicesOptions(IndicesOptions.lenientExpandOpen());
        return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    }

    @GetMapping("/delete")
    public boolean delete(String idxName) throws Exception {
        DeleteIndexRequest request = new DeleteIndexRequest(idxName);
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        return acknowledgedResponse.isAcknowledged();

    }



}

