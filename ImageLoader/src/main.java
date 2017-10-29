import controller.Controller;
import view.Main;

public class main {

    public static void main(String[] args) {
        Main framePrincipal = new Main();
        new Controller(framePrincipal);
    }
}
