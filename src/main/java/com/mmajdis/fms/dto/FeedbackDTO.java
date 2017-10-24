package com.mmajdis.fms.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.time.ZonedDateTime;

/**
 * DTO used to transfer values of Feedback properties.
 *
 * @author Matej Majdis [<a href="mailto:mato.majdis@gmail.com">mato.majdis@gmail.com</a>]
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    @NotBlank
    private String message;

    @JsonProperty
    private ZonedDateTime created;

    @JsonProperty
    @NotBlank
    private String authorUsername;

    /**
     * @return database id of feedback.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return value of message in feedback.
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return date and time specifying when feedback was created.
     */
    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    /**
     * @return username of author who added feedback.
     */
    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackDTO that = (FeedbackDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        return authorUsername != null ? authorUsername.equals(that.authorUsername) : that.authorUsername == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (authorUsername != null ? authorUsername.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("FeedbackDTO{ ")
                .append("id= ").append(id)
                .append("message= ").append(message)
                .append("created= ").append(created)
                .append("authorUsername= ").append(authorUsername)
                .append('}').toString();
    }
}
