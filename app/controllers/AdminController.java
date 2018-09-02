package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Admin;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import repository.AdminModule;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class AdminController extends Controller {
    private final HttpExecutionContext executionContext;
    private final AdminModule adminModule;

    @Inject
    public AdminController(HttpExecutionContext executionContext, AdminModule adminModule) {
        this.executionContext = executionContext;
        this.adminModule = adminModule;
    }

    public CompletionStage<Result> saveAdmin() {
        JsonNode jsonNode = request().body().asJson();
        Admin admin = Json.fromJson(jsonNode, Admin.class);
        return adminModule.insert(admin).thenApplyAsync(data -> {
            return status(201, data);
        }, executionContext.current());
    }

}
