package com.xyz.show.controller;

import com.xyz.show.model.Show;
import com.xyz.show.service.ShowService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public Page<Show> browseShows(
            @RequestParam Long movieId,
            @RequestParam String city,
            @RequestParam String date,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return showService.getShows(
                movieId,
                city,
                LocalDate.parse(date),
                page,
                size
        );
    }
}
