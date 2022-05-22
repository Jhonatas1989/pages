package com.oliveira.pages.resource;

import com.oliveira.pages.config.SwaggerConfig;
import com.oliveira.pages.model.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Validated
@Api(tags = {SwaggerConfig.PAGE_TAG})
public interface PageResource {

    @ApiOperation(value = "View a list of available pages", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 204, message = "Page not found"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    List<Page> findAll();

    @ApiOperation(value = "Search a page with an ID", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved page"),
            @ApiResponse(code = 204, message = "Page not found"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    Page findById(@PathVariable("id") String id);

    @ApiOperation(value = "Add a page", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully saved page"),
            @ApiResponse(code = 401, message = "You are not authorized to saved the resource")
    })
    List<Page> save(@RequestBody List<@Valid Page> pages);

    @ApiOperation(value = "Update a page", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated page"),
            @ApiResponse(code = 204, message = "Page not found"),
            @ApiResponse(code = 401, message = "You are not authorized to update the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to update is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to save is not found")
    })
    List<Page> update(@RequestBody List<@Valid Page> pagers);

    @ApiOperation(value = "Delete a page")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted page"),
            @ApiResponse(code = 204, message = "Page not found"),
            @ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to delete is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found")
    })
    ResponseEntity delete(@PathVariable("id") String id);

}
