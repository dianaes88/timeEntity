package ru.javaweb.timeentry.service;

import ru.javaweb.timeentry.model.TimeEntry;

import java.util.List;

public interface TimeEntryService {
    TimeEntry get(int id);

    void delete(List<TimeEntry> entriesToDelete);

    List<TimeEntry> getAllTimeEntriesForUserId(int userId);

    TimeEntry update(TimeEntry timeEntry);

    TimeEntry create(TimeEntry timeEntry);

    List<TimeEntry> getAll();

    void updateStatus(int id, String status);
}
