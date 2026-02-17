package com.xyz.show.service;

import com.xyz.show.model.Show;
import com.xyz.show.repository.ShowRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Cacheable(
        value = "shows",
        key = "#movieId + '-' + #city + '-' + #date + '-' + #page + '-' + #size"
    )
    public Page<Show> getShows(
            Long movieId,
            String city,
            LocalDate date,
            int page,
            int size) {

        return showRepository.findByMovieIdAndCityIgnoreCaseAndShowDate(
                movieId,
                city,
                date,
                PageRequest.of(page, size)
        );
    }
}
