package demo.models;

import demo.models.finders.TaskFinder;
import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table
public class Task extends Model {

    @Id
    public int id;

    public Date due;

    @Column(nullable = false)
    public String name;

    public String description;

    @Column(insertable = false, updatable = false)
    public Timestamp createdAt;

    @Column(insertable = false, updatable = false)
    public Timestamp updatedAt;

    public final static TaskFinder FIND = new TaskFinder();

}
