## direct exec docker
```shell
docker run --rm -v ./nginx.conf:/etc/nginx/nginx.conf.template -v ./hls:/tmp/hls -p 1935:1935 -p 8080:80 alfg/nginx-rtmp nginx -g "daemon off;"

```