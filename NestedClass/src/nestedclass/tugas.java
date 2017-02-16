package nestedclass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class tugas 
{
    //Comment 1 dibuka
    //Output : Static Nested Class: 4
    //
    //coment 2 di buka
    //error dengan output Static Nested Class: 4
    //Exception in thread "main" java.lang.RuntimeException: Uncompilable source code - non-static method toString() cannot be referenced from a static context
    //	at nestedclass.DemoOuter3.main(Outer3.java:48)
    //C:\Users\Jayuk\AppData\Local\NetBeans\Cache\8.1\executor-snippets\run.xml:53: Java returned: 1
    //BUILD FAILED (total time: 0 seconds)
    //
    //Error karena belum diciptakan objek dari Outer3 melainkan hanya pengaksesan method yang illegal
    //
    //Comment 3 dibuka
    //errorr dengan output Static Nested Class: 4
    //Exception in thread "main" java.lang.RuntimeException: Uncompilable source code - unexpected type
    //required: class,package
    //found:    variable
    //  at nestedclass.DemoOuter3.main(Outer3.java:49)
    //C:\Users\Jayuk\AppData\Local\NetBeans\Cache\8.1\executor-snippets\run.xml:53: Java returned: 1
    //
    //Error karena kelas outer tidak bisa mengakses atribut ataupun variabel dari inner kelas tetapi sebaliknya bisa
    //comment 4 dibuka
    //error, Static Nested Class: 4
    //Exception in thread "main" java.lang.RuntimeException: Uncompilable source code - Erroneous tree type: <any>
    //	at nestedclass.DemoOuter3.main(Outer3.java:50)
    //
    //pengaksesan method yang objeknya belum diciptakan, pengaksesan method yang illegal
    //dalam java untuk mengakses suatu method atau atribut perlu diciptakan dahulu objek yang mempunyai method dan atribut
    //
    //comment 5 dibuka
    //error, Static Nested Class: 4
    //Exception in thread "main" java.lang.RuntimeException: Uncompilable source code - non-static method toString() cannot be referenced from a static context
    //	at nestedclass.DemoOuter3.main(Outer3.java:51)
    //
    //Error karena kelas outer tidak bisa mengakses atribut ataupun variabel dari inner kelas tetapi sebaliknya bisa
    //comment 6 dibuka
    //error, Static Nested Class: 4
    //Exception in thread "main" java.lang.RuntimeException: Uncompilable source code - an enclosing instance that contains nestedclass.Outer3.InnerClass is required
    //	at nestedclass.DemoOuter3.main(Outer3.java:52)
    //
    //Error karena Inner kelas tidak kelas static, jadi Inner kelas membutuhkan reference dari kelas Outer3
    //Solusi 
        //Outer3 outer = new Outer3();
        //Outer3.InnerClass inner = outer.new InnerClass();
}
