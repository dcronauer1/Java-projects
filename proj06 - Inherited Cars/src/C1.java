package p1;

public class C1 {

    int i = 5;

    public int j = 10;

}



package p2;

public class Test {

    public static void main(String[] args) {

        C2 c2 = new C2();

        c2.m1();

    }

}

package p2;

import p1.C1;

public class C2{

    public void m1() {

        C1 c1 = new C1();

        this.m2(c1);

        System.out.println(c1.i+“, ”+c1.j);

    }

    private void m2(C1 c) {

        c.i = 0;

        int j = c.j;

        j = 99;

    }

}