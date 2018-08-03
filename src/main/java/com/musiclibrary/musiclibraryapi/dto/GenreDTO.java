/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musiclibrary.musiclibraryapi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Mehdi
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO 
{
    protected long Id;
    
    @NotNull
    @NotEmpty(message = "Please select a genre")
    protected String genreName;
}
