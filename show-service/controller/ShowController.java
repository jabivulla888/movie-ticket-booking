@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<ShowResponse> getShows(
            @RequestParam Long movieId,
            @RequestParam String city,
            @RequestParam LocalDate date) {
        return showService.getShows(movieId, city, date);
    }
}
