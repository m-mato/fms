package com.mmajdis.fms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackDTO {

    @JsonProperty
    private String message;

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

        FeedbackDTO that = (FeedbackDTO) o;

        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("FeedbackDTO{ ")
                .append("message= ").append(message)
                .append('}').toString();
    }
}
