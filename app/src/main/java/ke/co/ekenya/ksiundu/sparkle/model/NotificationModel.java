package ke.co.ekenya.ksiundu.sparkle.model;

public class NotificationModel {
    String title, status, date;
    int image;

    public NotificationModel() {
    }

    public NotificationModel(int image, String title, String status, String date) {
        this.image = image;
        this.title = title;
        this.status = status;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
