package com.elasticsearch.service;

import com.alibaba.fastjson.JSON;
import com.elasticsearch.vo.User;
import com.springcloud.result.CommonResult;
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
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @ClassName EsService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/7/15 下午6:18.
 */
@Service
public class EsService {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    private final String indexName = "zy";

    //添加文档
    public CommonResult save(User user) throws IOException {

        //创建请求
        IndexRequest indexRequest = new IndexRequest(indexName);
        //规则 put /index/doc/1
        indexRequest.id("1");
        indexRequest.timeout(TimeValue.timeValueSeconds(1));
        //数据放入请求 封装json
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        //客户端发送请求
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status()); //对应命令返回的状态
        return CommonResult.success(indexResponse.status());
    }

    //判断文档是否存在 get /index/doc/id
    @GetMapping("/exist")
    public boolean exist(String docName, String docId) throws IOException {
        GetRequest request = new GetRequest(docName, docId);
        boolean exist = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        return exist;
    }

    //获取文档信息
    @GetMapping("/get")
    public void get(String docName, String docId) throws IOException {
        GetRequest request = new GetRequest(docName, docId);
        GetResponse getResponse = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString()); //打印文档的内容
        System.out.println(getResponse); //返回的全部内容

    }

    //更新文档
    @GetMapping("/update")
    public void update() throws IOException {
        UpdateRequest request = new UpdateRequest("user", "1");
        request.timeout("1s");
        User user = new User("ss", 12);
        request.doc(JSON.toJSONString(user), XContentType.JSON);
        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response.status());

    }

    //删除文档
    @GetMapping("deleteDoc")
    public void deleteDoc() throws IOException {
        DeleteRequest request = new DeleteRequest("user", "1");
        request.timeout("1s");
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    @GetMapping("/saveBatch")
    public void saveBatch() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        ArrayList<User> arrayList = new ArrayList();
        User user = new User("se", 12);
        User user1 = new User("se1", 12);
        User user2 = new User("se2", 12);
        User user3 = new User("se3", 12);
        User user4 = new User("se4", 12);
        User user5 = new User("se5", 12);
        User user6 = new User("se6", 12);
        arrayList.add(user);
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        arrayList.add(user4);
        arrayList.add(user5);
        arrayList.add(user6);

        for (int i = 0; i < arrayList.size(); i++) {
            bulkRequest.add(new IndexRequest("user")
                    .id("" + (i + 1))
                    .source(JSON.toJSONString(arrayList.get(i)), XContentType.JSON));
        }
        BulkResponse responses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(responses.hasFailures());//是否失败

    }

    //搜索请求
    //条件构造
    @GetMapping("/search")
    public void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest("user");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //精确匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "se");
        searchSourceBuilder.query(termQueryBuilder);
        //分页
        searchSourceBuilder.from(1);
        searchSourceBuilder.size(10);
        searchSourceBuilder.timeout(TimeValue.timeValueSeconds(30));
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(search.getHits()));
        for (SearchHit hit : search.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }
}
