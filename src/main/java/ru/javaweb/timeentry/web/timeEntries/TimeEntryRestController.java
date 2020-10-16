package ru.javaweb.timeentry.web.timeEntries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javaweb.timeentry.model.TimeEntry;
import ru.javaweb.timeentry.service.TimeEntryService;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping(value = TimeEntryRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class TimeEntryRestController {
    static final String REST_URL = "/time_entry";

    @Autowired
    private TimeEntryService service;

    //Get time entry with specified in url entry_id
    @GetMapping("/{id}")
    public TimeEntry get(@PathVariable("id") int id) {
            return service.get(id);
    }

    //Create a new time_entry
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeEntry> saveTimeEntry(@RequestBody TimeEntry entry) {
        TimeEntry created = service.create(entry);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getEntry_id()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    //Delete time_entry provided in the request body
    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody List <TimeEntry> entriesToDelete) {
        service.delete(entriesToDelete);
    }

    //Get all time_entries from the data base
    @GetMapping("/all")
    public List<TimeEntry> getAll() {
        return service.getAll();
    }

    //Get time entries associated with the requested user_id
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TimeEntry> getAllTimeEntriesForUserId(@ModelAttribute("userID") int userId) {
            return service.getAllTimeEntriesForUserId(userId);
    }

    //Update status value of the time entry with specified in url id
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") int id,
                       @ModelAttribute("status") String status) {
        service.updateStatus(id, status);
    }
}
