package ru.javaweb.timeentry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javaweb.timeentry.model.TimeEntry;

import java.util.List;
@Transactional(readOnly = true)
public interface CrudTimeEntryRepository extends JpaRepository<TimeEntry, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM TimeEntry t WHERE t.entry_id=:id")
    int delete(@Param("id") int id);

    @Override
    TimeEntry save(TimeEntry item);

    @Query("SELECT t FROM TimeEntry t WHERE t.user_id=:id")
    List<TimeEntry> getAllTimeEntriesForUserId(@Param("id") int id);

    @Query("SELECT t FROM TimeEntry t")
    List<TimeEntry> getAll();
}
