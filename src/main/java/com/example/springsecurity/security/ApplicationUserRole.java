package com.example.springsecurity.security;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Set;

import static com.example.springsecurity.security.ApplicationUserPermission.COURSE_WRITE;
import static com.example.springsecurity.security.ApplicationUserPermission.COURSE_READ;
import static com.example.springsecurity.security.ApplicationUserPermission.STUDENT_WRITE;
import static com.example.springsecurity.security.ApplicationUserPermission.STUDENT_READ;

@Getter
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_WRITE, COURSE_READ, STUDENT_WRITE, STUDENT_READ)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
