package by.perkal.SpringFirstApp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private String title;
    private String author;
}
