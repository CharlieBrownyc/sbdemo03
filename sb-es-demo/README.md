# ElasticSearch SpringBoot Example
## Getting Started

### ElasticSearch Run
docker-compose
```yaml
# pull elasticsearch
docker pull elasticsearch:7.17.28

# make virtual network
docker network create es_network

# run container (ELASTIC_PASSWORD 환경변수에 비밀번호 입력)
docker run -d --name elasticsearch --net es_network -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e "ELASTIC_PASSWORD=changeme!!!" elasticsearch:7.17.28

(test)
curl localhost:9200
(container shell)
docker exec -it elasticsearch /bin/bash
```
kibana
```yaml
# pull kibana
docker pull docker.elastic.co/kibana/kibana:7.17.28

# run
docker run -d --name kibana --net es_network -p 5601:5601 -e "ELASTICSEARCH_USERNAME=elastic", -e "ELASTICSEARCH_PASSWORD=changeme!!!" docker.elastic.co/kibana/kibana:7.17.28

```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.3/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.3/gradle-plugin/packaging-oci-image.html)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/3.5.3/reference/data/nosql.html#data.nosql.elasticsearch)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

