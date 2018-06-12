package org.meetup.notifier.rest;

import org.meetup.notifier.data.mongo.dto.KeywordDTO;
import org.meetup.notifier.data.mongo.service.KeywordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Batuhan Apaydın
 */

@RestController
@RequestMapping(value = "keywords")
public class KeywordController {

    private final KeywordService keywordService;

    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }


    @GetMapping
    public List<KeywordDTO> getUserKeywords() {
        return keywordService.getUserKeywords();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long save(@RequestBody @Valid KeywordDTO keywordDTO) {
        return keywordService.save(keywordDTO);
    }
}
