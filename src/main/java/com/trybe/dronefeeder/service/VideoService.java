package com.trybe.dronefeeder.service;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import com.trybe.dronefeeder.domain.Video;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;


@Service
public class VideoService {

  private static final String DIRECTORY = System.getProperty("user.dir")
      + "/src/main/resources/static";


  /**
   * List all videos service.
   */
  public List<Video> findAll() {
    File file = new File(DIRECTORY);
    String[] pathNames = file.list();
    List<Video> videos = new ArrayList<>();
    for (int i = 0; i < pathNames.length; i += 1) {
      Video video = new Video(pathNames[i]);
      video.setDownloadUrl(pathNames[i]);
      videos.add(video);
    }
    return videos;
  }

  /**
   * Video upload service.
   */
  public List<Video> upload(
      List<MultipartFile> multipartFiles) throws IOException {
    List<Video> fileNames = new ArrayList<>();
    for (MultipartFile file : multipartFiles) {
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      Path fileStorage = get(DIRECTORY, fileName).toAbsolutePath();
      copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
      Video video = new Video(fileName);
      video.setDownloadUrl(fileName);
      fileNames.add(video);
    }
    return fileNames;
  }

  /** Video download service. */
  public Map<String, Object> download(
      @PathVariable("filename") String fileName) throws IOException {
    Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(fileName);
    if (!Files.exists(filePath)) {
      throw new FileNotFoundException(fileName + " was not found on the server");
    }
    Resource resource = new UrlResource(filePath.toUri());
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("File-Name", fileName);
    httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-name=" + resource.getFilename());
    Map<String, Object> downloadMap = new HashMap<>();
    downloadMap.put("contentType", MediaType.parseMediaType(Files.probeContentType(filePath)));
    downloadMap.put("httpHeader", httpHeaders);
    downloadMap.put("resource", resource);
    return downloadMap;
  }

}
