package com.springdev.relationshipsdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    public InstructorDetail() {
    }


    public InstructorDetail(String youtubeChannel, String hobby, Instructor instructor) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public InstructorDetail setInstructor(Instructor instructor) {
        this.instructor = instructor;
        return this;
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public InstructorDetail setId(int id) {
        this.id = id;
        return this;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public InstructorDetail setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
        return this;
    }

    public String getHobby() {
        return hobby;
    }

    public InstructorDetail setHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
