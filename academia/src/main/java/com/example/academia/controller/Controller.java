package com.example.academia.controller;

import com.example.academia.JSON.Emp_Course;
import com.example.academia.JSON.Id;
import com.example.academia.bean.Courses;
import com.example.academia.bean.Employees;
import com.example.academia.service.CourseService;
import com.example.academia.service.EmployeeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("academia")
public class Controller {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginFunc(Employees emp) throws URISyntaxException {
        Employees e = new EmployeeService().login(emp);
        if (e == null)
            return Response.status(203).build();
        else if (e.getPassword().equals(emp.getPassword()))
            return Response.ok().entity(e).build();
        else
            return Response.status(203).build();
    }

    EmployeeService service2 = new EmployeeService();

    @POST
    @Path("/enroll")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerEmp(Emp_Course reg) throws URISyntaxException {
        boolean val = new EmployeeService().registerEmployee(reg.getEmployee_id(),reg.getCourse_id());
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }


    @POST
    @Path("/{emp_id}/fetch")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response fetchFunc(@PathParam("emp_id") Integer id) throws URISyntaxException {
        Employees e = new EmployeeService().getEmployeeDetailsById(id);
        if(e!=null)
            return Response.ok().entity(e).build();
        else
            return Response.status(203).build();
    }


    CourseService courseService = new CourseService();

    @GET
    @Path("/get")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getCourses() {
            List<Courses> courses = courseService.getCourses();
            return Response.ok().entity(courses).build();
        }
/*
    @POST
    @Path("/image")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        public Response imageUpload(@FormDataParam("file") InputStream fileInputStream,
                                    @FormDataParam("file") FormDataContentDisposition fileMetaData) throws URISyntaxException{
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename = "+fileMetaData.getFileName())
                .build();
    }

 */
}