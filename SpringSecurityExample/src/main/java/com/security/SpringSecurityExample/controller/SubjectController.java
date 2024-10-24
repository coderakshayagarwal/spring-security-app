package com.security.SpringSecurityExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.SpringSecurityExample.model.Subject;

import java.util.List;
import java.util.ArrayList;

@RestController
public class SubjectController {

    private List<Subject> subjectList = new ArrayList<>(List.of(
        new Subject(1, "Java"),
        new Subject(2, "C++")
    ));
// jF6Wt0iSfxIlGelsjiw0fNekeqB2Z6oWUrLooWkWux3ixe8VvWf0gnvzSHQIe9kItgEASOScV5gVA507YIKOwF4i3iXQ8okj
    @GetMapping("/subjects")
    public List<Subject> getAllSujects() {
        return subjectList;
    }

    @PostMapping("/subjects")
    public Subject addSubject(@RequestBody Subject subject) {
        subjectList.add(subject);
        return subject;
    }
}
