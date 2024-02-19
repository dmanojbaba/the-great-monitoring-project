package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/prometheus/client_golang/prometheus/promhttp"
)

func main() {
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Hello Backend")
	})

	http.Handle("/prometheus", promhttp.Handler())

	http.HandleFunc("/hello", func(w http.ResponseWriter, r *http.Request) {
		name := r.URL.Query().Get("name")
		if name == "" {
			fmt.Fprintf(w, "Hello, World!")
		} else {
			fmt.Fprintf(w, "Hello, %s!", name)
		}
	})

	fmt.Println("Server listening on port 9002")
	if err := http.ListenAndServe(":9002", nil); err != nil {
		log.Fatal(err)
	}
}
