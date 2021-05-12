package com.library.book;

import java.time.LocalDate;

public class Audit {
    protected LocalDate created_at = LocalDate.now();

    protected LocalDate modified_at = LocalDate.now();

    public LocalDate getCreated_at(){
       return created_at;
    }

}
