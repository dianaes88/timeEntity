package ru.javaweb.timeentry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javaweb.timeentry.model.TimeEntry;
import ru.javaweb.timeentry.repository.TimeEntryRepository;

import java.util.List;

@Service
public class TimeEntryServiceImpl implements TimeEntryService {

    private final TimeEntryRepository repository;

    @Autowired
    public TimeEntryServiceImpl(TimeEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public TimeEntry get(int id) {
        return repository.get(id);
    }

    @Override
    public void delete(List<TimeEntry> entriesToDelete) {
        for(int i = 0; i < entriesToDelete.size(); i++) {
            int id = entriesToDelete.get(i).getEntry_id();
            repository.delete(id);
        }
    }

    @Override
    public List<TimeEntry> getAllTimeEntriesForUserId(int userId) {
        return repository.getAllTimeEntriesForUserId(userId);
    }

    @Override
    public TimeEntry update(TimeEntry timeEntry) {
        return repository.save(timeEntry);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        return repository.save(timeEntry);
    }

    @Override
    public List<TimeEntry> getAll() {
        return repository.getAll();
    }

    @Override
    public void updateStatus(int id, String status) {
        TimeEntry entry = this.get(id);
        entry.setStatus(status);
        repository.save(entry);
    }
}
