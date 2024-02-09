# -- BUILD --
FROM node:21-alpine as build

WORKDIR /usr/src/app

COPY package* ./
COPY . .

RUN npm install
RUN npm run build

# -- RELEASE --
FROM nginx:1.25-alpine

WORKDIR /usr/share/nginx/html

COPY --from=build /usr/src/app/build/ /usr/share/nginx/html/
COPY --from=build /usr/src/app/env.sh /usr/share/nginx/html/env.sh
COPY --from=build /usr/src/app/.env /usr/share/nginx/html/.env
COPY --from=build /usr/src/app/nginx.conf /etc/nginx/

RUN apk add --no-cache bash

RUN chmod +x env.sh

EXPOSE 80 9001

CMD ["/bin/bash", "-c", "/usr/share/nginx/html/env.sh && nginx -g \"daemon off;\""]
