package Assignment;

public class Book {
    private long id;
    private String title;
    private String description;
    private String img;
    private String content;
    private String author;
    private String date;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String tieuDe) {
        this.title = title;
    }

    public void setDescription(String moTa) {
        this.description = description;
    }

    public void setImg(String anhDaiDien) {
        this.img = img;
    }

    public void setContent(String noiDungChinh) {
        this.content = content;
    }

    public void setAuthor(String tenTacGia) {
        this.author = author;
    }

    public void setDate(String ngayViet) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

}
