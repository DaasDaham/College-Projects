import java.util.*;
import java.io.*;

//SAAD AHMAD
//2018409

class Lab2{
    public static HashMap<String, ArrayList<Item>> catMap = new HashMap<>();
    public static int idCounter = 0;
    public static double companyprofit=0;
    public static ArrayList<Merchant> allMerchants = new ArrayList<Merchant>();
    public static ArrayList<Customer> allCustomers = new ArrayList<Customer>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Merchant m1 = new Merchant(1, "Jack", "IIITD");
        Merchant m2 = new Merchant(2, "John", "IIITD");
        Merchant m3 = new Merchant(3, "James", "IIITD");
        Merchant m4 = new Merchant(4, "Jeff", "IIITD");
        Merchant m5 = new Merchant(5, "Joseph", "IIITD");
        allMerchants.add(m1);
        allMerchants.add(m2);
        allMerchants.add(m3);
        allMerchants.add(m4);
        allMerchants.add(m5);
        Customer c1 = new Customer(1, "ali");
        Customer c2 = new Customer(2, "nobby");
        Customer c3 = new Customer(3, "bruno");
        Customer c4 = new Customer(4, "borat");
        Customer c5 = new Customer(5, "aladeen");
        allCustomers.add(c1);
        allCustomers.add(c2);
        allCustomers.add(c3);
        allCustomers.add(c4);
        allCustomers.add(c5);
        int endchoice = 0;
        while(endchoice!=5){
            System.out.println("Welcome to Mercury");
            System.out.println("1) Enter as Merchant");
            System.out.println("2) Enter as Customer");
            System.out.println("3) See user details");
            System.out.println("4) Company account balance");
            System.out.println("5) Exit");
            endchoice = s.nextInt();
            if(endchoice==4){
                System.out.println(companyprofit);
            }
            else if(endchoice==3){
                System.out.println("input: ");
                String morc = s.next();
                int id = s.nextInt();
                if(morc.equals("M")){
                    usedisplayDetails(allMerchants.get(id-1));
                }
                else{
                    usedisplayDetails(allCustomers.get(id-1));
                }
            }
            else if(endchoice==1){
                Iterator<Merchant> i = allMerchants.iterator();
                while(i.hasNext()){
                    Merchant temp = i.next();
                    System.out.println(temp.getId()+")"+" "+temp.getName());
                }
                int choiceofMerch = s.nextInt();
                usedisplayMenu(allMerchants.get(choiceofMerch-1));
            }
            else if(endchoice==2){
                Iterator<Customer> i = allCustomers.iterator();
                while(i.hasNext()){
                    Customer temp = i.next();
                    System.out.println(temp.getId()+")"+" "+temp.getName());
                }
                int choiceofCustomer = s.nextInt();
                usedisplayMenu(allCustomers.get(choiceofCustomer-1));
            }
        }
        
    }
    public static void useSearch(CompCustomer cc){
        cc.Searching();
    }
    public static void usedisplayMenu(CompCustomer cc){
        cc.displayMenu();
    }
    public static void usedisplayDetails(CompCustomer cc){
        cc.displayDetails();
    }
    public static void usePR(CompCustomer cc){
        cc.printReward();
    }
}

interface CompCustomer{
    public void Searching();
    public int displayMenu();
    public void displayDetails();
    public void printReward();
}

class Merchant implements CompCustomer{
    private int id;
    private String name;
    private String address;
    private double contribution;
    private int maxSlots;
    private ArrayList<Item> allItems;

    public Merchant(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contribution = 0;
        this.maxSlots = 10;
        this.allItems = new ArrayList<Item>();
    }

