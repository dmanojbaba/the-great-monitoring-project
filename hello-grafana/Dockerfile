FROM grafana/grafana:10.2.4

USER grafana

ENV GF_AUTH_ANONYMOUS_ENABLED=true

RUN mkdir -p /var/lib/grafana/dashboards

COPY provisioning/datasources.yaml /etc/grafana/provisioning/datasources/datasources.yaml
COPY provisioning/dashboards.yaml /etc/grafana/provisioning/dashboards/dashboards.yaml

COPY dashboards/*.json /var/lib/grafana/dashboards/
