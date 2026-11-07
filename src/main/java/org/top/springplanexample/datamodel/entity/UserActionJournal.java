package org.top.springplanexample.datamodel.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="t_user_action")
public class UserActionJournal {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="f_action", nullable = false)
    private String action;

    @Column(name="f_user", nullable = false)
    private String user;

    @Column(name="f_date", nullable = false)
    private LocalDateTime date;

    public UserActionJournal() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
