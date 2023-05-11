package com.example.pizzashop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {

        private Long id;

        private String firstName;


        private String lastName;

        private String email;

        private String login;

        private String password;


    }

