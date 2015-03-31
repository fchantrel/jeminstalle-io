package io.jeminstalle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
// On autorise le scan des Component
@ComponentScan
//@ImportResource("spring-data-es.xml")
@Configuration
public class App {
    /**
     * Main function to start my app
     *
     * @param args Arguments given on launch
     * @throws Exception If something bad happens
     */
    public static void main(String[] args) throws Exception {

        // Simply starts my webapp
        SpringApplication.run(App.class, args);

        System.out.println("Hello from Jeminstalle.IO !");
    }
//
//
//    @Bean
//    public EmbeddedServletContainerFactory getEmbeddedServletContainerFactory() {
//        return new TomcatEmbeddedServletContainerFactory();
//    }


//    @Bean
//    public ElasticsearchProperties getElasticsearchProperties() {
//        ElasticsearchProperties ep = new ElasticsearchProperties();
//
//        ep.setClusterName("cluster-dev-fch-1.4.4");
//        ep.setClusterNodes("192.168.160.227:9300");
//
//        return ep;
//    }
}

