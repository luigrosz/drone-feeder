package com.trybe.dronefeeder.domain;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Video {

  String fileName;

  String downloadUrl;

  public Video(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String fileName) {
    String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    this.downloadUrl = baseUrl + "/video/download/" + fileName;
  }

}
