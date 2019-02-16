FROM nginx:1.15-alpine

RUN apk add --no-cache nginx-mod-http-lua

COPY build/ /usr/share/nginx/html/

COPY nginx_prometheus/nginx.conf /etc/nginx/
COPY nginx_prometheus/prometheus.conf /etc/nginx/conf.d/

RUN mkdir /usr/local/lua
COPY nginx_prometheus/prometheus.lua /usr/local/lua/

EXPOSE 80 9001
