package com.amt.mygarden.controllers;

import com.amazonaws.AmazonServiceException;
import com.amt.mygarden.service.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class ImageController {
    @Autowired
    FileStore fileStore;

    @GetMapping(path = "/download/{filename}")
    public ResponseEntity<Object> findByName(@PathVariable String filename, HttpServletRequest request) throws IOException {
        InputStreamResource is;
        try {
            is = fileStore.download(filename);
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 404) {
                is = new InputStreamResource(request.getServletContext().getResourceAsStream("/images/placeholder.jpg"));
            } else {
                throw new IllegalStateException("Failed to download the file", e);
            }
        }
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.noCache())
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + filename + "\"")
                .body(is);

    }
}
