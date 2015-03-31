//package io.jeminstalle;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
///**
//* Created by raphael on 31/03/2015.
//*/
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "io.jeminstalle.dao")
//public class ESConfig {
//
//    private final static String HOSTNAME = "192.168.160.227";
//    private final static int PORT = 9300;
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        TransportClient client = new TransportClient();
//        TransportAddress address = new InetSocketTransportAddress(HOSTNAME, PORT);
//        client.addTransportAddress(address);
//        return new ElasticsearchTemplate(client);
//    }
//}
//
