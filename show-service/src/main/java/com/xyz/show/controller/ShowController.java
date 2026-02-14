package com.xyz.show.controller;

import com.xyz.show.model.Show;
import com.xyz.show.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> browseShows(
            @RequestParam Long movieId,
            @RequestParam String city,
            @RequestParam String date) {

        return showService.getShows(
                movieId,
                city,
                LocalDate.parse(date)
        );
    }
}
