package niuke;

import java.util.*;


public class LRUImpl {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */

    /**
     * 描述: 此处生成对应的node节点, 节点是用于构造双向链表的, 因此有前后指针, 方便后续的删除操作
     */
    class Node{
        private int val;
        private int key;
        private Node pre = null;
        private Node next = null;
        private Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> map = new HashMap<>();  // 建立hashmap用于快速的查找对应的key值
    private Node head = new Node(-1, -1); // 头结点
    private Node tail = new Node(-1, -1);  // 尾节点
    private int k = 0;  // 记录LRU最多缓存的单元数目

    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.k = k;
        // 最开始的时候头尾节点相互的指向对方
        head.next = tail;
        tail.pre = head;

        // 获取数组中开头为2(get操作)的元素个数
        int len = (int)Arrays.stream(operators).filter(x->x[0] == 2).count();  // 主要用于后续创建对应的get出的值
        int[] res = new int[len];

        for(int i=0,j=0; i< operators.length; i++){
            if(operators[i][0] == 1){
                set(operators[i][1], operators[i][2]);
            }else{
                res[j++] = get(operators[i][1]);
            }
        }

        return res;
    }

    public void set(int key, int val){
        // 判断在cache中是否存在对应的key值
        Node node = null;
        // 检查map中是否已经包含了对应的key值
        if(map.containsKey(key)){ // 包含了key的话就将val进行更新, 并将该节点删除, 放到头结点中
            node = map.get(key);
            node.val = val;
            // 删除该节点
            node.next.pre = node.pre;
            node.pre.next = node.next;

            // 将node节点提到第一个
            moveToFirst(node);
        }else{
            // 判断容量是否超出对应的限制
            if(map.size() == k){
                // 容量超出限制的话就需要删除最少使用的节点
                int keyremove = tail.pre.key;
                map.remove(keyremove);
                // 将该节点从cache中删除掉
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
            }
            node = new Node(key, val);
            map.put(key, node);
            moveToFirst(node);
        }
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            Node node = map.get(key);
            // 删除该节点
            node.next.pre = node.pre;
            node.pre.next = node.next;
            // 插入到表头
            moveToFirst(node);
            return node.val;
        }
    }

    // 将节点插入到表头, 注意不要让链表断掉, 最好的原则就是把不知名的那个节点先跟需要插入的节点连接上, 然后再对头结点进行连接
    public void moveToFirst(Node node){
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }
}