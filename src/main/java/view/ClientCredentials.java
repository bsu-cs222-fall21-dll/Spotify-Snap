package view;

public class ClientCredentials {
    CMDInput cmdInput = new CMDInput();

    public String getClientID() {
        System.out.println("Enter Client ID: ");
        final String clientID = cmdInput.inputString();
        return clientID;
    }

    public String getClientSecretID() {
        System.out.println("Enter Client Secret ID: ");
        final String clientSecretID = cmdInput.inputString();
        return clientSecretID;
    }
}