    @Override
    public void Searching(){
        Scanner s = new Scanner(System.in);
        for(String catName : Lab2.catMap.keySet()){
            System.out.println("Category: "+catName);
        }
        System.out.println("Enter category");
        String cat = s.next();
        ArrayList tempItemList = Lab2.catMap.get(cat);
        Iterator<Item> iter = tempItemList.iterator();
        while(iter.hasNext()){
            Item tempItem = iter.next();
            System.out.println(tempItem.getId()+1+" "+tempItem.getName()+" "+tempItem.getPrice()+" "+tempItem.getQuantity()+" "+tempItem.getOffer()+" "+tempItem.getCategory());
        }
    }

    @Override
    public int displayMenu(){
        Scanner s = new Scanner(System.in);
        int choice=0;
        while(choice!=6){
        System.out.println("Welcome "+this.name);
        System.out.println("Merchant Menu");
        System.out.println("1) Add item");
        System.out.println("2) Edit item");
        System.out.println("3) Search by category");
        System.out.println("4) Add offer");
        System.out.println("5) Rewards won");
        System.out.println("6) Exit");
        choice = s.nextInt();
        if(choice==1){
            this.addItems();
        }
        else if(choice ==2){
            this.editItems();
        }
        else if(choice==3){
            Lab2.useSearch(this);
        }
        else if(choice==4){
            this.addOffer();
        }
        else if(choice==5){
            Lab2.usePR(this);
        }
    }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public void displayDetails(){
        System.out.println("User id: "+this.id+" Name: "+this.name);
    }

    public void addItems(){
        Scanner s = new Scanner(System.in);
        if(this.allItems.size()<=this.maxSlots){
            System.out.println("Enter item details");
            System.out.println("item name:");
            String i_name = s.next();
            System.out.println("item price:");
            double i_price = s.nextDouble();
            System.out.println("item quantity:");
            int i_quantity = s.nextInt();
            System.out.println("item category");
            String i_category = s.next();
            int i_id = Lab2.idCounter++;
            Item itemToAdd = new Item(i_id, i_name, i_price, i_quantity, i_category, name);
            System.out.println((i_id+1)+" "+i_name+" "+i_price+" "+i_quantity+" "+itemToAdd.getOffer()+" "+i_category);
            allItems.add(itemToAdd);
            if(Lab2.catMap.containsKey(i_category)){
                Lab2.catMap.get(i_category).add(itemToAdd);
            }
            else{
                ArrayList<Item> tempList = new ArrayList<Item>();
                tempList.add(itemToAdd);
                Lab2.catMap.put(i_category, tempList);
            }
        }
        else{
            System.out.println("You've exceeded the limit of maximum slots, kindly pay 100 to add a slot");
        }
    }

    @Override
    public void printReward(){
        if(maxSlots>10){
            System.out.println(maxSlots-10);
        }
        else{
            System.out.println(0);
        }
    }

    public void editItems(){
        Scanner s = new Scanner(System.in);
        System.out.println("Choose item by code");
        Iterator<Item> itemIter = allItems.iterator();
        while(itemIter.hasNext()){
            Item tempItem = itemIter.next();
            System.out.println((tempItem.getId()+1)+" "+tempItem.getName()+" "+tempItem.getPrice()+" "+tempItem.getQuantity()+" "+tempItem.getOffer()+" "+tempItem.getCategory());
        }
        int index = s.nextInt();
        System.out.println("Enter edit details");
        System.out.println("item price:");
        allItems.get(index-1).setPrice(s.nextDouble());
        System.out.println("item quantity:");
        allItems.get(index-1).setQuantity(s.nextInt());
        Item tempItem = allItems.get(index-1);
        System.out.println((tempItem.getId()+1)+" "+tempItem.getName()+" "+tempItem.getPrice()+" "+tempItem.getQuantity()+" "+tempItem.getOffer()+" "+tempItem.getCategory());  
    }

    public void addOffer(){
        Scanner s = new Scanner(System.in);
        System.out.println("Choose item by code");
        Iterator<Item> itemIter = allItems.iterator();
        while(itemIter.hasNext()){
            Item tempItem = itemIter.next();
            System.out.println((tempItem.getId()+1)+" "+tempItem.getName()+" "+tempItem.getPrice()+" "+tempItem.getQuantity()+" "+tempItem.getOffer()+" "+tempItem.getCategory());
        }
        int index = s.nextInt();
        System.out.println("choose offer");
        System.out.println("1) buy one get one");
        System.out.println("2) 25% off");
        int choice = s.nextInt();
        if(choice ==1){
            allItems.get(index-1).setOffer("buy one get one");
        }
        else{
            allItems.get(index-1).setOffer("25% off");
        }
        Item tempItem = allItems.get(index-1);
        System.out.println((tempItem.getId()+1)+" "+tempItem.getName()+" "+tempItem.getPrice()+" "+tempItem.getQuantity()+" "+tempItem.getOffer()+" "+tempItem.getCategory());
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }
}

class Customer implements CompCustomer{
    private int id;
    private String name;
    private double reward;
    private double accBalance;
    private Queue<Item> cart = new LinkedList<>();
    private int numPurchase=0;
    private ArrayList<Purchase> recent = new ArrayList<Purchase>();

