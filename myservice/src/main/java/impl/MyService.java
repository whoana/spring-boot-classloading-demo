package impl;

import util.Hello;

public class MyService extends Service{
     
    @Override
    public void service() {
        Hello hello = new Hello();
        String string = hello.say();
        System.out.println(string);
    }
    
}
