package com.auctionwebsite.controller;

import com.auctionwebsite.dto.AuctionDTO;
import com.auctionwebsite.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequiredArgsConstructor
@RequestMapping("/s3")
public class ImageController {
    private final AuctionService auctionService;

    @PostMapping(
            path = "/upload/{auctionId}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuctionDTO> saveTodo(@PathVariable("auctionId") Integer id,
                                               @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(auctionService.saveImage(id, file), HttpStatus.OK);
    }

    @GetMapping("/download/{auctionId}")
    public ResponseEntity<byte[]> downloadTodoImage(@PathVariable("auctionId") Integer id) {
        return auctionService.getImage(id)
                .map(content -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                        .contentLength(content.length)
                        .body(content))
                .orElseGet(notFound()::build);
    }
}
