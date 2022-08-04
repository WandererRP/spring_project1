package ru.rol.springproject1.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Person {


    private int person_id;
    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "([А-Я][А-Яа-я-]+ [А-Я][А-Яа-я-]+ [А-Я][А-Яа-я-]+)",
            message = "Неправильный формат. Должно быть: Фамилия Имя Отчество (Кириллицей)")
    private String fullname;
    @Min(value = 1900, message = "Year should be greater than 1900")
    @Max(value = 2030, message = "Year should be real")
    private int year_of_birth;


    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }
}
