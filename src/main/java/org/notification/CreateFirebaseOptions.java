package org.notification;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import org.notification.exception.FcmConfigException;

import java.io.IOException;
import java.io.InputStream;

public class CreateFirebaseOptions {
    public static FirebaseOptions create(InputStream path, String projectId) {
        try {
            return initFirebaseOption(path, projectId);
        } catch (IOException e) {
            throw new FcmConfigException();
        }
    }

    public static FirebaseOptions initFirebaseOption(InputStream path, String projectId) throws IOException {
        return new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(path))
                .setProjectId(projectId)
                .build();
    }
}