    @Override
    public int displayMenu(){
        Scanner s = new Scanner(System.in);
        int choice=0;
        while(choice!=5){
        System.out.println("Welcome "+this.name);
        System.out.println("Customer Menu");
        System.out.println("1) Search item");
        System.out.println("2) Checkout cart");
        System.out.println("3) Reward won");
        System.out.println("4) print latest orders");
        System.out.println("5) Exit");
        choice = s.nextInt();
        if(choice==1){
            Lab2.useSearch(this);
        }
        else if(choice==2){
            this.Checkout();
        }
        else if(choice==3){
            Lab2.usePR(this);
        }
        else if(choice==4){
            this.latestOrders();
        }
        }
        return 0;
    }

    @Override
    public void Searching(){
        Scanner s = new Scanner(System.in);
        for(String catName : Lab2.catMap.keySet()){
            System.out.println("Category: "+catName);
        }
        System.out.println("Enter category");
        String cat = s.next();
        ArrayList tempItemList = Lab2.catMap.get(cat);
        Iterator<Item> iter = tempItemList.iterator();
        System.out.println("choose item by code");
        while(iter.hasNext()){
            Item tempItem = iter.next();
            System.out.println((tempItem.getId()+1)+" "+tempItem.getName()+" "+tempItem.getPrice()+" "+tempItem.getQuantity()+" "+tempItem.getOffer()+" "+tempItem.getCategory());
        }
        int code = s.nextInt();
        Iterator<Item> iter2 = tempItemList.iterator();
        Item item_temp = new Item(-2, "noName", -1, -1, "noCategory", "noMerch");
        int q_temp=0;
        while(iter2.hasNext()){
            item_temp = iter2.next();
            if(item_temp.getId()==(code-1)){
                System.out.println("Enter item quantity");
                q_temp = s.nextInt();
                break;
            }
        }
        System.out.println("Choose method of transaction");
        System.out.println("1) Buy item");
        System.out.println("2) Add item to cart");
        System.out.println("3) Exit");
        int buy_choice = s.nextInt();
        if(buy_choice==1){
            transaction(item_temp, q_temp);
        }
        else if(buy_choice==2){
            item_temp.optionalQ = q_temp;
            cart.add(item_temp);
            System.out.println("Item added to cart");
        }
    }

    public void Checkout(){
        Iterator qIter = cart.iterator();
        boolean toBreak = true;
        while(qIter.hasNext() && toBreak==true){
            Item toTransact = cart.remove();
            int qu = toTransact.optionalQ;
            toBreak = transaction(toTransact, qu);
        }
        if(toBreak == true){
            System.out.println("Transaction complete");
        }
        else{
            System.out.println("Transaction failure");
        }
    }

