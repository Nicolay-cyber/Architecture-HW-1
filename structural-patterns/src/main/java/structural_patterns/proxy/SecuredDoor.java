package structural_patterns.proxy;

public class SecuredDoor {
    Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }

    public void open(String password){
        if(authenticate(password)){
            door.open();
        }else {
            System.out.println("Big no! It ain't possible.");
        }
    }
    public boolean authenticate(String password){
        return password.equals("$ecr@t");
    }
    public void close(){
        door.close();
    }
}
