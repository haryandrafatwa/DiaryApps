package motion.diaryapps.list_notes;

import java.io.Serializable;

/**
 * Class ini digunakan untuk sebagai Model data pada layout item
 */
public class ListNotesModel {

    private String id;
    private String image_url;
    // TODO: 4/12/19 -> Buat Attribute title dan date disini
    // hint: untuk date gunakan tipe data string, lakukan seperti contoh diatas
    private String title;
    private String date;
    // TODO: 4/12/19 -> Buat Constructor disini
    // hint: Gunakan alt+insert

    public ListNotesModel(String id, String image_url, String title, String date) {
        this.id = id;
        this.image_url = image_url;
        this.title = title;
        this.date = date;
    }
    // TODO: 4/12/19 -> Buat Getter dan Setternya disini
    // hint: Gunakan alt+insert

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
