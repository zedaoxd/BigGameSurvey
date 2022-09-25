package com.biggamesurvey.biggamesurvey.controllers;

import com.biggamesurvey.biggamesurvey.dtos.RecordDTO;
import com.biggamesurvey.biggamesurvey.dtos.RecordInsertDTO;
import com.biggamesurvey.biggamesurvey.services.RecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAllPaged(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,
            Pageable pageable) {

        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        PageRequest pageRequest;
        if (pageable.getPageSize() == 0)
            pageRequest = PageRequest.of(pageable.getPageNumber(), Integer.MAX_VALUE, pageable.getSort());
        else
            pageRequest = (PageRequest) pageable;

        return ResponseEntity.ok(service.findByMoments(pageRequest, minDate, maxDate));
    }

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO insertDTO) {
        RecordDTO dto = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
