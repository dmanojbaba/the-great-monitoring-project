### Install Ingress Nginx in Docker Desktop

https://kubernetes.github.io/ingress-nginx/deploy/#quick-start

```
helm upgrade --install ingress-nginx ingress-nginx \
  --repo https://kubernetes.github.io/ingress-nginx \
  --namespace ingress-nginx --create-namespace
```

## Rancher Desktop

https://docs.rancherdesktop.io/how-to-guides/traefik-ingress-example/
