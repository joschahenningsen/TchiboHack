package Server.Routes;

public class Checkout extends Route {

    public Checkout(){
        setUrl("/checkout");
    }

    @Override
    public void setupPage() {
        setTemplateFile("html/checkout.html");
    }
}
