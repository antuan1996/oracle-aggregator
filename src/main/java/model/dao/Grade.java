package model.dao;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
@Entity
public class Grade {

    @Id @GeneratedValue private int id;

    private int value;
    private char latin_value;
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
