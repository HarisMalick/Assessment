package com.lendo.assessment.LendoAssmt.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_id")
    private int postId;

    @Column(name = "title")
    private String title;
}
