package main

import (
	"flag"
	"log"
	"net/http"
	//"os"
	//"path/filepath"
)

var host = flag.String("host", ":8080", "The host of the application.")

func main() {

	// display the upload page
	http.Handle("/upload", &templateHandler{filename: "upload.html"})

	// upload handler
	http.HandleFunc("/uploader", uploaderHandler)

	// start the web server
	log.Println("Starting web server on", *host)
	if err := http.ListenAndServe(*host, nil); err != nil {
		log.Fatal("ListenAndServe:", err)
	}

}
