module org.example.articlefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens org.example.articlefx to javafx.fxml, javafx.graphics;
    opens org.example.articlefx.controller to javafx.fxml, javafx.graphics;
    exports org.example.articlefx;
}