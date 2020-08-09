package study.assignment2.Project1.dto;

import study.assignment2.Project1.model.BookEntity;

public class BookDto {

    private String name;

    private String authorName;

    private Integer cost;

    public BookDto(String name, String authorName, Integer cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
    }

    public BookDto(BookEntity bookEntity) {
        this.name = bookEntity.getName();
        this.authorName = bookEntity.getAuthorName();
        this.cost = bookEntity.getCost();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
