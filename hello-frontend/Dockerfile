# -- BUILD --
FROM node:21-alpine as build

WORKDIR /usr/src/app

COPY package* ./
COPY . .

RUN npm install
RUN npm run build

# -- RELEASE --
FROM alpine:3.19

RUN apk update
RUN apk add --no-cache nginx-mod-http-lua
RUN apk add --no-cache bash
RUN apk upgrade

RUN mkdir -p /var/run/nginx && \
    chown -R nginx:nginx /var/run/nginx && \
    chmod g+s /var/run/nginx

RUN mkdir -p /var/cache/nginx && \
    chown -R nginx:nginx /var/cache/nginx && \
    chmod g+s /var/cache/nginx

RUN mkdir /usr/local/lua && \
    chown nginx:nginx /usr/local/lua

COPY --from=build /usr/src/app/build/ /usr/share/nginx/html/
COPY .env /usr/share/nginx/html/.env
COPY env.sh /usr/share/nginx/html/env.sh
COPY nginx/nginx.conf /etc/nginx/
COPY nginx/prometheus.conf /etc/nginx/conf.d/
COPY nginx/prometheus*.lua /usr/local/lua/

RUN chown -R nginx:nginx /usr/share/nginx/html/ && \
    chmod +x /usr/share/nginx/html/env.sh

RUN ln -sf /dev/stdout /var/lib/nginx/logs/access.log
RUN ln -sf /dev/stderr /var/lib/nginx/logs/error.log

STOPSIGNAL SIGQUIT

WORKDIR /usr/share/nginx/html
USER nginx

CMD ["/bin/bash", "-c", "/usr/share/nginx/html/env.sh && nginx -g \"daemon off;\""]
