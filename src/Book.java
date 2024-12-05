public class Book {
    private String Author;
    private String Title;
    private String Publisher;
    private String Year;
    private String Country;
    private String librarySection;

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

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getLibrarySection() {
        return librarySection;
    }

    public void setLibrarySection(String librarySection) {
        this.librarySection = librarySection;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Book(String author, String title, String publisher, String year, String country, String librarySection) {
        Author = author;
        Title = title;
        Publisher = publisher;
        Year = year;
        Country = country;
        this.librarySection = librarySection;
    }
}