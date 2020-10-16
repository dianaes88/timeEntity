package ru.javaweb.timeentry.repository;

import ru.javaweb.timeentry.model.TimeEntry;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry save(TimeEntry timeEntry);

    boolean delete(int id);

    TimeEntry get(int id);

    List<TimeEntry> getAllTimeEntriesForUserId(int userId);

    List<TimeEntry> getAll();
}
