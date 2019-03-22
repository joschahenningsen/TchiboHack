package CoffeRank;

public class Coffee {
    double rank;
    String id;
    String name;
    String url;
    String price;
    String image;
    String description;
    int[]values; //6 elements in array


    public Coffee(String id,
                  String name,
                  String url,
                  String price,
                  String image,
                  String description,
                  int type,
                  int aroma,
                  int espresso,
                  int strength,
                  int fairtrade,
                  int decaf,
                  int capsule){
        this.id=id;
        this.name=name;
        this.url=url;
        this.price=price;
        this.image=image;
        this.description=description;
        this.values=new int[]{type, aroma, espresso, strength, fairtrade, decaf, capsule};
    }

    public double getRank(){
        return rank;
    }

    public String toString(){
        return name+"\n\t"+rank;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