    public void latestOrders(){
        Iterator<Purchase> i = recent.iterator();
        int count=0;
        while(i.hasNext()&&count<=10){
            Purchase p = i.next();
            System.out.println("Bought item "+p.name+" quantity "+p.quantity+" for Rs "+p.price+" from Merchant: "+p.merchName);
            count++;
        }
    }

    public boolean transaction(Item toBuy, int quantity){
        boolean complete = false;
        if(toBuy.getQuantity()>=quantity){
            boolean b1g1f = false;
            boolean off25 = false;
            double chngPrice = toBuy.getPrice();
            if(toBuy.getOffer().charAt(0) == '2'){
                double np = toBuy.getPrice() - (0.25*toBuy.getPrice());
                chngPrice = np;
                off25 = true;
            }
            else if(toBuy.getOffer().charAt(0) == 'b'){
                b1g1f = true;
            }
            double comInterest = 0.005*(quantity*chngPrice);
            double newPrice = (quantity*chngPrice)+comInterest;
            if(accBalance+reward >= newPrice){
                if(accBalance>=newPrice){
                    accBalance -= newPrice;
                }
                else{
                    double left = newPrice-accBalance;
                    accBalance=0;
                    reward -= left;
                }
                for(ArrayList temp : Lab2.catMap.values()){
                    Iterator<Item> i = temp.iterator();
                    int count=0;
                    while(i.hasNext()){
                        Item dem = i.next();
                        if(dem.getId() == toBuy.getId()){
                            if(b1g1f){dem.setQuantity(dem.getQuantity()-((quantity)*2));}
                            else{dem.setQuantity(dem.getQuantity()-(quantity));}
                            if(dem.getQuantity()<0){dem.setQuantity(0);}
                            temp.set(count, dem);
                        }
                        count++;
                    }
                }
                Iterator<Merchant> merchIter = Lab2.allMerchants.iterator();
                int count=0;
                while(merchIter.hasNext()){
                    Merchant tempMerch = merchIter.next();
                    if(tempMerch.getName().equals(toBuy.getMerchantstr())){
                        break;
                    }
                    count++;
                }
                Merchant tMerch = Lab2.allMerchants.get(count);
                Lab2.allMerchants.get(count).setContribution(tMerch.getContribution()+comInterest);
                Lab2.companyprofit+=2*comInterest;
                double cont = Lab2.allMerchants.get(count).getContribution();
                if(cont>=100){
                    Lab2.allMerchants.get(count).setContribution(0);
                    Lab2.allMerchants.get(count).setMaxSlots(tMerch.getMaxSlots()+1);
                }
                numPurchase++;
                if(numPurchase>=5){
                    reward+=10;
                }
                Purchase p = new Purchase();
                if(b1g1f){System.out.println("Item bought "+toBuy.getName()+" "+(quantity*2));
                        p.quantity = quantity*2;}
                else{System.out.println("Item bought "+toBuy.getName()+" "+quantity);
                        p.quantity=quantity;}
                complete=true;
                p.name = toBuy.getName();
                p.price = newPrice-comInterest;
                p.merchName = tMerch.getName();
                recent.add(p);
            }
            else{
                System.out.println("Not enough money available");
                return complete;
            } 
        }
        else{
            System.out.println("error, not enough items available");
            return complete;
        }
        return complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printReward(){
        System.out.println(this.reward);
    }

    @Override
    public void displayDetails(){
        System.out.println("User id: "+this.id+" Name: "+this.name);
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.reward = 0;
        this.accBalance = 100;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    
}

class Item{
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String offer;
    private String merchantstr;
    public int optionalQ=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOffer() {
        return offer;
    }

    public Item(int id, String name, double price, int quantity, String category, String merchantstr) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.offer = "None";
        this.merchantstr = merchantstr;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getMerchantstr() {
        return merchantstr;
    }

    public void setMerchantstr(String merchantstr) {
        this.merchantstr = merchantstr;
    }

}

class Purchase{
    public int quantity;
    public double price;
    public String name;
    public String merchName;
}