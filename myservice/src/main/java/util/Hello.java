package util;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
 

public class Hello {
    public String say(){
        
        

        System.out.println("1,2,3,4,5 의 평균");
		int[] arr = new int[]{1,2,3,4,5};
		
		Mean m = new Mean(); // 이것이 math3 라이브러리에서 평균을 구해주는 객체이다.
		
		for (int i = 0; i < arr.length; i++) {
			m.increment(arr[i]);//자료를 넣고
		}
		System.out.println("평균: " + m.getResult());
	
		Variance v = new Variance();
		for (int i = 0; i < arr.length; i++) {
			v.increment(arr[i]);//자료를 넣고
		}
		
		System.out.println("분산: " + v.getResult());


        return "hello(" + v.getResult() + ")";
    }
}