import java.util.Arrays;
class Tracing {
    public static void main(String args[]) {
        int[ ] array1 = {2, 4, 1, 3};
        int[ ] array2 = {0, 0, 0, 0};
        int a2 = 0;

        for(int a1 = 1; a1 < array1.length; ++a1){
			System.out.println("a1: " + a1);
			System.out.println("a2: " + a2);
			System.out.println("array1[a1]: " + array1[a1]);
        	if(array1[a1] >= 2){
        		array2[a2] = array1[a1];
				System.out.println("array2[a2]: " + array2[a2]);
        		++a2;
				System.out.println("a2: " + a2);
			}
			System.out.println("------------------");
		}
		System.out.println(Arrays.toString(array2));
    }
}