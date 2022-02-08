package demo.controllers;

import demo.models.Task;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class TaskController extends Controller {

    private final FormFactory formFactory;

    @Inject
    public TaskController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public CompletionStage<Result> list(final Http.Request request) {
        final List<Task> tasks = Task.FIND.all();
        return CompletableFuture.supplyAsync(() ->
            ok(demo.views.html.tasks.render(tasks, request))
        );
    }

    public CompletionStage<Result> create(final Http.Request request) {
        DynamicForm form = formFactory.form().bindFromRequest(request);
        final String name = form.get("name");
        if (name.trim().length() == 0) {
            return CompletableFuture.supplyAsync(Results::badRequest);
        }
        final Task task = new Task();
        task.name = name;
        task.save();
        return CompletableFuture.supplyAsync(() -> redirect(routes.TaskController.list()));
    }

}
