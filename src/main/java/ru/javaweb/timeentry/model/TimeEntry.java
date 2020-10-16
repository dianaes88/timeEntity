package ru.javaweb.timeentry.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Access(AccessType.FIELD)
@Table(name = "TIME_ENTRIES")
public class TimeEntry {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Column(name = "entryID")
    protected Integer entry_id;

    @Column(name = "sourceID", nullable = false)
    private Integer source_id;

    @Column(name = "userID", nullable = false)
    private Integer user_id;

    @Column(name = "date", nullable = false)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date date;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "tag")
    private String tag;

    @Column(name = "status")
    private String status;

    public TimeEntry() {
    }

    public TimeEntry(Integer source_id, Integer user_id, Date date, Integer hours, String tag, String status) {
        this(null, source_id, user_id, date, hours, tag, status);
    }

    public TimeEntry(Integer entry_id, Integer source_id, Integer user_id, Date date, Integer hours, String tag, String status) {
        this.entry_id = entry_id;
        this.source_id = source_id;
        this.user_id = user_id;
        this.date = date;
        this.hours = hours;
        this.tag = tag;
        this.status = status;
    }

    public Integer getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Integer entry_id) {
        this.entry_id = entry_id;
    }

    public Integer getSource_id() {
        return source_id;
    }

    public void setSource_id(Integer source_id) {
        this.source_id = source_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "entry_id=" + entry_id +
                ", source_id=" + source_id +
                ", user_id=" + user_id +
                ", date=" + date +
                ", hours=" + hours +
                ", tag='" + tag + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
