package demo.models.finders;

import demo.models.Task;
import io.ebean.Finder;

public class TaskFinder extends Finder<Integer, Task> {

    public TaskFinder() {
        super(Task.class);
    }


}
