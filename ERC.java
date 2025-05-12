
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class studyroomunavailableexception extends Exception{
    public studyroomunavailableexception(String message){
        super(message);
    }
}

class Student implements Runnable{
    String st_name;
    List<room> rooms;

    Student(String name,List<room> rooms){
        st_name = name;
        this.rooms = rooms;
    }

    public void run(){
        //Random random = new Random();
        //int rand_int = random.nextInt(3-1+1)+1;
        
        
            //System.out.println(st_name);
            for(int attempt=0;attempt<5;attempt++){
                try{
            Random random = new Random();
            int rand_int = random.nextInt(5-1+1)+1;
            System.out.println(st_name + " is waiting to access r"+rand_int);
            room selected = rooms.get(rand_int-1);
 
            selected.book();
            Thread.sleep(300);
            selected.free();
            Thread.sleep(300);
            }
            catch (InterruptedException | studyroomunavailableexception ex) {
            System.out.println(st_name + " encountered an issue "+ ex.getMessage());
        }
        } 
    }
}

class room{
    int room_num;
    boolean available ;
    private final Lock study_room_lock = new ReentrantLock();

    room(int room_num){
        this.room_num = room_num;
        available = true;
    }

    void set_available(){
        available = false;
    }

    void book() throws studyroomunavailableexception{
        study_room_lock.lock();
        try {
            if (available){
                System.out.println("room "+room_num + " is booked now");
                set_available();
            }
            else {
                throw new studyroomunavailableexception("room "+room_num+" is currently booked");
            }
        } finally {
            study_room_lock.unlock();
        }
    }

    void free(){
        study_room_lock.lock();
        try {
            available = true;
            System.out.println(room_num + " is free");
        } finally {
            study_room_lock.unlock();
        }
    }
}

class ERC{
public static void main(String[] args) throws InterruptedException {
    List<String> names = new ArrayList<>(List.of("s1","s2","s3","s4","s5"));
    List<room> rooms = new ArrayList<>(List.of(
        new room(1),
        new room(2),
        new room(3),
        new room(4),
        new room(5)
    ));

    //for (int j = 0;j<5;j++){
    //    room r = new room(rooms.get(j));
    //}
    for (int i = 0;i<5;i++){
        Student s = new Student(names.get(i),rooms);
        Thread t = new Thread(s);
        t.start();
        
    }

    
}
}
