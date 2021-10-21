package view;

public class ClientCredentials {
    CMDInput cmdInput = new CMDInput();

    public String getClientID() {
        System.out.println("Enter Client ID: ");
        return cmdInput.inputStringViaCommandLine();
    }

    public String getClientSecretID() {
        System.out.println("Enter Client Secret ID: ");
        return cmdInput.inputStringViaCommandLine();

    }
}
