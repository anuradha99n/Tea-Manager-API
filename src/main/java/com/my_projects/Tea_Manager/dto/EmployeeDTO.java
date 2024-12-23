package com.my_projects.Tea_Manager.dto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeDTO {
    private Long id;
    private String name;
    private String contact;
    private LocalDateTime joinedDateTime;
    private String address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDateTime getJoinedDateTime() {
        return joinedDateTime;
    }

    public void setJoinedDateTime(LocalDateTime joinedDateTime) {
        this.joinedDateTime = joinedDateTime;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
