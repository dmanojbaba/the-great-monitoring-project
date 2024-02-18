package main

import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/hello", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Hello Backend")
	})
	fmt.Printf("Server running (port=9002), route: http://localhost:9002/hello\n")
	if err := http.ListenAndServe(":9002", nil); err != nil {
		log.Fatal(err)
	}
}
