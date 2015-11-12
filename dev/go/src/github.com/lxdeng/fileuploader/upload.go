package main

import (
	"io"
	"io/ioutil"
	"net/http"
	"path"
)

func uploaderHandler(w http.ResponseWriter, req *http.Request) {

	filename := req.FormValue("filename")

	file, header, err := req.FormFile("fileToUpload")
	if err != nil {
		io.WriteString(w, err.Error())
		return
	}

	data, err := ioutil.ReadAll(file)
	if err != nil {
		io.WriteString(w, err.Error())
		return
	}

	fullname := path.Join("/tmp/", filename)
	err = ioutil.WriteFile(fullname, data, 0770)
	if err != nil {
		io.WriteString(w, err.Error())
		return
	}

	io.WriteString(w, header.Filename)
	io.WriteString(w, " uploaded as "+fullname)
	io.WriteString(w, " Successful")
}
