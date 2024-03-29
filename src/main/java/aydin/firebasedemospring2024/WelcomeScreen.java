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
    void registerButtonClicked(ActionEvent event) {
        registerUser();
    }

    @FXML
    void signInButtonClicked(ActionEvent event) throws IOException, FirebaseAuthException {
        key = true;

          if(DemoApp.fauth.getUserByEmail("user2447@example.com") != null) {
              System.out.println("User exists");
              DemoApp.setRoot("primary");
          } else {
              System.out.println("User does not exist");
          }
    }
    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail("user2447@example.com")
                .setEmailVerified(false)
                .setPassword("secretTassword")
                .setPhoneNumber("+112305678997")
                .setDisplayName("Sohn Doe")
                .setDisabled(false);

        UserRecord userRecord;
        try {
            userRecord = DemoApp.fauth.createUser(request);
            System.out.println("Successfully created new user with Firebase Uid: " + userRecord.getUid()
                    + " check Firebase > Authentication > Users tab");
            return true;

        } catch (FirebaseAuthException ex) {
            // Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error creating a new user in the firebase");
            return false;
        }

    }

}
