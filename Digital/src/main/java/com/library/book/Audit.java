package com.library.book;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit {

    @CreatedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'", updatable = false)
    protected LocalDate created_at = LocalDate.now();

    @LastModifiedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'")
    protected LocalDate modified_at = LocalDate.now();

    public LocalDate getCreated_at(){
       return created_at;
    }

    public void setCreated_at(LocalDate created_at){
        this.created_at = created_at;
    }

    public LocalDate getModified_at(){
        return modified_at;
    }

    public void setModified_at(LocalDate modified_at){
        this.modified_at = modified_at;
    }

}
