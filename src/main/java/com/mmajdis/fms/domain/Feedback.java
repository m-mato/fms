package com.mmajdis.fms.domain;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="message", nullable=false)
    private String message;

    public Long getId() {
        return id;
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

        Feedback that = (Feedback) o;

        return id.equals(that.id) && message.equals(that.message);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Feedback {")
                .append("id= ").append(id)
                .append(", message= ").append(message)
                .append('}').toString();
    }
}
