import org.example.Category;

public class Book {
    private String Author;
    private String Title;
    private String Publisher;
    private int Year;
    private Category category;
    private String Country;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }



    public Book(String author, String title, String publisher, int year, Category category, String country) {
        Author = author;
        Title = title;
        Publisher = publisher;
        Year = year;
        this.category = category;
        Country = country;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Автор ='" + Author + '\'' +
                ", Название ='" + Title + '\'' +
                ", Издатель ='" + Publisher + '\'' +
                ", Год =" + Year +
                ", Категория =" + category +
                ", Страна ='" + Country + '\'' +
                '}';
    }
}



