package com.example.LibraryManagementSystem.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TempModel implements Serializable {

    /*
    * Primary Key Should be serializable
    *
    * */


    @Id
    private int id;
    @Id
    private int stringName;

}
