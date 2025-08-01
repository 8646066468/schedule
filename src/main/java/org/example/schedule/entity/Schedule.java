package org.example.schedule.entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class Schedule extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String title;
    private String password;
    private String name;

    public Schedule(String content, String title, String password, String name) {
        this.content = content;
        this.title = title;
        this.password = password;
        this.name = name;
    }
}
