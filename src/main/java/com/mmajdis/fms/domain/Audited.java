package com.mmajdis.fms.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
public abstract class Audited {

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Audited audited = (Audited) o;

        return (created != null ? created.equals(audited.created) : audited.created == null)
                && (updated != null ? updated.equals(audited.updated) : audited.updated == null);
    }

    @Override
    public int hashCode() {
        int result = created != null ? created.hashCode() : 0;
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Audited {")
                .append("created= ").append(created)
                .append(", updated= ").append(updated)
                .append('}').toString();
    }
}
