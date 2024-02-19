package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/prometheus/client_golang/prometheus"
	"github.com/prometheus/client_golang/prometheus/promauto"
	"github.com/prometheus/client_golang/prometheus/promhttp"
)

var (
	opsProcessed = promauto.NewCounter(prometheus.CounterOpts{
		Name: "hello_go_counter_total",
		Help: "Total number of requests processed by Backend",
	})
)

func hello(w http.ResponseWriter, r *http.Request) {
	opsProcessed.Inc()

	name := r.URL.Query().Get("name")
	if name == "" {
		fmt.Fprintf(w, "Hello, World!")
	} else {
		fmt.Fprintf(w, "Hello, %s!", name)
	}
}

func main() {
	fmt.Println("Server listening on port 9002")

	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Hello Backend")
	})

	http.Handle("/metrics", promhttp.Handler())

	http.HandleFunc("/hello", hello)

	if err := http.ListenAndServe(":9002", nil); err != nil {
		log.Fatal(err)
	}
}
