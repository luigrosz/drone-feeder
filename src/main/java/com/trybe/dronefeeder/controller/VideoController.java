package com.trybe.dronefeeder.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trybe.dronefeeder.service.VideoService;

@RestController
@RequestMapping("/video")
public class VideoController {

  @Autowired
  VideoService videoService;

  @PostMapping("/upload")
  public ResponseEntity<List<String>> upload(@RequestParam("files") List<MultipartFile> multipartFiles) throws IOException {
    List<String> fileNames = videoService.upload(multipartFiles);
    return ResponseEntity.ok().body(fileNames);
  }

  @GetMapping("/download/{filename}")
  public ResponseEntity<Resource> download(@PathVariable("filename") String fileName) throws IOException {
    Map<String, Object> responseData = videoService.download(fileName);
    return ResponseEntity.ok().contentType((MediaType) responseData.get("contentType"))
        .headers((HttpHeaders) responseData.get("httpHeader")).body((Resource) responseData.get("resource"));
  }

}
