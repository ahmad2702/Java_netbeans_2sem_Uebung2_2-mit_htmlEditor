/**
 * Uebung 2.2
 * Akhmad Sadullaev
 * @author s0556420
 * @version 1.0
 */
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HauptFenster extends Application {
    
    private Stage stage;
    private Scene scene;
    private AnchorPane pane;
    private MenuBar menuBar;
    private HTMLEditor htmlEditor;
    
    private Label suchW;
    private TextField suchWort;
    private Button such;
    
    private Label ersetzW;
    private TextField ersetzWort;
    private Button ersetz;
    
    private Button endFunk;
    
    private String word;

    @Override
    public void start(Stage stage){
        this.stage=stage;
        this.pane = new AnchorPane();

        //Menu
        this.menuBar = new MenuBar();
        Menu fileMenu1 = new Menu("Datei");
            MenuItem neu = new MenuItem("Datei neu...");
            MenuItem open = new MenuItem("Datei öffnen...");
            MenuItem save = new MenuItem("Datei speichern unter...");
            MenuItem end = new MenuItem("Programm beenden");
        fileMenu1.getItems().addAll(neu, open, save, end);
        Menu fileMenu2 = new Menu("Bearbeiten");
            MenuItem suchen = new MenuItem("Suchen");
            MenuItem ersetzen = new MenuItem("Suchen & Ersetzen");
        fileMenu2.getItems().addAll(suchen, ersetzen);
        menuBar.getMenus().addAll(fileMenu1,fileMenu2);
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        pane.getChildren().add(menuBar);
       
        
        //Text Area
            this.htmlEditor = new HTMLEditor();
            htmlEditor.setPrefSize(993, 717);
            pane.getChildren().add(htmlEditor);
            AnchorPane.setTopAnchor(htmlEditor, 30.0);
            AnchorPane.setLeftAnchor(htmlEditor, 4.0);
  
            
        //Such
            suchW = new Label("Suchwort:");
            pane.getChildren().add(suchW);
            AnchorPane.setLeftAnchor(suchW, 10.0);
            AnchorPane.setBottomAnchor(suchW, 60.0);
            suchW.setVisible(false);
        //Suchen
            suchWort = new TextField();
            pane.getChildren().add(suchWort);
            AnchorPane.setLeftAnchor(suchWort, 10.0);
            AnchorPane.setBottomAnchor(suchWort, 35.0);
            suchWort.setVisible(false);
        //Such - Button
            such = new Button("suchen");
            pane.getChildren().add(such);
            AnchorPane.setLeftAnchor(such, 114.0);
            AnchorPane.setBottomAnchor(such, 5.0);
            such.setVisible(false);
        
            
        //Ersetz
            ersetzW = new Label("Ersatzwort:");
            pane.getChildren().add(ersetzW);
            AnchorPane.setLeftAnchor(ersetzW, 200.0);
            AnchorPane.setBottomAnchor(ersetzW, 60.0);
            ersetzW.setVisible(false);
        //ersetzWort
            ersetzWort = new TextField();
            pane.getChildren().add(ersetzWort);
            AnchorPane.setLeftAnchor(ersetzWort, 200.0);
            AnchorPane.setBottomAnchor(ersetzWort, 35.0);
            ersetzWort.setVisible(false);
        //Ersetz - Button
            ersetz = new Button("ersetzen");
            pane.getChildren().add(ersetz);
            AnchorPane.setLeftAnchor(ersetz, 295.0);
            AnchorPane.setBottomAnchor(ersetz, 5.0);
            ersetz.setVisible(false);
        

        //Schliessen
        endFunk = new Button("schliessen");
        pane.getChildren().add(endFunk);
        AnchorPane.setRightAnchor(endFunk, 10.0);
        AnchorPane.setBottomAnchor(endFunk, 5.0);
        endFunk.setVisible(false);
        

        //GUI
        scene = new Scene(pane, 1000, 750);
        stage.setTitle("TextEditor");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        

        //Obrabotka
            //Sverhu
        suchen.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                htmlEditor.setPrefSize(993, 640);
                endFunk.setVisible(true);
                
                suchW.setVisible(true);
                suchWort.setVisible(true);
                such.setVisible(true);
                
                ersetzW.setVisible(false);
                ersetzWort.setVisible(false);
                ersetz.setVisible(false);
            }
        });
            //Nachat poisk
        such.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!suchWort.getText().equals("")){
                    if(word == null){
                        word = suchWort.getText();
                        checkAllWort(htmlEditor, word, word);
                    }else if(!word.equals(suchWort.getText())){
                        htmlEditor.setHtmlText(htmlEditor.getHtmlText().replaceAll("<mark>", ""));
                        htmlEditor.setHtmlText(htmlEditor.getHtmlText().replaceAll("</mark>", ""));
                        word = suchWort.getText();
                        checkAllWort(htmlEditor, word, word);
                    }   
                }
            }
        });
            //Sverhu
        ersetzen.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                htmlEditor.setPrefSize(993, 640);
                endFunk.setVisible(true);
                
                suchW.setVisible(true);
                suchWort.setVisible(true);
                such.setVisible(true);
                
                ersetzW.setVisible(true);
                ersetzWort.setVisible(true);
                ersetz.setVisible(true);
            }
        });
            //Nachat zamenu
        ersetz.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!ersetzWort.getText().equals("")){
                    checkAllWort(htmlEditor, suchWort.getText(), ersetzWort.getText());
                }
            }
        });
        
            //Zakrit
        endFunk.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                htmlEditor.setPrefSize(993, 717);
                endFunk.setVisible(false);
                
                suchW.setVisible(false);
                suchWort.setVisible(false);
                such.setVisible(false);
                suchWort.setText("");
                
                ersetzW.setVisible(false);
                ersetzWort.setVisible(false);
                ersetz.setVisible(false);
                ersetzWort.setText("");
                
                
                htmlEditor.setHtmlText(htmlEditor.getHtmlText().replaceAll("<mark>", ""));
                htmlEditor.setHtmlText(htmlEditor.getHtmlText().replaceAll("</mark>", ""));
            }
        });
        
    }
    
    private void checkAllWort(HTMLEditor text, String oldW, String newW){
        String myString = text.getHtmlText();
        newW = "<mark>" + newW + "</mark>";
        this.htmlEditor.setHtmlText(myString.replaceAll(oldW, newW));
    }
    
    
    
}

