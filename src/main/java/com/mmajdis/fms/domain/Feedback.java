package com.mmajdis.fms.domain;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback extends Audited {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_author")
    private User author;

    @Column(name = "message", nullable = false)
    private String message;

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Feedback feedback = (Feedback) o;

        return id.equals(feedback.id) && author.equals(feedback.author) && message.equals(feedback.message);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Feedback {")
                .append("id= ").append(id)
                .append(", author= ").append(author)
                .append(", message= ").append(message)
                .append('}').toString();
    }
}
