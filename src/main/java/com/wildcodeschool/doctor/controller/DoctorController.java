package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {
    Doctor doctor = new Doctor(13, "Jodie Whittaker");

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable Integer number) {
        if (number.equals(doctor.getNumber())) {
            return doctor;
        } else if (number >= 1 && number <= 13) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Impossible de récupérer l'incarnation " + number);
        }
    }
}
/*
 * 
 * 
 * @GetMapping("/movie/{category}/")
 * 
 * @ResponseBody
 * public List<Movie> loadMovies(@PathVariable String category,
 * 
 * @RequestParam(defaultValue = "") String attribute) {
 * 
 * return Movies.getByCategory(category).sortBy(attribute):
 * }
 * 
 * @GetMapping("/questions/{id}")
 * Question getQuestion(@PathVariable int id) {
 * if (id == 0) {
 * throw new ResponseStatusException(HttpStatus.NOT_FOUND,
 * "Question Not Found");
 * }
 * return Questions.getById(id);
 * }
 */