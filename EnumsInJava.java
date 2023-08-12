public class EnumsInJava {
    public static void main(String [] args){
        TrafficSignal obj = TrafficSignal.Green;
        System.out.println(obj.getAction());
    }
}

enum TrafficSignal{
    Red("Stop"), 
    Green("Go"), 
    Yellow("Wait");

    private String action;

    private TrafficSignal(String action){
        this.action = action;
    }

    public String getAction(){
        return this.action;
    }
}