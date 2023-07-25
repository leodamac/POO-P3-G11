module com.mycompany.poop3g11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.poop3g11 to javafx.fxml;
    exports com.mycompany.poop3g11;
    
    opens configuracionControllers to javafx.fxml;
    exports configuracionControllers;
    
    opens terminosAcademicosControllers to javafx.fxml;
    exports terminosAcademicosControllers;
    
    opens materiasParalelosControllers to javafx.fxml;
    exports materiasParalelosControllers;
    
    opens administrarPreguntasControllers to javafx.fxml;
    exports administrarPreguntasControllers;
    
    opens juego to javafx.fxml;
    exports juego;
}
