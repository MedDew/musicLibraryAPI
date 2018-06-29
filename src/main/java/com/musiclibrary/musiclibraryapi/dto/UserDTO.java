/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musiclibrary.musiclibraryapi.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author Mehdi
 */
@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;
    
    @NotNull
    @NotEmpty(message = "Please fill the creation date field")
    private String creationDate;
    
    private LocalDateTime creationDateLocalDateTime;
    
    @NotNull
    @NotEmpty(message = "Please fill the first name field")
    private String firstName;

    private Boolean isLogged;
    private String lastLoginDate;
    private LocalDateTime lastLoginDateLocalDateTime;
    
    @NotNull
    @NotEmpty(message = "Please fill the last name field")
    private String lastName;

    public UserDTO(Long id, String creationDate,LocalDateTime creationDateLocalDateTime, String firstName, Boolean isLogged, String lastLoginDate, LocalDateTime lastLoginDateLocalDateTime, String lastName) {
        this.id = id;
        this.creationDate = creationDate;
        this.creationDateLocalDateTime = creationDateLocalDateTime;
        this.firstName = firstName;
        this.isLogged = isLogged;
        this.lastLoginDate = lastLoginDate;
        this.lastLoginDateLocalDateTime = lastLoginDateLocalDateTime;
        this.lastName = lastName;
    }

    public UserDTO() {

    }

    public LocalDateTime getCreationDateLocalDateTime() {
        return this.creationDateLocalDateTime;
    }

    public void setCreationDateLocalDateTime(String dateToConvert) {
        LocalDateTime convertedDate = convertFromStringToLocalDateTime(dateToConvert);
        this.creationDateLocalDateTime = convertedDate;
    }

    public LocalDateTime getLastLoginDateLocalDateTime() {
        return this.lastLoginDateLocalDateTime;
    }

    public void setLastLoginDateLocalDateTime(String dateToConvert) {
        LocalDateTime convertedDate = convertFromStringToLocalDateTime(dateToConvert);
        this.lastLoginDateLocalDateTime = convertedDate;
    }

    private LocalDateTime convertFromStringToLocalDateTime(String dateToConvert) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateToConvert, formatter);

        return localDateTime;
    }

    private String convertFromLocalDateTimeToString(LocalDateTime dateToConvert) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTime = dateToConvert.format(formatter);

        return localDateTime;
    }
    
    @Override
    public String toString()
    {
        return "["+id+" | "+creationDate+" | "+creationDateLocalDateTime+" | "+firstName+" | "+isLogged+" | "+lastLoginDate+" | "+lastLoginDateLocalDateTime+" | "+lastName+"]";
    }
}
