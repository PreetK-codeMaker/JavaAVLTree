package appDriver;

import avlTree.AvlTree;
import exception.AvlExceptions;

public class main {
    public static void main(String[] args) throws AvlExceptions {
        AvlTree<Integer>d = new AvlTree<>();

        d.add(907);
        d.add(6342);
        d.add(9761);
        d.add(9139);
        d.add(9791);
        d.add(6573);
        d.add(1045);
        d.add(3588);
        d.add(4082);
        d.add(2436);
        d.add(7153);
        d.add(1420);
        d.add(2116);
        d.add(2296);
        d.add(8181);
        d.add(3937);
        d.add(5559);
        d.add(9504);
        d.add(217);
        d.add(2310);
        d.add(3446);
        d.add(5893);
        d.add(3929);
        d.add(4927);
        d.add(7492);
        d.add(7452);
        d.add(2920);
        d.add(0);
        d.add(2650);
        d.add(6806);
        d.add(5310);
        d.add(7878);
        d.add(8146);
        d.add(8616);
        d.add(3810);
        d.add(9120);
        d.add(8486);
        d.add(3748);
        d.add(1109);
        d.add(1249);
        d.add(9387);
        d.add(458);
        d.remove(8486);
        d.postOrder();
    }

}
