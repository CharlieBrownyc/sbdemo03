# ElasticSearch SpringBoot Example
## Getting Started

### Pre-requisite
[Elasticsearch + Kibana](./Elasticsearch.md)

### demo Test
```shell
# 데이터가 없을 때 조회
curl.exe -X GET "http://localhost:8080/items/Item1"
==> 빈값, HTTP_STATUS: 200

# 생성 테스트
curl.exe -X POST "http://localhost:8080/items/add" -H "Content-Type: application/json" -d "{\"itemId\":\"Item1\", \"price\":1000}"
==> {"id":"Scykao0BVUDCbzWyyLnj","itemId":"Item1","price":1000}

# 데이터가 있을 때 조회
curl.exe -X GET "http://localhost:8080/items/Item1"
==> {"id":"Scykao0BVUDCbzWyyLnj","itemId":"Item1","price":1000}

# 수정 테스트
curl.exe -X POST "http://localhost:8080/items/update/Item1" -H "Content-Type: application/json" -d "{\"price\":1200}"
==> {"id":"Scykao0BVUDCbzWyyLnj","itemId":"Item1","price":1200}

# 수정된 데이터 조회
curl.exe -X GET "http://localhost:8080/items/Item1"
==> {"id":"Scykao0BVUDCbzWyyLnj","itemId":"Item1","price":1200}

# 삭제 테스트 
curl.exe -X POST "http://localhost:8080/items/delete/Item1"
==> 빈값, HTTP_STATUS: 200

# 삭제된 데이터 조회
curl.exe -X GET "http://localhost:8080/items/Item1"
==> 빈값, HTTP_STATUS: 200
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

