package ru.javaweb.timeentry.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import ru.javaweb.timeentry.model.TimeEntry;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class DataJpaTimeEntryRepositoryImpl implements TimeEntryRepository {
    @Autowired
    CrudTimeEntryRepository crudTimeEntryRepository;

    @Override
    @Transactional
    public TimeEntry save(TimeEntry timeEntry) {
        return crudTimeEntryRepository.save(timeEntry);
    }

    @Modifying
    @Transactional
    @Override
    public boolean delete(int id) {
        return crudTimeEntryRepository.delete(id) != 0;
    }

    @Override
    public TimeEntry get(int id) {
        return crudTimeEntryRepository.findById(id).orElse(null);
    }

    @Override
    public List<TimeEntry> getAllTimeEntriesForUserId(int userId) {
        return crudTimeEntryRepository.getAllTimeEntriesForUserId(userId);
    }

    @Override
    public List<TimeEntry> getAll() {
        return crudTimeEntryRepository.findAll();
    }
}
