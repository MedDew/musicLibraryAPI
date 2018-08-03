/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musiclibrary.musiclibraryapi.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class MusicDTO 
{
    private long id;
    
    @NotNull
    @NotEmpty(message = "Please fill the album field")
    @Size(min = 2, message = "The album name is too short(minimum characater 2)")
    private String album;
    
    @NotNull
    @NotEmpty(message = "Please fill the band field")
    private String band;
    
    @NotNull
    @NotEmpty(message = "Please fill the release year field")
    private String releaseYear;
    
    @NotNull(message = "Please cselect a category") 
    private long categoryId;
    
    private Set<Long> genres;
    
    
    private LocalDate releaseYearLocalDate;
    
    private CategoryDTO category;
    
    private List<GenreDTO> genre;
    
    
    public LocalDate getReleaseYearLocalDate()
    {
        return this.releaseYearLocalDate;
    }
    
    public void setReleaseYearLocalDate(String dateToConvert)
    {
        LocalDate convertedDate = convertFromStringToLocalDate(dateToConvert);
        this.releaseYearLocalDate = convertedDate;
    }
    
    private LocalDate convertFromStringToLocalDate(String dateToConvert)
    {
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateToConvert, formatter);
        
        return localDate;
    }
    
    public MusicDTO(long id, String album, String band, String releaseYear, CategoryDTO category, List<GenreDTO> genre)
    {
        this.id = id;
        this.album = album;
        this.band = band;
        this.releaseYear = releaseYear;
        this.category = category;
        this.genre = genre;
    }
}
