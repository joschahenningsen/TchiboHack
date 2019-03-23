package Server.Routes;

public class Start extends Route {
    public Start(){
        setUrl("/start");
    }

    @Override
    public void setupPage() {
        setTemplateFile("html/start.html");
    }
}
