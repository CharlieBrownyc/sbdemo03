### ElasticSearch Run
docker
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

(web)
http://localhost:5601

  # (need) check kibana setting
docker exec -i -t kibana cat /usr/share/kibana/config/kibana.yml

  # (need) check kibana api status
curl localhost:5601/api/status
```
* Elasticsearch CRUD Test
    ```shell
    (Create)
    PUT /items
    {
      "settings": {
        "number_of_shards": 1
      },
      "mappings": {
        "properties": {
          "itemId": { "type": "keyword" },
          "price": { "type": "integer" }
        }
      }
    }
    
    (Update)
    POST /items/_doc/1
    {
      "itemId": "Item1",
      "price": 1000
    }
    
    (Read)
    GET /items/_search
    {
      "query": {
        "match": {
          "itemId":  "Item1"
        }
      }
    }
    
    (Read List/All)
    GET /items/_search
    {
      "query": {
        "match_all": {}
      }
    }
  
    (Delete)
    DELETE /items/_doc/1
    ```
* docker-compose   
  ```yaml
  docker compose -f ./es-single-node.yml up
  # build image
  docker compose build <service>
  # docker compose up <service>
  docker compose up --build
  # remove services(container, network, volume
  docker compose down <service>
  # stop services
  docker compose stop <service>
  # start services(stop->start)
  docker compose start <service>
  # restart
  docker compose restart <service>
  # chage active image
  docker compose build <service>
  docker compose restart <service>
  # list container
  docker compose ps
  # log
  docker compose logs <service>
  # command to container
  # get container_id -> docker ps
  # -i (interactive ) / -t (transfer to terminal)
  docker exec <container_id/name> <command>
  # view configuration or env variable ex) $PATH
  docker exec config <service>
  ```

* reference
  * [SpringBoot+ES](https://blog.naver.com/wideeyed/223341372809)
  * [ES+Docker Compose](https://yeon-dev.tistory.com/253)
  * 