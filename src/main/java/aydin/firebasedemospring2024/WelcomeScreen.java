package aydin.firebasedemospring2024;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class WelcomeScreen {
    private boolean key;
    private ObservableList<Person> listOfUsers = FXCollections.observableArrayList();
    private Person person;

    public ObservableList<Person> getListOfUsers() {
        return listOfUsers;
    }

    @FXML
    private Button registerButtoon;

    @FXML
    private Button signInButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField passwordTextField;

   public void registerButtonClicked(ActionEvent event) throws IOException {
        registerUser();
    }

    @FXML
    void signInButtonClicked(ActionEvent event) throws IOException, FirebaseAuthException {
        key = true;

          if(DemoApp.fauth.getUserByEmail(emailTextField.getText()) != null) {
              System.out.println("User exists");
              DemoApp.setRoot("primary");
          } else {
              System.out.println("User does not exist");
          }
    }
    public void registerUser() throws IOException {
        DemoApp.setRoot("registrationView");
    }

}
