package org.example.files;

import org.example.files.storage.FileMetadata;
import org.example.files.storage.db.SqlStorage;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.example.files.storage.Storage;
import org.example.files.storage.memory.MapStorage;


@RestController
public class FilesServiceController {
	final private AtomicLong statusCount = new AtomicLong(0);
	final private Storage storage;

	public FilesServiceController() {
		if (FilesApplication.storageType.equals(FilesApplication.MEM_TYPE)) {
			storage = new MapStorage();
		} else {
			storage = new SqlStorage();
		}
	}

	@GetMapping("/status")
	public Status status() {
		return new Status("ok", statusCount.incrementAndGet());
	}

    @GetMapping("/files/{id}")
	public FileDescriptor getFileMetadata(@PathVariable String id) {
		if (id == null || id.isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid id");
		}
		if (!storage.fileExists(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "resource not found");
		}
		FileMetadata f = storage.getFileMetadata(id);
		return new FileDescriptor(f);
	}

	//http://localhost:8080/files?labels=name:kelly,location:portland
	//need minimum name label
	@PostMapping("/files")
	public FileDescriptor uploadFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam("labels") String labels) throws IOException {
		ArrayList<String> labelList = labelsToList(labels);
		String id = UUID.randomUUID().toString();
		storage.store(id, multipartFile.getBytes(), labelList);
		return new FileDescriptor(id, multipartFile.getSize(), labelList);
	}

	//http://localhost:8080/files?labels=name:kelly,location:portland
	@GetMapping("/files")
	public List<FileDescriptor> searchFiles(@RequestParam("labels") String labels) {
		ArrayList<String> labelList = labelsToList(labels);
		ArrayList<FileMetadata> resultFiles = new ArrayList<>();

		List<FileMetadata> firstList = storage.searchFilesByLabel(labelList.get(0));
		resultFiles.addAll(firstList);

		for (int i = 1; i < labelList.size(); i++) {
			resultFiles.retainAll(storage.searchFilesByLabel(labelList.get(i)));
		}

		List<FileDescriptor> result = new ArrayList<>();
		for(FileMetadata f : resultFiles) {
			FileDescriptor fd = new FileDescriptor(f);
			result.add(fd);
		}
		return result;
	}

	public static ArrayList<String> labelsToList(String labels) {
		ArrayList<String> labelsArrlist = new ArrayList<>();
		
		Boolean nameIncluded = false;
		String[] labelsArr = labels.split(","); //["name:kelly", "location:portland"]
		for (int i = 0; i < labelsArr.length; i++) {
			if (!FileMetadata.validLabel(labelsArr[i])) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid label format, must be key:value");
			}
			String[] oneLabel = labelsArr[i].split(":"); //"a:b" => [a,b]
			if (oneLabel[0].equals("name")) {
				nameIncluded = true;
			}
			labelsArrlist.add(labelsArr[i].toLowerCase()); //"name:kelly" added
		}
		if (!nameIncluded) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "must include a name label");
		}
		return labelsArrlist;
	}
}